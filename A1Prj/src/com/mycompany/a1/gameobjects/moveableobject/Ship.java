package com.mycompany.a1.gameobjects.moveableobject;

public abstract class Ship extends MoveableObject {

	private int MAX_MISSILE_COUNT;
	private int missileCount;
	
	
	public Ship(int objectColor) {
		super(objectColor);
		// TODO Auto-generated constructor stub
	}
	
	public Ship(int objectColor, int speed, int direction, double x, double y) {
		super(objectColor, speed, direction, x, y);
		// TODO Auto-generated constructor stub
	}
	
	
	void fireMissile() {
		missileCount--;
	}

	void reload() {
		missileCount = MAX_MISSILE_COUNT;
	}
	
	private boolean isEmpty() { return missileCount == 0 ; }
	
	public int getMissileCount() {
		return this.missileCount;
	}
	
	public void setMissileCount(int x) {
		missileCount = x;
	}
	
	public int getMaxMissileCount() {
		return MAX_MISSILE_COUNT;
	}
	
	public void setMaxMissileCount(int x) {
		x = MAX_MISSILE_COUNT;
	}
	
	public void decrementMissile() {
		missileCount--;
	}
	
	



}
