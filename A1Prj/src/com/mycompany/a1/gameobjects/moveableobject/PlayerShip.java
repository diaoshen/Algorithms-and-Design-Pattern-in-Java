package com.mycompany.a1.gameobjects.moveableobject;

import com.codename1.charts.util.ColorUtil;
import com.mycompany.a1.game.GameWorld;

@SuppressWarnings("unused")
public class PlayerShip extends Ship implements ISteerable{

	//Singleton PlayerShip
	private volatile static PlayerShip ps;
	private PlayerShip() {
		super(ColorUtil.GREEN,0,0,x,y,10,10);//Color,Speed,Direction,LocationX,LocationY,missileCount,MaxMissileCount
		life = 3;
		ml = new MissileLauncher(this.getSpeed(),this.getDirection());
		setMaxMissileCount(10);
		setMissileCount(10);
		System.out.println("Added Playership");
		System.out.println(this.toString()); //DEBUG LINE
	}
	public static PlayerShip getInstance() {
		if(ps == null) {
			synchronized (PlayerShip.class) {
				if(ps == null)
					ps = new PlayerShip();
			}
		}else {
			System.out.println("PlayerShip Already Exists...");
		}
		return ps;
	}
	
	
	final static int x = 512;
	final static int y = 384;
	
	private int life;
	private MissileLauncher ml;
	

	
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
	
	public MissileLauncher getMl() {
		return this.ml;
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		
	}
	
	@Override 
	public String toString() {
		return (
			"Player Ship: loc=" + Math.round(this.getX()*10.0)/10.0 + "," + Math.round(this.getY()*10.0)/10.0 + 
			" color=" + this.getColorToString() +
			" speed=" + this.getSpeed() +
			" dir=" + this.getDirection() +
			" missiles=" + this.getMissileCount() + 
			" Missile Launcher dir = " + this.ml.getDirection()
		);				
	}
}
