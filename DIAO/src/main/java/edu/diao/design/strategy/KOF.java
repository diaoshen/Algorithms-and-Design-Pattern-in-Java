package edu.diao.design.strategy;

public class KOF {

	public static void main(String[] args) {
		
		//Create some behaviors 
		JumpBehavior shortJump = new ShortJump();
		JumpBehavior longJump = new LongJump();
		KickBehavior tornadoKick = new TornadoKick();
		KickBehavior lightningKick = new LightningKick();
		
		//Create character with desired behaviors 
		Character Rugal = new Rugal(tornadoKick,longJump);
		Rugal.display();
		
		//TEST behavior 
		Rugal.punch();
		Rugal.kick();
		Rugal.jump();
		
		//Change behavior dynamically
		Rugal.setJumpBehavior(shortJump);
		Rugal.jump();
		
		//Change it again
		Rugal.setKickBehavior(lightningKick);
		Rugal.kick();
		
	}

}
