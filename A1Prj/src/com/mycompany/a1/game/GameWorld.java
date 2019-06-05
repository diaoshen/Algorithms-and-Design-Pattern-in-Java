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
	private ArrayList<GameObject> asteroids;// arraylist of asteroids 
	private ArrayList<GameObject> playerShips; // arraylist of playerships
	private ArrayList<GameObject> nonPlayerShips;
	private ArrayList<GameObject> spaceStations;
	private ArrayList<GameObject> playerMissiles;
	
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
		asteroids = new ArrayList<GameObject>();
		playerShips = new ArrayList<GameObject>();
		nonPlayerShips = new ArrayList<GameObject>();
		spaceStations = new ArrayList<GameObject>();
		playerMissiles = new ArrayList<GameObject>();
	}
	
	/*
	 * Game tick
	 */
	public void tick() {
		timer++;
	}
	
	//Methods to manipulate game world objects 
	public void addAsteroid() {
		asteroids.add(new Asteroids());
	}
	public void addPlayerShip() {
		playerShips.add(PlayerShip.getInstance());
	}
	public void addNonPlayerShip() {
		nonPlayerShips.add(new NonPlayerShip());
	}
	public void addSpaceStation() {
		spaceStations.add(new SpaceStation());
	}
	public void addPlayerMissile() {
		if(playerShips.isEmpty()) {
			System.out.println("There exists no playership to fire missile");
			return;
		}
		if(((PlayerShip) playerShips.get(0)).getMissileCount() > 0) {
			playerMissiles.add(new Missiles((PlayerShip) playerShips.get(0)));
		}else {
			System.out.println("PlayerShip ran out of missiles");
		}	
	}
	public void addNonPlayerMissile() {
		if(nonPlayerShips.isEmpty()) {
			System.out.println("There exists no non-player ship to fire missile");
			return;
		}
		if(((NonPlayerShip) nonPlayerShips.get(0)).getMissileCount() > 0) {
			playerMissiles.add(new Missiles((NonPlayerShip) nonPlayerShips.get(0)));
		}else {
			System.out.println("Non-Player Ship ran out of missiles");
		}
	}

	public void printDisplay() {
		System.out.println( "Current Score=" + this.playerScore +
							" Number of missile in ship=" + ((Ship) playerShips.get(0)).getMissileCount() + 
							" Current elapased time=" + this.timer + 
							" Number of lives=" + ((PlayerShip) playerShips.get(0)).getLife()
				);
	}
	
	public void printMap() {
		printHelper(asteroids);
		printHelper(playerShips);
		printHelper(nonPlayerShips);
		printHelper(spaceStations);
		printHelper(playerMissiles);
	}
	private void printHelper(ArrayList<GameObject> list) {
		for(int i = 0 ; i< list.size() ; i++) {
			System.out.println(list.get(i).toString());
		}
	}
}
