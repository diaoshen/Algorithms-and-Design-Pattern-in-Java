package edu.diao.design.decorator;

public abstract class Pizza {
	
	//Abstract Pizza
	String description = "Unknown Pizza";
	
	public String getDescription() {
		return description;
	}
	
	public abstract int getCost();
}
