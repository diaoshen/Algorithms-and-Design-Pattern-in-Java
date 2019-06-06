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

	final private int gameWorldWidth = 1024;
	final private int gameWorldHeight = 768;
	
	
	private int playerScore;
	private int timer = 0;

	private ArrayList<GameObject> gameObjects;
	
	//Singleton GameWorld
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
	 * Initialize game objects
	 */
	public void init() {
		this.playerScore = 0;
		this.timer = 0;

		
		gameObjects = new ArrayList<GameObject>();
	}
	
	/*
	 * Game tick
	 */
	public void tick() {
		timer++;
		//Call Move()
	}
	
	//Methods to manipulate game world objects 
	public void addAsteroid() {
		//asteroids.add(new Asteroids())
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
					//System.out.println("Player ship fired missile");
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
				}
			}
			return;
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

}
