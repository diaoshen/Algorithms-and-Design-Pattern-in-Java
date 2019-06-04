package com.mycompany.a1.gameobjects.moveableobject;

import java.util.Random;
import com.mycompany.a1.gameobjects.GameObject;

public abstract class MoveableObject extends GameObject {

	private int speed;
	private int direction;
	
	public MoveableObject(int objectColor) {
		super(objectColor);
		this.speed = new Random().nextInt(21);
		this.direction = new Random().nextInt(360);
	}
	public MoveableObject(int objectColor , int speed, int direction , double x , double y) {
		super(objectColor, x , y);
		this.speed = speed;
		this.direction = direction;
	}

	
	public void move() {
		//TODO
	}
	
	public int getSpeed() {
		return this.speed;
	}
	public void setSpeed(int x) {
		this.speed = x;
	}
	public int getDirection() {
		return this.direction;
	}
	public void setDirection(int x) {
		this.direction = x;
	}
	

}
