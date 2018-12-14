package edu.diao.design.composite;

/*
 * Since Manager implement Employee interface/class , that means Employee reference variable can point to Manager Object
 */
public class Manager implements Employee{
	private String name;
	
	public Manager(String name) {
		this.name = name;
	}
	
	public void showEmployeeDetails() {
		System.out.println("I'm Manager : " + name);
	}
}
