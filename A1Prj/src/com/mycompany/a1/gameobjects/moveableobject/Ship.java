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
	
	int getMissileCount() {
		return this.missileCount;
	}
	
	void setMissileCount(int x) {
		missileCount = x;
	}
	
	



}
