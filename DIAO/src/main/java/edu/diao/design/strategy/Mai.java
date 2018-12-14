package edu.diao.design.strategy;

public class Mai extends Character{

	public Mai(KickBehavior kickbehavior , JumpBehavior jumpbehavior) {
		super(kickbehavior , jumpbehavior);
	}
	
	
	
	@Override
	public void display() {
		System.out.println("Mai");
	}
	
}
