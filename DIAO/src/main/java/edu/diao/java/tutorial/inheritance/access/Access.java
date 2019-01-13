package edu.diao.java.tutorial.inheritance.access;
/*
 *Refer pg 649 for Table 10-3 and 10-4 
 * 						
 */
public class Access {
	public int x; //Anyone can access
	@SuppressWarnings("unused")
	private int y; //Only Access Object can access 
	protected int z; //Any class in same package and subclass in same/different package
	
	public void x() {}; //Anyone can access
	@SuppressWarnings("unused")
	private void y() {}; //Only Access Object can access
	protected void z() {}; //Any class in same package and subclass in same/different package
	
	int k; //Default to package access , NOTE: subclass not in same package cannot access
	void k() {}; //Default to package access
	
}
