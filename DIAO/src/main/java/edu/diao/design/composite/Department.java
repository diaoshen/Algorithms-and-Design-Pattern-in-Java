package edu.diao.design.composite;

import java.util.ArrayList;
import java.util.List;
/*
 * Department is a Employee object
 */
public class Department implements Employee{

	private List<Employee> employeeList = new ArrayList<Employee>();
	
	@Override
	public void showEmployeeDetails() {
		// TODO Auto-generated method stub
		for(Employee e : employeeList) {
			e.showEmployeeDetails();
		}
	}
	
	/*
	 * Takes a Employee object and add to ArrayList , so the Employee objects can be a Department , Manager , Dev Object
	 * all of these possible objects are then store to this department's employeelist 
	 */
	public void addEmployee(Employee newEmployee) {
		employeeList.add(newEmployee);
	}

}
