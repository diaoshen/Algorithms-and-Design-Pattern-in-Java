package map.unordered;


import java.util.ArrayList;
//import java.util.Iterator;

/*
 * Separating Chaining HashTable
 * 
 * This is generic hashtable with type Key , Value
 */
public class SeparateChainingHT<Key , Value> {

	private class HashNode{
		private Key key;
		private Value val;
		private HashNode next;
		/*
		 * Constructor
		 */
		HashNode(Key key , Value val, HashNode next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}//END NODE CLASS
	
	
	
	/*
	 * Fields 
	 */
	private int size;	//current size
	private int capacity; //max table size
	private final double maxload = 0.75;
	private ArrayList<HashNode> bucket; //Array of Linked List
	
	/*
	 * Constructor
	 */
	public SeparateChainingHT(){
		//Create Hashtable with 10 buckets
		bucket = new ArrayList<>();
		size = 0;
		this.capacity = 10;
		
		//Create empty chains
		for(int i = 0 ; i< capacity ; i++) {
			bucket.add(null);
		}
	}
	
	/*
	 * Size()  
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Resize() //TODO?
	 */
	private void resize(int newCapacity) {
		//Create new hash table
		ArrayList<HashNode> newBucket = new ArrayList<HashNode>(newCapacity);
		for(int i = 0 ; i< newCapacity ; i++) {
			newBucket.add(null);
		}
		//Copy keys from old table to new table
		this.capacity = newCapacity;
		this.size = 0;
		for(int i = 0 ; i < bucket.size() ; i++) {
			HashNode curr = bucket.get(i);
			while(curr != null) {
				newBucket.add(hashCode(curr.key),new HashNode(curr.key,curr.val,newBucket.get(hashCode(curr.key))));
				curr = curr.next;
				size++;
			}
		}
		//Point to new table
		bucket = newBucket;	
	}
	
	/*
	 * LoadFactor() 
	 */
	private double loadFactor() {
		return (double)size / capacity;
	}
	
	/*
	 * HashCode
	 */
	private int hashCode(Key key) {
		/*
		 * C++ Equivalent will be  abs(key.hashCode()) % capacity
		 */
		return (key.hashCode() & 0x7fffffff) % capacity;
	}
	
	/*
	 * Add
	 */
	public void add(Key key , Value val) {
		/*
		 * Resize if needed
		 */
		if(loadFactor() >= maxload) {
			resize(2*capacity);
		}
		
		/*
		 * If node doesn't exist , create one and attach to list
		 */
		if(!contains(key)) {
			bucket.set(hashCode(key), new HashNode(key , val , bucket.get(hashCode(key)))) ;
			size++;
		}else { //Node exists , update value
			bucket.get(hashCode(key)).val = val;
		}
	}
	
	/*
	 * Remove
	 */
	public void remove(Key key) {
		if(contains(key)) {
		bucket.remove(hashCode(key));
		}
		//Ignore Non-Existing Key
		return;
	}
	
	/*
	 * Contains
	 */
	public boolean contains(Key key) {
		HashNode curr = bucket.get(hashCode(key));
		while(curr != null) {
			if(curr.key.equals(key)){
				return true;
			}
			curr = curr.next;
		}
		return false;
	}
	
	/*
	 * Iterator : Returns iterator to traverse hashtable by index 0 to capacity-1
	 * bucket then can be use by advanced for loop to traverse 
	 */
	public  Iterable<HashNode> iterator() {
		return bucket;
		//for(HashTable<Character, Integer>.HashNode x : HT.iterator()) {
	}
	
	/*
	 * Print Structure
	 */
	public void  print() {
		for(int i = 0 ; i < capacity ; i++) {
			System.out.print("[" + i + "]: ");
			HashNode curr = bucket.get(i); //Get ith head
			while(curr != null) {
				System.out.print(" -> " + curr.key + "|" + curr.val);
				curr = curr.next;
			}
			System.out.println(" /");
		}
	}
	
	
	/*
	 * Driver 
	 */
	public static void main(String[] args)  {

		SeparateChainingHT<Character , Integer> HT = new SeparateChainingHT<Character , Integer>();
		char key[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T'};
		int a[] =    { 1,  2,  3,  4,  5,  7,  7,  8,  9,  11, 22, 33, 44, 55, 56, 47, 88, 99, 20, 40 };
		
	

		for(int i = 0 ; i < 5 ; i++) {
			System.out.println("Before add " + key[i]);
			HT.print();
			
			try{System.in.read();}
			catch(Exception e){}
			
			HT.add(key[i], a[i]);
			
			for(int j = 0 ; j < 11 ; j++) {
				System.out.println();
			}
			
			System.out.println("After add " + key[i]);
			HT.print();
			
			try{System.in.read();}
			catch(Exception e){}
			try{System.in.read();}
			catch(Exception e){}
		}
		
		for(SeparateChainingHT<Character, Integer>.HashNode x : HT.iterator()) {
			if(x!= null)
				System.out.println(x.key);
			else 
				System.out.println("Empty");	
		}

	}

}//END HASHTABLE CLASS

