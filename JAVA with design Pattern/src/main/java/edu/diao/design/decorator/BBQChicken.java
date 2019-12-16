package edu.diao.design.decorator;

public class BBQChicken extends Pizza{

	public BBQChicken() {
		description = "BBQChicken";
	}
	
	public int getCost() {
		return 300;
	}
}
