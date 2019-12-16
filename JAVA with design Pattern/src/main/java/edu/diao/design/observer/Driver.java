package edu.diao.design.observer;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//Create Listeners
		Listener1 type1Listener1 = new Listener1();
		Listener1 type1Listener2 = new Listener1();
		
		Listener2 type2Listener1 = new Listener2();
		Listener2 type2Listener2 = new Listener2();
		
		
		//Create subject
		GPS tracker = new GPS();
		//Add listeners to subject
		tracker.registerListener(type1Listener1);
		tracker.registerListener(type1Listener2);
		tracker.registerListener(type2Listener1);
		tracker.registerListener(type2Listener2);
		//Change data | test listener
		tracker.changePosition(5, 10);
		//remove listener and repeat
		tracker.unregisterListrner(type2Listener2);
		tracker.changePosition(2, 10);
	}

}
