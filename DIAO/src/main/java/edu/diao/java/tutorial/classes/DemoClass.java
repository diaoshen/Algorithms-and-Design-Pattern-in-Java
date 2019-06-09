package edu.diao.java.tutorial.classes;
/**
 * 
 * @author DIAO
 *
 *	This is a DEMO to show classes in JAVA.
 *
 *	This file contains common practices in writing a class
 */
public class DemoClass {

	@SuppressWarnings("unused")
	private int x,y;
	//Constructor
	public DemoClass() {
		this.x = 5;
		this.y = 0;
	}
	public DemoClass(int x) {
		this.x = x;
	}
	public DemoClass(int x , int y) {
		this.x = x;
		this.y = y;
	}
	public DemoClass(double x) {
		this(5,0);
	}
	
	//Copy Constructor 
	public DemoClass(DemoClass otherObj) {
		this.x = otherObj.x;
	}
	
	//Copy method to copy the current class object
	public DemoClass copy() {
		return new DemoClass(this.x);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DemoClass a = new DemoClass();
		DemoClass b = new DemoClass(10);
		DemoClass c = new DemoClass(b);
		System.out.println("Object a's x : " + a.x);
		System.out.println("Object b's x : " + b.x);
		System.out.println("Object c's x : " + c.x);
		
		a = b.copy();
		System.out.println("Object a's x : " + a.x);
		
		
		if(a instanceof DemoClass) {
			System.out.println("object a is an instance of DemoClass");
		}
		if(a instanceof Object) {
			System.out.println("object a is an instance of Object");
		}
	}

}
