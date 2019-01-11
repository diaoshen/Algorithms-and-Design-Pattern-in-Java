package edu.diao.javaLearn;

public interface myRaceCarEngine extends RaceCarEngine , Engine{ //Multiple inheritance between interfaces is allowed

	
	final int a = 5;
	static int b = 10;
	public static void walk() {
		System.out.println("ASD");
	}
	
	
}
