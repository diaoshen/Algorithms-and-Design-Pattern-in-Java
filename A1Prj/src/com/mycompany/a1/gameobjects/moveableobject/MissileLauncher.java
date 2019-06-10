package com.mycompany.a1.gameobjects.moveableobject;

public class MissileLauncher implements ISteerable{

	private int speed;
	private int direction;
	private int delta; // Rotation amount 
	
	
	public MissileLauncher(int speed , int direction) {
		this.speed = speed;
		this.direction = direction;
		this.delta = 5;
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
	public void rotate() {
		this.direction += 5;
		this.direction %= 360;
		
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
