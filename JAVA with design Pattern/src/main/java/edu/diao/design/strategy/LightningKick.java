package edu.diao.design.strategy;

public class LightningKick implements KickBehavior{

	@Override
	public void kick() {
		System.out.println("Lightning Kick");
	}	

}
