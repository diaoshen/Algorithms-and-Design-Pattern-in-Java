package edu.diao.design.strategy;

public abstract class Character {
	KickBehavior kickbehavior;
	JumpBehavior jumpbehavior;
	
	public Character(KickBehavior newKickBehavior , JumpBehavior newJumpBehavior) {
		kickbehavior = newKickBehavior;
		jumpbehavior = newJumpBehavior;
	}
	
	void punch() {
		System.out.println("Default punch");
	}
	void kick() {
		kickbehavior.kick();
	}
	void jump() {
		jumpbehavior.jump();
	}
	void roll() {
		System.out.println("Default roll");
	}
	void setJumpBehavior(JumpBehavior newJumpBehavior) {
		this.jumpbehavior = newJumpBehavior;
	}
	void setKickBehavior(KickBehavior newKickBehavior) {
		this.kickbehavior = newKickBehavior;
	}
	public abstract void display();
}
