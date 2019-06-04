package com.mycompany.a1.game;

import java.util.ArrayList;
import java.util.Random;
import com.mycompany.a1.gameobjects.GameObject;
import com.mycompany.a1.gameobjects.moveableobject.Asteroids;


@SuppressWarnings("unused")
public class GameWorld {

	final private int gameWorldWidth = 1024;
	final private int gameWorldHeight = 768;
	
	private int playerScore;
	private ArrayList<GameObject> asteroids;// arraylist of asteroids 
	
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
		asteroids = new ArrayList<GameObject>();
	}
	
	//Methods to manipulate game world objects 
	public void addAsteroid() {
		asteroids.add(new Asteroids());
	}
}
