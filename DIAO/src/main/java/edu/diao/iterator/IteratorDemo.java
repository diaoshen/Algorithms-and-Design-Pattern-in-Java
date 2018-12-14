package edu.diao.iterator;

//import java.util.ArrayList;
//import java.util.Iterator;



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
 * Example of iterable collection
 */

/*public class IteratorDemo implements Iterable<Integer>{
	private ArrayList<Integer> x;
	
	public IteratorDemo(){
		x = new ArrayList<Integer>(10);
		for(int i = 0 ; i< 10 ; i++) {
			x.add(i);
		}
	}
	
	@Override
	public java.util.Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return x.iterator();
	}
	
	public Iterable<Integer> Iterator(){
		//If is     public class IteratorDemo implements Iterable<Integer>
		return this;
		
		//If is public class IteratorDemo
		//return this.x;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IteratorDemo demo = new IteratorDemo();
		
		Iterator<Integer> iter = demo.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		
		System.out.println("");		
		
		for(Integer i : demo.Iterator()) {
			System.out.print(i + " ");
		}			
	}// END MAIN
}//END CLASS
*/




 /*
  * Example of Non-Iterable collection
  */
 

/*public class IteratorDemo implements Iterable<Integer>{
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

	public Iterator<Integer> iterator(){
		return new ArrayIterator();
		
	}
	
	//For this to work , class must implement Iterable<Integer> b/c this tells compiler that IteratorDemo is iterable that is there is a iterator() inside IteratorDemo
	public Iterable<Integer> Iterator(){
		return this;
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IteratorDemo demo = new IteratorDemo();
		
		Iterator<Integer> iter = demo.iterator();
		while(iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println("");
		
		//Iterable Object calls iterator()
		for(Integer i : demo.Iterator()) {
			System.out.print(i + " ");
		}

	}// END MAIN
}//END CLASS
*/
