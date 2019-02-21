import java.io.*;
import java.util.Scanner;
/*
 * @AUTHOR RONGGUANG OU
 * 
 * EBNF Grammar is 
 * 
 *     program  ::=  S {statemt}
 *      statemt  ::=  assnmt | ifstmt | do | inout | progcall
 *      assnmt   ::=  ident ~ exprsn ;
 *      ifstmt   ::=  I comprsn @ {statemt} [% {statemt}] &
 *      do       ::=  D {statemt} U comprsn E
 *      inout    ::=  iosym ident {, ident } ;
 *      iosym    ::=  R | O
 *      progcall ::=  C program G
 *      comprsn  ::=  ( oprnd opratr oprnd )
 *      exprsn   ::=  factor {+ factor}
 *      factor   ::=  oprnd {* oprnd}
 *      oprnd    ::=  integer | ident | bool | ( exprsn )
 *      opratr   ::=  < | = | > | ! | ^ 
 *      ident    ::=  letter {char}
 *      char     ::=  letter | digit
 *      integer  ::=  digit {digit}
 *      letter   ::=  W | X | Y | Z
 *      digit    ::=  0 | 1
 *      bool     ::=  T | F
 *
 *   The tokens are: S I D U E R O C G W X Y Z 0 1 T F ; ~ @ % & , ( ) + * < = > ! ^
 *   Nonterminals are shown as lowercase words.
 *   The following characters are NOT tokens (they are EBNF metasymbols):   | { } [ ]
 *   Note that parentheses are TOKENS, not EBNF metasymbols in this particular grammar.
 *   
 */

public class Parser {
	
	static String inputString;
	static int index = 0;
	static int errorflag = 0;
	
	/*
	 * Util Functions
	 */
	private char token() {return inputString.charAt(index);}
	private void advancePtr() { if(index < inputString.length()-1)index++; }
	private void match(char t) {
		if(t == token())
			advancePtr();
		else
			error();
	}
	private void error() {
		System.out.println("Error at position: " + index);
		errorflag = 1;
		advancePtr(); //Continue for checking
	}
	private void start() {
		program();
		match('$');
		if(errorflag == 0)
			System.out.println("Legal\n");
		else
			System.out.println("Illegal\n");
	}
	
	
	/*
	 * Rules
	 */
	private void program() {
		match('S');
		while(token() == 'S' ||
			  token() == 'W' ||
			  token() == 'X' ||
			  token() == 'Y' ||
			  token() == 'Z' ||
			  token() == 'I' ||
			  token() == 'D' ||
			  token() == 'R' ||
			  token() == 'O' ||
			  token() == 'C' ) {
			statemt();
		}
	}
	private void statemt() {
		if(token() == 'W' || token() == 'X' || token() == 'Y' || token() == 'Z') {
			assnmt();
		}else if(token() == 'I') {
			ifstmt();
		}else if(token() == 'D') {
			doo();
		}else if(token() == 'R' ||  token() == 'O') {
			inout();
		}else// if(token() == 'C') 
			progcall();
	}
	private void assnmt() {
		ident();
		match('~');
		exprsn();
		match(';');
	}
	private void ifstmt() { // ???? 
		match('I');
		comprsn();
		match('@');
		
		while(
				  token() == 'W' ||
				  token() == 'X' ||
				  token() == 'Y' ||
				  token() == 'Z' ||
				  token() == 'I' ||
				  token() == 'D' ||
				  token() == 'R' ||
				  token() == 'O' ||
				  token() == 'C'   ) {
				statemt();
		}
		if(token() == '%') {
			match('%');
			while(
					  token() == 'W' ||
					  token() == 'X' ||
					  token() == 'Y' ||
					  token() == 'Z' ||
					  token() == 'I' ||
					  token() == 'D' ||
					  token() == 'R' ||
					  token() == 'O' ||
					  token() == 'C'   ) {
					statemt();
			}
		}
		match('&');	
	}
	private void doo() {
		match('D');
		while(
				  token() == 'W' ||
				  token() == 'X' ||
				  token() == 'Y' ||
				  token() == 'Z' ||
				  token() == 'I' ||
				  token() == 'D' ||
				  token() == 'R' ||
				  token() == 'O' ||
				  token() == 'C'   ) {
			statemt();
		}
		match('U');
		comprsn();
		match('E');	
	}
	private void inout() { //?????
		iosym();
		ident();
		while(   
				token() == 'W' ||
				token() == 'X' ||
				token() == 'Y' ||
				token() == 'Z' ||
				token() == '0' ||
				token() == '1'   ) {
			match(';');
			ident();
		}
		match(';');
			
	}
	private void progcall() {
		match('C');
		program();
		match('G');
	}
	private void exprsn() {
		factor();
		while(
				token() == '0' ||
				token() == '1' ||
				token() == 'W' ||
				token() == 'X' ||
				token() == 'Y' ||
				token() == 'Z' ||
				token() == 'T' ||
				token() == 'F' ||
				token() == ')' ||
				token() == '*' ||
				token() == '+'   ) {
			match('+');
			factor();
		}		
	}
	private void comprsn() {
		match('(');
		oprnd();
		opratr();
		oprnd();
	}
	private void iosym() {
		if(token() == 'R') {
			match('R');
		}
		else // if(token() == 'O') 
			match('O');
	}
	private void ident() {
		letter();
		while(
				token() == 'W' ||
				token() == 'X' ||
				token() == 'Y' ||
				token() == 'Z' ||
				token() == '0' ||
				token() == '1'   ) {
			charr();
		}
	}
	private void oprnd() {
		if(token() == '0' || token() == '1') {
			integer();
		}else if(token() == 'W' || token() == 'X' || token() == 'Y' || token() == 'Z') {
			ident();
		}else if(token() == 'T' || token() == 'F') {
			bool();
		}else { //if token() == '(' 
			match('(');
			exprsn();
			match(')');
		}
	}
	private void opratr() {
		if(token() == '<') {
			match('<');
		}else if(token() == '=') {
			match('=');
		}else if(token() == '>') {
			match('>');
		}else if(token() == '!') {
			match('!');	
		}else// if(token() == '^') {
			match('^');
	}
	private void factor() {
		oprnd();
		while(
				token() == '0' ||
				token() == '1' ||
				token() == 'W' ||
				token() == 'X' ||
				token() == 'Y' ||
				token() == 'Z' ||
				token() == 'T' ||
				token() == 'F' ||
				token() == ')' ||
				token() == '*'   ) {
			match('*');
			oprnd();
		}		
	}
	private void integer() {
		digit();
		while(
				token() == '0' ||
				token() == '1'   ) {
			digit();
		}
	}
	private void bool() {
		if(token() == 'T') {
			match('T');
		}else {
			match('F');
		}
	}
	private void letter() {
		if(token() == 'W') {
			match('W');
		}else if(token() == 'X') {
			match('X');
		}else if(token() == 'Y') {
			match('Y');
		}else {
			match('Z');
		}
	}
	private void charr() {
		if(token() == '0' || token() == '1') {
			digit();
		}else {
			letter();
		}
	}
	private void digit() {
		if(token() == '0') {
			match('0');
		}else {
			match('1');
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parser miParser = new Parser();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter an expression : ");
		inputString = input.nextLine();
		miParser.start();
	}

}
