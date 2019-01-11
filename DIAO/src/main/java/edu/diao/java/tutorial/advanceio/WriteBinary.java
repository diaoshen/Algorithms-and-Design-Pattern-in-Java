package edu.diao.java.tutorial.advanceio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Sequential Access 
 */

public class WriteBinary {

	public static void main(String[] args) throws IOException , FileNotFoundException {
		// TODO Auto-generated method stub
		
		int[] numbers = { 2, 4, 6, 8, 10, 12, 14 };
		
		DataOutputStream outputFile = new DataOutputStream(new FileOutputStream("MyInfo.dat"));
		
		System.out.println("Writing the numbers to the file...");
		
		//Write the array elements to the file.
		for(int i = 0 ; i < numbers.length ; i++) {
			outputFile.writeInt(numbers[i]);
		}
		
		System.out.println("Done.");
		
		//Close the file.
		outputFile.close();
		
		
		
		
		//Setup for reading from binary file
		DataInputStream inputFile = new DataInputStream(new FileInputStream("MyInfo.dat"));
		
		int number;
		boolean endOfFile = false;		//EOF FLAG
		
		System.out.println("Reading numbers from the file:");
		
		//Read the contents of the file.
		while(!endOfFile) {
			try 
			{
				number = inputFile.readInt();
				System.out.print(number + " ");
			}
			catch (EOFException e)
			{
				endOfFile = true;
			}
		}
		inputFile.close();
	}

}
