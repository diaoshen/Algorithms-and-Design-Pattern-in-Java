package edu.diao.java.tutorial.classes.wrapper;
/*
 * This file also contains :
 * 
 * The String (Immutable / Static String) class
 * The StringBuilder (mutable / Dynamic String) class
 */

import java.util.ArrayList;

/*
 * Wrapper class provides more function to primitive data types.
 * 
 * Wrapper Class applies to -> 
 * 
 * Character -> char
 * Byte -> byte
 * Double -> double
 * Float -> float
 * Integer -> int
 * Long -> long
 * 
 */


public class WrapperTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Character Class
		 * Some useful static functions Character class provides
		 */
		String input = "H1a !";
		char ch = input.charAt(0);
		
		System.out.println(Character.isDigit(ch));
		System.out.println(Character.isLetter(ch));
		System.out.println(Character.isWhitespace(ch));
		System.out.println(Character.isSpaceChar(ch));
		System.out.println(Character.isUpperCase(ch));
		System.out.println(Character.isLowerCase(ch));
		ch = Character.toLowerCase(ch);
		ch = Character.toUpperCase(ch);
		
		/*
		 * String Class
		 * Some useful static functions Character class provides
		 */
		
		//startsWith() , endsWith()
		String str = "Four score and seven years ago";
		String str2 = "THOSE SEVEN YEARS PASSED QUICKLY";
		
		System.out.println(str.startsWith("Four"));
		System.out.println(str.endsWith("years"));
		
		//Region find , case-insensitive  : search for seven years 
		//str1 look in position 15 to 15 + 11
		//str2 look in position 6  to  6 + 11
		//True for ignore case
		System.out.println(str.regionMatches(true, 15, str2, 6, 11));
		
		//indexOf() , lastIndexOf()
		int position = str.indexOf('r');
		System.out.println("The letter r appears at the following locations: ");
		while(position != -1) {
			System.out.println(position);
			position = str.indexOf('r' , position + 1);
		}
		
		//Extract SubString using  substring() , getChars() , toCharArray()
		String fullName = "Cynthia Susan Lee";
		String lastName = fullName.substring(14);
		String middleName = fullName.substring(8, 13);
		System.out.println("The full name is " + fullName);
		System.out.println("The last name is " + lastName);
		System.out.println("The middle name is " + middleName);
		
		char nameArray[] = new char[5];
		fullName.getChars(8, 13, nameArray, 0);
		for(int i = 0 ; i < nameArray.length ; i++) {
			System.out.print(nameArray[i] + " ");
		}
		
		char charArray[] = 	fullName.toCharArray();
		for(int i = 0 ; i < charArray.length ; i++) {
			System.out.print(charArray[i] + " ");
		}
		
		//Replace()
		String a = "Tom Talbert Tried Trains";
		String b;
		b = a.replace('T', 'D');
		System.out.println(a);
		System.out.println(b);
		
		//Trim()
		String greeting1 = "   Hello   ";
		String greeting2;
		greeting2 = greeting1.trim();
		System.out.println("*" + greeting1 + "*");
		System.out.println("*" + greeting2 + "*");
		
		//Tokenizing String
		String num = "    one and two and three and four    ";
		num = num.trim();
		String tokens[] = num.split(" and ");
		for(String s : tokens) {
			System.out.println(s);
		}
		//Tokenizing String using regular expression
		String k = "isolvethis@gmail.com";
		String kTokens[] = k.split("[@.]");
		for(String s : kTokens) {
			System.out.println(s);
		}
		
		
		/*
		 * Integer Class , AutoBoxing , Unboxing
		 */
		Integer number = new Integer(7);
		
		//AutoBoxing = Box up / place primitive value to Object's value
		Integer number1;
		number1 = 7; // <-- Effectively is doing number1.value = 7
		
		//Unboxing
		int x = number1; // <-- Effectivly doing x = number1.value
		
		//Java does autoboxing and unboxing by itself usually..
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5); //ArrayList holds Integer Object , so 5 will be autoboxing
		int five = list.get(0); // get returns Integer Object , but b/c assign to int , it will unboxing.
	}

}
