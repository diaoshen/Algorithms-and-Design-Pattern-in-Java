package com.mycompany.a1.gameobjects.moveableobject;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends MoveableObject{

	final static int x = 512;
	final static int y = 384;
	
	private int life;
	private MissileLauncher ml;
	
	public PlayerShip(int objectColor) {
		super(ColorUtil.GREEN,0,0,x,y);
		life = 3;
	}
	
	public void increaseSpeed() {
		this.setSpeed(getSpeed()+1);
	}
	public void decreaseSpeed() {
		this.setSpeed(getSpeed()-1);
	}
	
	//TODO RotateMissileLauncher 
	
	public int getLife() {
		return life;
	}
	
	public void setLife(int x) {
		life = x;
	}
	
	
}
