package com.mycompany.a1.gameobjects.moveableobject;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

public class Asteroids extends MoveableObject {
	//Size 6-30 
	//Random size,speed,direction
	
	int size;
	
	public Asteroids() {
		super(ColorUtil.BLACK);
		final int MIN_SIZE = 6;
		final int MAX_SIZE = 30;
		this.size =  new Random().nextInt(MAX_SIZE - MIN_SIZE + 1) + MIN_SIZE;
		this.toString();
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override 
	public String toString() {
		return (
			"Asteroid: loc=" + Math.round(this.getX()) + "," + Math.round(this.getY()) + 
			"color=" + this.getColorToString() +
			"dir=" + this.getDirection() +
			"size=" + this.getSize()
		);				
	}
	
}
