package edu.diao.java.tutorial.classes;



/*
 * Demo showing Anonymous Class and Lambda Expression and Functional Interfaces
 * 
 * Require File : Interface IntCalculator.java 
 * 
 */
public class AnonymousClassDemo {

	
	
	public static void main(String[] args) {
		
		/*
		 * Inner class usage 1
		 */

		IntCalculator square = new IntCalculator() {

			@Override
			public int calculate(int number) {
				return number * number;
			}
			
		};
		
		System.out.println("Square 5 = " + square.calculate(5));
		
		/*
		 * Inner class usage 2
		 */
		System.out.println("Anonymous  6 = " + new IntCalculator() {

				@Override
				public int calculate(int number) {
					// TODO Auto-generated method stub
					return 1000+number;
				}
				
			}.calculate(6)
		);
		
		/*
		 *  Functional Interface = Interface with only one abstract method , Lambda expression can be used to simplify
		 *  
		 *  General syntax for lambda expression is   variable -> expression
		 *  Lambda expression defines a anonymous method ( a function with no name), before the interface has method named
		 *  public int calculate(int number). Now the name of the function is not required.
		 *  
		 *  
		 *  With lambda expression the above  usage 1 can be simplify to be this :
		 */
		
		
		//Usage 1 using lambda expression
		IntCalculator square2 = num -> num * num;
		System.out.println("Square2 5 = " + square2.calculate(5));

		
		
	}//END MAIN

}
