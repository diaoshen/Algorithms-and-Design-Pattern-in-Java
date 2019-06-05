package com.mycompany.a1.gameobjects.moveableobject;

public class MissileLauncher implements ISteerable{

	private int speed;
	private int direction;
	
	
	public MissileLauncher(int speed , int direction) {
		this.speed = speed;
		this.direction = direction;
	}
	
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getDirection() {
		return this.direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		
	}

}
