package edu.diao.javaLearn;

public abstract class Car implements Engine , RaceCarEngine , myRaceCarEngine{ //Abstract class can implement many Interface
	/*
	 * MEMBERS IN ABSTRACT CLASS CAN BE PUBLIC,PRIVATE,PROTECTED
	 */
	
	/*
	 * Variables can be : Final | STATIC | BOTH | NEITHER
	 */
	
	//Final , Non Static
	final int cost = 10;
	//Final , Static
	final static String owner = "ME";
	//Non Final , Static
	static int carCount = 0;
	//Non Final  , Non Static
	int repairFee = 20;

	
	/*
	 * <METHODS/FUNCTION>
	 * Abstract , Non-Abstract 
	 * Static
	 */
	
	 //Abstract
	 abstract void print();
	 //Non Abstract
	 void print2(){
		 //MUST PROVIDE BODY
	 }
	 //Static
	 static void print3() {
		 //MUST PROVIDE BODY
	 }

		 
	 
	 
	/*
	 * Can provide implementation of interface if wanted to ,  then any class extends this will auto have all interface functions
	 */
	 public void setHP() {
		 //TODO
	 }

	 
	 

}
