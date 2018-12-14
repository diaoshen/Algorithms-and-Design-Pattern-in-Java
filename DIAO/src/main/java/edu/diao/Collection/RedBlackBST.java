package edu.diao.Collection;



//Generic Type Key and Type Value = Template Class
public class RedBlackBST <Key extends Comparable<Key> , Value>{
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private Node root;
	
	private class Node{ 				
		Key key;					// key
		Value val;					// associated value
		Node left, right;			// Left subtree , right subtree
		int n;						// # of nodes in this subtree
		boolean color;				// Color of link from parent to this node
		
		/*
		 * Constructor
		 */
		Node(Key key , Value val , int N , boolean color){
			this.key = key;
			this.val = val;
			this.n = N;
			this.color = color;
		}
				
	}//END NODE CLASS
	
	/*
	 * Returns total number of nodes
	 */
	public int size() {
		return size(root);
	}
	private int size(Node x) {
		return x == null ? 0 : x.n;
	}
		
	/*
	 * is a node red? 
	 */
	private boolean isRed(Node x) {
		if(x == null) return false; // Null node is default to be black
		return x.color == RED;
	}
	
	/*
	 * Rotate Left
	 */
	private Node rotateLeft(Node h) {
		/*
		 * current node is h ,  node x is  h.right
		 * Steps to perform rotateLeft
		 * 1. Right link of H point to Left link of X 
		 * 2. Left link of X point to H 
		 * 3. Since X is the new h , so color of x changes to whatever color h was
		 * 4. h now should be RED 
		 * 5. Update nfields
		 */
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	/*
	 * Rotate Right
	 */
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	/*
	 * Flip Color
	 */
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	/*
	 * add
	 */
	public void add(Key key , Value val) {
		root = add(root, key , val);
		root.color = BLACK;
	}
	private Node add(Node h , Key key , Value val) {
		//Case 1.   Empty Tree , OR Insert at bottom
		if(h == null) {
			return new Node(key,val,1,RED);
		}
		//Case 2. Should insert to left subtree
		int cmp = key.compareTo(h.key);
		if(cmp < 0) {
			h.left = add(h.left , key , val);
		//Case 3. Should insert to right subtree
		} else if( cmp > 0) {
			h.right = add(h.right , key , val);
		}else {
		//Case 4. Duplicate Key so.. Update Value
			h.val = val;
		}
		
		//When done inserting.. Tree might be un-balanced, so perform below steps to balance tree
		
		//BLACK LEFT  , RED RIGHT    then should rotate LEFT
		if(isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		//2 Left RED link in a row    then should rotate RIGHT
		if(isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		//Color Flip
		if(isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		
		h.n = size(h.left) + size(h.right) + 1;
		return h; // This returns to possibly case 2,3,4 thus will perform balance check at each level
		
	}
	
	/*
	 * Largest Kth 
	 */
    public class count { 
        int c = 0; 
        int total = 0;
    } 
	public void kthLargest(int k) {
        count c = new count(); // object of class count 
		kthLargest(root , k , c);
	}
	private void kthLargest(Node x , int k , count C) {
		//I'm the kth largest  OR I'm NULL
		if(x == null || C.c >= k) {
			return;
		}				
		//Otherwise , do a reverse in order traversal , so max is visited first !
		kthLargest(x.right,k,C);
		
		//When Above statement  comes back .. I would have already visited 1 of the maximum
		C.c++; //Uses class object C so  the c field will perserve 
		
		if(C.c == k) {
			System.out.println(k + "th largest element is " + x.key);
			C.total = C.total + (int)x.val;
			System.out.println("\nAverage of Kth = " + C.total/k);
			return;
		}else {
			C.total = C.total + (int)x.val;
		}
		
		//If still haven't reached kth max then the next max will be at left subtree of previous max
		//In other words.. max.left
		kthLargest(x.left,k,C);
	}
	
	/*
	 *  In order traversal 
	 */
	public void printInOrder() {
		printInOrder(root);
		System.out.println("");
	}
	private void printInOrder(Node x) {
		if(x != null) {
		printInOrder(x.left);
		System.out.print(x.key + " , ");
		printInOrder(x.right);
		}
	}
	
	/*
	 * PrintSideWays
	 */
	public void printSideWays() {
		printSideWays(root , "");
	}
	private void printSideWays(Node x , String indent) {
		if(x != null) {
			printSideWays(x.right , indent + "  ");
			System.out.println(indent + x.key);
			printSideWays(x.left, indent + "  ");
		}
	}
	
	
	
	
	/*
	 * Embedded Main
	 */
	public static void main(String[] args ) {
		RedBlackBST<String,Integer> tree = new RedBlackBST<String,Integer>();
		
		/*
		 * Test for Insert
		 */
		tree.add("S", 2);
		tree.add("E", 3);
		tree.add("A", 12);
		tree.add("R", 9);
		tree.add("C", 9);
		tree.kthLargest(4);
		tree.printSideWays();
		tree.printInOrder();
		tree.add("H", 1);
		tree.add("X", 1);
		tree.add("M", 1);
		tree.add("P", 1);
		tree.add("L", 1);

		
	//	tree.printSideWays();
		
		//tree.kthLargest(1);
	}
}//END RB BST 




