package edu.diao.java.tutorial.exception;

/**
 * 
 * @author DIAO
 *
 *	@Syntax : 
 *
 *	try
 *	{
 *		statement1
 *		statement2 //If statement1 throws exception object , this statement is skipped.
 *		...
 *	}
 *	catch (ExceptionType1 | type2 | type3 | ... paramterName) //Can have more catch block to catch more than 1 exception type
 *	{
 *		(catch block statements...)
 *	}
 *	finally
 *	{
 *		//this block runs regardless of whether an exception is catch or not.
 *	}
 *	statement 3 //If try block didn't throw exception then program jump to here after try block.
 *
 *	@Polymorphic references to Exception.
 *		All ExceptionType inherits Exception so you can use Exception as the type to catch errors.
 *
 *	@UnChecked Exception 
 *		Exception that inherits from "Error" && "RuntimeException"
 *		Such exceptions like critical errors, out-of-memory. 
 *	@Checked Exception
 *		Any Exception that doesn't inherits from "Error" && "RuntimeException"
 *		All Checked Exception must be handled either by try,catch block or add throws in the method header
 *
 *	@Common methods of ExceptionType Object
 *
 *	getMessage() // Returns error message of the object
 *	
 *	@Common ExceptionType : 
 *
 *		FileNotFoundException 		 //Cannot find file
 *		NumberFormatException		 //ParseIntError
 *		InputMisMatchException
 *		
 *		
 */

public class ExceptionDemo {
	String x = "0";
	public void add(String x){
		if(x.equals("1")) {
			//throw new Exception(x); //Fix this by add throws or surround with try/catch block
		}
		this.x = "2";
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
