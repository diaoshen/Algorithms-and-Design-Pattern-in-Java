package edu.diao.design.composite;
/*
 * Dev is a Employee object , so Employee variable can point to Dev Object , Achieveing Polymorphism
 */
public class Dev implements Employee {
	private String name;
	
	public Dev(String name) {
		this.name = name;
	}
	
	public void showEmployeeDetails() {
		System.out.println("I'm Dev : " + name);
	}
}
