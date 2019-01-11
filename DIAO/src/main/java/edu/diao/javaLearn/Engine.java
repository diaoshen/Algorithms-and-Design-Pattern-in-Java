package edu.diao.javaLearn;

public interface Engine {
	/*
	 * ALL MEMEBERS ARE PUBLIC BY DEFAULT 
	 */
	
	
	/*
	 * Interface can have only static and/or  final variables 
	 */
	
	//Static
	static int hp = 100;
	//Final 
	final int gas = 1; // same as int gas = 1;
	//Static Final 
	static final int a = 1000;
	
	
	/*
	 * Interface methods can only be abstract(by default) OR Static OR DEFAULT
	 */
	
	//ABSTRACT
	abstract void setHP(); //same as void setHP();

	//STATIC
	static void blah() {
		//PROVIDE BODY HERE
	}
	
	//DEFAULT
	default void print10() {
		//TODO;
	}
		
}
