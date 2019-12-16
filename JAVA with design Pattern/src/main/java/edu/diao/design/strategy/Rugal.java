package edu.diao.design.strategy;

public class Rugal extends Character {

	public Rugal(KickBehavior kickbehavior , JumpBehavior jumpbehavior) {
		super(kickbehavior , jumpbehavior);
	}
	
	
	
	@Override
	public void display() {
		System.out.println("Rugal");
	}
	
}
