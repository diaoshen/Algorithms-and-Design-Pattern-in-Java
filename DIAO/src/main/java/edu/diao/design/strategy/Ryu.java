package edu.diao.design.strategy;

public class Ryu extends Character {

	public Ryu(KickBehavior kickbehavior , JumpBehavior jumpbehavior) {
		super(kickbehavior , jumpbehavior);
	}
	
	
	
	@Override
	public void display() {
		System.out.println("Ryu");
	}
	
}
