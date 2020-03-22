package edu.diao.iterator;



import java.util.ArrayList;
import java.util.Iterator;



/*
 * Interface Iterable is a way to tell a collection can be iterated over.
 * so any class implements Iterable will need to implement the method Iterator so it can be 
 * iterated over. If you tell me this collection can iterate over.. then this class should have
 * a method that returns a iterator! basically Iterable provides Iterator and Iterator
 * provide ways to loop thru collection  Also.. the iterator returned by class can be used by Advanced For Loop
 * This concept is demonstrated using Option 1 below
 * 
 * Interface Iterator is a object with iteration state like can check if there is more element to iterate over
 * any class implement this means you want your own way to iterate thru the class. Thus need to implement methods like
 * hasNext() , next()
 * 
 * 
 * If a class is like ArrayList  where java has build in Iterator then Iterable can be returned thus enables this class 
 * to use advanced for loop without implement Iterable and or Iterator. You can simply call iterator() to get iterator and use
 * hashnext() , next() to traverse
 * or return the ArrayList as Iterable object since it is iterable ! (advanced for loop)
 * 
 * 
 *
 * If you have a  Class A contains ArrayList<Integer> object
 * 
 * To traverse class A's ArrayList<Integer> x  you can choose any of the following ...
 * 
 * Option 1 :
 * 1. Implements Iterable<Integer> to make class A become Iterable
 * 2. Add code to provide iterator :
 * 		@Override 
 * 		Iterator<Integer> iterator(){
 * 			return x.iterator()
 * 		} 
 * 3. Loop code :
 * 		A demo = new A();
 * 		Iterator<Integer> iter = demo.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
	Variations : If collection is known to be "Iterable" then step 1 can be skipped. In this case ArrayList is "Iterable" so can be skipped
				 If collection is known to be "Iterable" then the method iterator() is builtin in java. You can write your own iterator() if you wish to.
				 If collection is known to be NOT "Iterable" then you must write your own iterator class as inner class that implements iterator
				 	and outerclass implements Iterable to provide iterator <-- this doing is convention , reality is that once you write your own inner class iterator
				 	then you can do step 2 , 3.
				 
  
  Option 2 :
  1. Since ArrayList<Integer> is Iterable then just return an Iterable Object , I think in the background if is Interable , java will call iterator() for this object auto
    	public Iterable<Integer> getiterator() {
 		return x;	
 	}
  2. Loop code :
  		A demo = new A();
  		for(Integer i : A.getiterator()){
  			System.out.print(i + " ");
  		}
  		
  Variations : If collection is NOT "iterable> then you will need to first write inner iterator class before proceeding to step 1.
  
*/






/*
 * Example of iterable collection with collection that's known to have iterable , thus no need to implement Iterable 
 */

//public class IteratorDemo{
//	private ArrayList<Integer> x;
//	
//	public IteratorDemo(){
//		x = new ArrayList<Integer>(10);
//		for(int i = 0 ; i< 10 ; i++) {
//			x.add(i);
//		}
//	}
//	
//	//Returns Iterator to the iterable , not to be confused with iterable itself. 
//	public java.util.Iterator<Integer> iterator() {
//		return x.iterator();
//	}
//	
//	//Returns Iterable , in this case ArrayList is known to be iterable so itself is an iterable.
//	public Iterable<Integer> Iterator(){
//		return this.x;
//	}
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		IteratorDemo demo = new IteratorDemo();
//		
//		Iterator<Integer> iter = demo.iterator();
//		while(iter.hasNext()) {
//			System.out.print(iter.next() + " ");
//		}
//		
//		System.out.println("");		
//		
//		//advanced for loop takes instance of "iterable" not to be confuse with "iterator"
//		for(Integer i : demo.Iterator()) {
//			System.out.print(i + " ");
//		}			
//	}// END MAIN
//}//END CLASS



/**
 * Example of class that implements iterable so it can be iterated and this entire class before iterable ! 
 */
//public class IteratorDemo implements Iterable<Integer>{
//	private ArrayList<Integer> x;
//	
//	public IteratorDemo(){
//		x = new ArrayList<Integer>(10);
//		for(int i = 0 ; i< 10 ; i++) {
//			x.add(i);
//		}
//	}
//	
//	//Returns Iterator to the iterable , not to be confused with iterable itself. 
//	public java.util.Iterator<Integer> iterator() {
//		return x.iterator();
//	}
//	
//	//Returns Iterable , in this case ArrayList is known to be iterable so itself is an iterable.
//	public Iterable<Integer> Iterator(){
//		return this;
//	}
//	
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		IteratorDemo demo = new IteratorDemo();
//		
//		Iterator<Integer> iter = demo.iterator();
//		while(iter.hasNext()) {
//			System.out.print(iter.next() + " ");
//		}
//		
//		System.out.println("");		
//		
//		//advanced for loop takes instance of "iterable" not to be confuse with "iterator"
//		for(Integer i : demo.Iterator()) {
//			System.out.print(i + " ");
//		}			
//	}// END MAIN
//}//END CLASS




 /*
  * Example of Non-Iterable collection
  */

//Implementing Iterable will enable IteratorDemo to be iterable and need to provide a iterator function that returns iterator to this class.
public class IteratorDemo implements Iterable<Integer>{
	private Integer[] x;
	
	//Constructor
	public IteratorDemo() {
		x = new Integer[10];
		for(int i = 0 ; i < 10 ; i++) {
			x[i] = i+1;
		}
	}
	
	class ArrayIterator implements Iterator<Integer>{
		int current = 0;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current < IteratorDemo.this.x.length ? true : false;
		}
		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			if(!hasNext()) {
				return -999999;
			}else {
				return x[current++];
			}
		}
		
	}
	
	//This is from implementing Iterable<Integer>
	@Override
	public Iterator<Integer> iterator(){
		return new ArrayIterator();
		
	}
	
	//To return Iterable<Integer> class must implement Iterable<Integer> 
	//this function is optional , only if u want to use advance for loop.
	public Iterable<Integer> foo(){
		return this;
	}
	

	
	
	public static void main(String[] args) {

		IteratorDemo demo = new IteratorDemo();
		
		Iterator<Integer> iter = demo.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("");
		
		//Iterable Object calls iterator()
		for(Integer i : demo.foo()) {
			System.out.print(i + " ");
		}

	}// END MAIN


}//END CLASS

