package com.mycompany.a1.game;

import java.util.ArrayList;
import java.util.Random;
import com.mycompany.a1.gameobjects.GameObject;
import com.mycompany.a1.gameobjects.fixedobject.SpaceStation;
import com.mycompany.a1.gameobjects.moveableobject.Asteroids;
import com.mycompany.a1.gameobjects.moveableobject.Missiles;
import com.mycompany.a1.gameobjects.moveableobject.NonPlayerShip;
import com.mycompany.a1.gameobjects.moveableobject.PlayerShip;
import com.mycompany.a1.gameobjects.moveableobject.Ship;


@SuppressWarnings("unused")
public class GameWorld {

	/*
	 * GameWorld Fields 
	 */
	final private int gameWorldWidth = 1024;
	final private int gameWorldHeight = 768;
	private int playerScore;
	private int timer = 0;
	private ArrayList<GameObject> gameObjects; //Collection of game objects
	
	//Singleton GameWorld to enforce only instance of gameworld can ever be created.
	private volatile static GameWorld gw;
	private GameWorld() {};
	public static GameWorld getInstance() {
		if(gw == null) {
			synchronized (GameWorld.class) {
				if(gw == null)
					gw = new GameWorld();
			}
		}
		return gw;
	}
	
	/*
	 * Initialize Game
	 */
	public void init() {
		this.playerScore = 0;
		this.timer = 0;
		gameObjects = new ArrayList<GameObject>();
	}
	
	
	
	/*
	 * GAME METHODS :
	 */
	
	
	/*
	 * Game tick
	 */
	public void tick() {
		timer++;
		//TODO Call Move()
	}
	
	
	public void addAsteroid() {
		gameObjects.add(new Asteroids());
	}
	public void addPlayerShip() {
		//playerShips.add(PlayerShip.getInstance());
		gameObjects.add(PlayerShip.getInstance());
	}
	public void addNonPlayerShip() {
		gameObjects.add(new NonPlayerShip());
	}
	public void addSpaceStation() {
		gameObjects.add(new SpaceStation());
	}
	public void addPlayerMissile() {	
	
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip ) {
				if(((Ship) gameObjects.get(i)).getMissileCount() > 0 ) {
					gameObjects.add(new Missiles((PlayerShip) gameObjects.get(i)));
					//Print Fired Missile
					System.out.println("Player ship fired missile");
					System.out.println(((Ship)gameObjects.get(i)).getMissileCount() + " missiles left");
				}else {
					//Print Ran out of missile 
					System.out.println("Player ship ran out of missile");
				}
				return;
			}
		}
		//No PlayerShip
		System.out.println("There exists no playership to fire missile");
		return;
	
	}
	public void addNonPlayerMissile() {
		
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof NonPlayerShip ) {
				if(((Ship) gameObjects.get(i)).getMissileCount() > 0) {
					gameObjects.add(new Missiles((NonPlayerShip) gameObjects.get(i)));
					System.out.println("Non-Player ship fired missile");
					System.out.println(((Ship)gameObjects.get(i)).getMissileCount() + " missiles left");
				}else {
					System.out.println("Non-Player ship ran out of missile");
				}
				return;
			}
		}
		//No PlayerShip
		System.out.println("There exists no non-playership to fire missile");
		return;
	}

	public void printDisplay() {
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				System.out.println( "Current Score=" + this.playerScore +
						" Number of missile in ship=" + ((Ship) gameObjects.get(i)).getMissileCount() + 
						" Current elapased time=" + this.timer + 
						" Number of lives=" + ((PlayerShip) gameObjects.get(i)).getLife()
				);
			}
		}

	}
	
	public void printMap() {
		for(int i = 0 ; i< gameObjects.size() ; i++) {
			System.out.println(gameObjects.get(i).toString());
		}
	}
	
	public void rotatePlayerMl() {
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) gameObjects.get(i);
				ps.getMl().rotate();
				System.out.println("PlayerShip rotated by 5 degree");
				System.out.println(ps.toString());
			}
		}
	}
	public void playerShipReload() {
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				PlayerShip ps = (PlayerShip) gameObjects.get(i);
				ps.reload();
				System.out.println("PlayerShip's missile has been reloaded");
				System.out.println(ps.toString());
				return;
			}
		}
		System.out.println("No Playership to reload");
	}
	public void killAsteroid() { 
		int ps = -1;
		int asteroid = -1;
		int psMissile =  -1;
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				ps = i;
			}
			if(gameObjects.get(i) instanceof Asteroids && asteroid == -1) {
				asteroid = i;
			}
			if(gameObjects.get(i) instanceof Missiles && psMissile == -1) {
				psMissile = i;
			}
		}
		
		if(ps != -1 && asteroid != -1 && psMissile != -1) {
			gameObjects.remove(asteroid);
			((Missiles) gameObjects.get(psMissile)).getOwner().decrementMissile();
			gameObjects.remove(psMissile);
			this.playerScore += 10;
		}else {
			System.out.println("Error : Asteroid or Playership or PlayerMissile does not exists");
		}
		
	}
	public void killNonPlayerShip() {
		int ps = -1;
		int nps = -1;
		int psMissile =  -1;
		
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof PlayerShip) {
				ps = i;
			}
			if(gameObjects.get(i) instanceof NonPlayerShip && nps == -1) {
				nps = i;
			}
			if(gameObjects.get(i) instanceof Missiles && psMissile == -1) {
				psMissile = i;
			}
		}
		
		if(ps != -1 && nps != -1 && psMissile != -1) {
			gameObjects.remove(nps);
			((Missiles) gameObjects.get(psMissile)).getOwner().decrementMissile();
			gameObjects.remove(psMissile);
			this.playerScore += 10;
		}else {
			System.out.println("Error : NonPlayerShip or Playership or PlayerMissile does not exists");
		}
	}
	
	public void killPlayerShipByMissile() {
		int ps = -1;
		int nps = -1;
		int npsMissile = -1;
		
        for(int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i) instanceof PlayerShip && ps == -1) {
                ps = i;
            }
            if(gameObjects.get(i) instanceof Missiles &&  npsMissile == -1) {
                if(((Missiles) gameObjects.get(i)).getOwner() instanceof NonPlayerShip) {
                  	npsMissile = i;
                }
            }
            if(gameObjects.get(i) instanceof NonPlayerShip && nps == -1) {
                nps = i;
            }
            
        }
        if(ps != -1 && nps != -1 && npsMissile == -1) {
        	((Missiles) gameObjects.get(npsMissile)).getOwner().decrementMissile();
        	gameObjects.remove(npsMissile);
        	if(((PlayerShip) gameObjects.get(ps)).getLife() > 0) {
            	((PlayerShip) gameObjects.get(ps)).respawn();
        	}else {
        		gameObjects.remove(ps);
        		System.out.println("Game Over");
        	}
        }else {
        	System.out.println("Either PlayerShip,NonplayerShip,NonPlayerShip's missile does not exist");
        }

		
	}
	public void killPlayerShipByAsteroid() {
		//Kill asteroid 
		//Kill decrease life 
		int ps = -1;
		int asteroid = -1;
		
        for(int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i) instanceof PlayerShip && ps == -1) {
                ps = i;
            }
            if(gameObjects.get(i) instanceof Asteroids && asteroid == -1) {
            	asteroid = i;
            }
            
        }
        if(ps != -1 && asteroid != -1){
        	if(((PlayerShip) gameObjects.get(ps)).getLife() > 0) {
            	((PlayerShip) gameObjects.get(ps)).respawn();
        	}else {
        		gameObjects.remove(ps);
        		System.out.println("Game Over");
        	}
        	gameObjects.remove(asteroid);
        }else {
        	System.out.println("Either PlayerShip or Asteroid does not exist");
        }
	}
	public void killPlayerShipByNPS() {
		int ps = -1;
		int nps = -1;
		
        for(int i = 0; i < gameObjects.size(); i++) {
            if(gameObjects.get(i) instanceof PlayerShip && ps == -1) {
                ps = i;
            }
            if(gameObjects.get(i) instanceof NonPlayerShip && nps == -1) {
            	nps = i;
            }
            
        }
        if(ps != -1 && nps != -1){
        	if(((PlayerShip) gameObjects.get(ps)).getLife() > 0) {
            	((PlayerShip) gameObjects.get(ps)).respawn();
        	}else {
        		gameObjects.remove(ps);
        		System.out.println("Game Over");
        	}
        	gameObjects.remove(nps);
        }else {
        	System.out.println("Either PlayerShip or NonPlayerShip does not exist");
        }
		
	}
	public void asteroidCollision() {
		int asteroid1 = -1;
		int asteroid2 =  -1;
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Asteroids && asteroid1 == -1) {
				asteroid1 = i;
			}
			if(gameObjects.get(i) instanceof Asteroids && asteroid2 == -1) {
				asteroid2 = i;
			}
		}
		
		if(asteroid1 != -1 && asteroid2 != -1) {
			gameObjects.remove(asteroid1);
			gameObjects.remove(asteroid2);

		}else {
			System.out.println("Error : NO 2 Asteroid to kill each other");
		}
		
	}
	public void killNonPlayerShipByAsteroid() {
		int asteroid = -1;
		int nps =  -1;
		for(int i = 0 ; i < gameObjects.size(); i++) {
			if(gameObjects.get(i) instanceof Asteroids && asteroid == -1) {
				asteroid = i;
			}
			if(gameObjects.get(i) instanceof NonPlayerShip && nps == -1) {
				nps = i;
			}
		}
		
		if(asteroid != -1 && nps != -1) {
			gameObjects.remove(asteroid);
			gameObjects.remove(nps);

		}else {
			System.out.println("Error : NO asteroid or NonPlayerShip to kill each other");
		}
		
	}
	
	
	
	
}//END GameWorld
