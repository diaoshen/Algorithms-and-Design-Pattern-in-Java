package edu.diao.java.tutorial.classes.overload;

/**
 * 
 * @author DIAO
 *	
 *	Overloading means function can have same name but must be different param signature.
 *
 *	overload even works for constructor .. afterall constructor is just a function
 */
public class overload {

	
	/*
	 * Example of overloading constructor
	 */
	public overload() {
		System.out.println("overload 1");
	}
	public overload(int x) {
		System.out.println("overload 2 + " + x);
	}
	
	/*
	 * Example of overloading functions , both call add but with different signature
	 */
	public int add(int x , int y) { return x+y; }
	public String add(String x , String y) { return x+y; }
	
	
	public static void main(String[] args) {
		overload a = new overload();
		overload b = new overload(5);
		
		System.out.println(a.add(5, 6));
		System.out.println(b.add("Blah", " Blah2"));
	}

}
