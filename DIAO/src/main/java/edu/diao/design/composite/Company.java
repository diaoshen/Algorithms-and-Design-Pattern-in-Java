package edu.diao.design.composite;

public class Company {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dev dev1 = new Dev("Mike");
		Dev dev2 = new Dev("Jab");
		Department devDept = new Department();
		devDept.addEmployee(dev1);
		devDept.addEmployee(dev2);
		
		Manager m1 = new Manager("Jason");
		Manager m2 = new Manager("Kimmy");
		Department mDept = new Department();
		mDept.addEmployee(m1);
		mDept.addEmployee(m2);
		
		
		//Composite Deparmtnet
		
		Department master = new Department();
		master.addEmployee(mDept);
		master.addEmployee(devDept);
		master.addEmployee(new Dev("Bitch"));
		master.addEmployee(new Manager("Nigga"));
		
		master.showEmployeeDetails();
		
	}

}
