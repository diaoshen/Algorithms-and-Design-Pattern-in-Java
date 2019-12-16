package edu.diao.java.tutorial.inheritance.override;
/*
 * Overload vs Override
 * 		two methods have same name but diff signature  = Overload
 * 		two methods have same signature = Override
 */
public class subDemo extends superDemo {
	//Override superDemo.print()
	public void print() {
		System.out.println("Print subDemo");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new subDemo().print();
		
	}

}
