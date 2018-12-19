package binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Binary Search Tree V1
 * 
 * 
 * Best case : perfectly balanced with ~log N nodes between root and each null link.
 * Worst case : tree looks like a linked-list O(n)
 * 
 * This version of BST uses : 
 * 
 * 2 generic type   Key and Value
 * generic type "Key" extends Comparable so compareTo() can be used for different type of Key
 * There is a nfield attach to every node. nField of a node x = # of nodes in left n right subtree + 1
 * 
 */

/*
 * Current Supported Operations
 * 
 * public int 		size() 						//Returns total # of nodes in BST
 * public in		getHeight()					//Returns the height of BST
 * public Value 	get(Key key)				//Returns value of given key
 * public void 		add(Key key , Value val)  	//Adds a node to tree with given key and associated value
 * public void 		delete(Key key)				//Removes a key/value pair of a given key
 * public void 		deleteMin()					//Removes the minimum key 
 * public void 		deleteMax()					//Removes the maximum key
 * public Key		min()						//Returns minimum key in tree
 * public Key		max()						//Returns maximum key in tree
 * public Key 		floor(Key key)				//Returns largest key <= parameter key
 * public Key		ceiling(Key key)			//Returns smallest key >= parameter key
 * public boolean 	contains(Key key);			//Returns true if a value of a given key exists or not
 * public boolean 	isEmpty();					//Returns true if BST is empty , false otherwise
 * public int 		rank(Key key)				//Returns # of keys <= given key
 * public int		rank2()						//Returns # of keys >= given key
 * public Key 		select(int k)				//Returns the kth smallest element. 
 * public Key		select2(int k)				//Returns the kth largest element
 * public void		printSideWays()				//Print tree side ways
 * public double	getAverage(int k)			//Returns average of k smallest key's value from a BST
 * public double 	getAverage2(int k)			//Returns average of k largest key's value from BST
 * public void		printLevel()				//Prints BST level by level
 * public void		printInOrder()				//Prints BST in order A-Z = LEFT,ME,RIGHT
 * public void		printPreOrder()				//Prints BST in Pre-order = LEFT,RIGHT,ME
 * public void		printPostOrder()			//Prints BST in Post-order = ME,LEFT,RIGHT
 * 
 * 
 */

public class BST <Key extends Comparable<Key> , Value>{
	
	/*
	 * Definition of a Node
	 */
	private class Node {
		
		private Key key; 				// key
		private Value val; 				// associated value
		private Node left, right; 		// links to subtrees
		private int nField; 			// # nodes in subtree rooted here OR n field

		/*
		 * Constructor to create a node
		 * 
		 * Construct a node with input key,val,nField
		 */
		public Node(Key key, Value val, int nField) {
			this.key = key;
			this.val = val;
			this.nField = nField;
		}
	} //END NODE CLASS
			
	
	private Node root;  				//ROOT of BST
	
	/*
	 * Constructor : Construct a Empty BST
	 */
	public BST() {
		root = null;
	}
	
		
		
	/*
	 * Operation Implementations : 
	 */
		
	
	
		/*
		 * Returns total number of nodes
		 * 
		 * total number of nodes of node x = # nodes in left subtree + # nodes in right subtree + this node itself		
		 * 
		 */
		public int size() {
			return size(root);
		}
		private int size(Node x) {
			return x == null ? 0 : x.nField;
		}
		
		/*
		 * Returns kth smallest (zero based) key
		 */
		public Key select(int k) {
			Node node = select(root,k);
			if(node == null) {
				return null;
			}else {
				return node.key;
			}
		}
		private Node select(Node node, int k) {
			/*
			 * Example : finding select(3) means the key of rank(3) which is the key that has 3 element <= key
			 * In other words.. find the key that there is 3 element <= this key. Equivalent saying find the 4th element because
			 * there is 3 element before 4th element.
			 * 
			 * Algorithm basically checks if there is enough on the left to find rank(3) If a node's left subtree have t count of 6
			 * then there is guarantee 6 elements smaller than this node. Thus compare 3 against node's left subtree is a good choice.
			 * If node's left subtree doesn't have enough elements then It must go right and all the elements on the left subtree of the node
			 * + the node itself is smaller than the target key we are looking for. Thus searching from the right subtree should search a rank of
			 * k-t-1
			 */
			if(node == null) return null;
			
			int t = size(node.left);
			if(t> k) 
				return select(node.left,k);
			else if(t < k)
				return select(node.right, k-t-1); 
			else
				return node;
		}
		
		/*
		 * Returns kth largest (zero based key)
		 */
		public Key select2(int k) {
			Node node = select2(root,k);
			if(node == null) {
				return null;
			}else {
				return node.key;
			}
		}
		private Node select2(Node node , int k) {
			if(node == null) return null;
			int t = size(node.right);
			if(t > k)
				return select2(node.right,k);
			else if(t < k)
				return select2(node.left, k-t-1);
			else
				return node;			
		}
		
		/*
		 * Returns height of a BST 
		 * Height of a tree with single node is 0 
		 * Height of a tree is the maximum height of left and right sub-tree plus 1
		 */
		public int getHeight() {
			return getHeight(root);
		}	
		private int getHeight(Node node) {
			if(node == null) {
				return -1;
			}else {
				int leftHeight = getHeight(node.left);
				int rightHeight = getHeight(node.right);
				int maxHeight = (leftHeight >= rightHeight ? leftHeight : rightHeight);
				return maxHeight + 1;
				
			}
		}	

		/*
		 * Search for key in the BST 
		 * Calls helper function to obtain result
		 * 
		 * @param Key to be search for
		 * @return Value of the given key
		 */
		public Value get(Key key) {
			return get(root , key);
		}
		private Value get(Node x, Key key) {
			if(x == null) return null; //Search miss , this happens when going left or right ended up reaching a null node
			
			/*
			 * Target key can only exists on the left side  if target key < current node's key
			 * OR
			 * Target key can only exists on the right side if target key > current node's key
			 * OR
			 * Target key is the current node
			 */
			
			int cmp = key.compareTo(x.key);		//Compare current key with target key
			if(cmp < 0) { //Search left
				return get(x.left , key);
			}
			else if(cmp > 0) { //Search right
				return get(x.right, key);
			}
			else {
					return x.val; 
			}		
		}
					
		/*
		 * Insert a node of given key and value
		 * 
		 */
		public void add(Key key , Value val) {
			root = add(root,key,val);
		}
		private Node add(Node x , Key key , Value val) {
			/*
			 * 1. If no TreeNode exists, or Reached to Bottom(this new node should be a leaf)
			 * 2. Else If , this node belongs to left branch
			 * 3. Else if , this node belongs to right branch
			 * 4. Else , Duplicate (Update val)
			 * 
			 */
			
			/*
			 * Case 1 When going left or right result to end of tree , then create node and return this.
			 * OR
			 * Case 2 This is a empty BST , then create node and return this.
			 */
			if( x == null) { 
				return new Node(key , val , 1);
			}
			/*
			 * Key is a generic type , could be Int , String , Double
			 * Because Key extends comparable , compareTo() knows what's the real data type of Key. 
			 */
			int cmp = key.compareTo(x.key);
			if(cmp < 0) { // key < current node's key , go left
				x.left = add(x.left , key , val); //calling add will eventually reach to x==null and turns a new node to be attach to x.left
			}else if(cmp > 0) { // key > current node's key , go right
				x.right = add(x.right , key , val);
			}else {	// key == current node's key , key trying to add already exist , update val
				x.val = val;
			}
			x.nField = size(x.left) + size(x.right) + 1; 		//Update n Field
			return x;
		}
		
		/*
		 * Remove a key/value pair given key
		 */
		public void delete(Key key) {
			root = delete(root , key);
		}
		private Node delete(Node node , Key key) {
			/*
			 * Same logic as get , add
			 * 1. Do comparison with current node and key to determine go left or go right
			 * 2. If reach to null then key doesn't exist. 
			 */
			
			
			if(node == null) return null; //Can only get here if passed in empty root or got a null node from going left or right(search miss)
			int cmp = key.compareTo(node.key);
			if(cmp < 0) { // target key < current key , go left
				node.left = delete(node.left,key);
			}else if(cmp > 0) { // target key > current key , go right
				node.right = delete(node.right,key);
			}else { //Key found
				/*
				 * 4 Case for removal
				 * 
				 * 1. a node with a left child only   -fix is  link left to grandparent
				 * 2. a node with a right child only -fix is link right to grandparent
				 * 3. a node with both left and right child -fix is replace with 
				 */
				
				if(node.right == null) { //Only has left child
					return node.left;
				}
				if(node.left == null) {
					return node.right;
				}
				Node t = node; //Save the node to be deleted to t
				node = min(t.right); //Find successor = the smallest key in target key's right subtree and let node point to it
				/*
				 * calling deleteMin(t.right) will unlink successor in tree t.right and returns t.right
				 * node.right = t.right  is what really is happening 
				 * since n is really the successor and t is the deleted node.
				 * doing that assignment means successor's right link is old node's right link
				 */
				node.right = deleteMin(t.right); //Delete successor from target key's right subtree
				/*
				 * successor.left = old.left
				 */
				node.left = t.left;
				//Overall process is that when deleting node that has 2 child , first go to right subtree to find successor , remove it and put to head to replace deleted node.
			}
			node.nField = size(node.left) + size(node.right) + 1;
			return node; // Returns tree with target node delete to whoever call me. that whoeever will link me.
		}
		
		/*
		 * Returns Minimum Key
		 */
		public Key min() {
			return min(root).key;
		}
		private Node min(Node x) {
			return (x.left == null)? x : min(x.left);
		}
						
		/*
		 * Returns Maximum Key
		 */
		public Key max() {
			return max(root).key;
		}
		private Node max(Node x) {
			return (x.right == null)?  x : max(x.right);
		}
		
		/*
		 * Remove minimum key
		 */
		public void deleteMin() {
			if(root != null) {
				root = deleteMin(root);
			}
		}
		private Node deleteMin(Node node) {
			//Recursively finds the minimum and return minimum's right subtree to attach to parent of minimum 
			if(node.left == null) {
				return node.right;
			}
			//node.left is the parent and deleteMin(node.left) will return right subtree of minimum
			node.left = deleteMin(node.left);
			//Update n field
			node.nField = size(node.left) + size(node.right) + 1;
			return node;
		}
		
		/*
		 * Remove maximum key
		 */
		public void deleteMax() {
			if(root != null) {
				root = deleteMax(root);
			}
		}
		private Node deleteMax(Node node) {
			//If I'm the maximum
			if(node.right == null) {
				return node.left;
			}
			/*
			 * node.right need to link back to subtree of node.right after max is deleted
			 */
			node.right = deleteMax(node.right); //after deleteMax is called , tree in node.right no longer contains maximum key
			//Update n field
			node.nField = size(node.left) + size(node.right) + 1;
			return node;
		}
		
		/*
		 * Returns largest key <= x   
		 */
		public Key floor(Key key) {
			Node x = floor(root,key);
			if(x == null) return null;
			return x.key;
		}
		private Node floor(Node x , Key key) {			
			/*
			 * How floor works is that If floor(key) exists then it could be on the left. doing floor(x.left) will eventually return null or target
			 * If during the recursion it went to right then floor(key) will return target only if target does exist on the right. Else the node before going to right is the floor.
			 * 
			 * floor basically looks where key can exists as if it is trying to add this key to BST.
			 * 
			 * 
			 * 
			 * If above is confusing. Take a look at example
			 * 
			 * Case 1:  
 					    S
					   / \
					  E   X
					 / \
					A   R 
			  floor(A) would call these function in order : floor(S,A)->floor(E,A)->floor(A,A)->return A to floor(A,A)->floor(E,A)->floor(S,A) 
			 
			  
			 * Case 2:
 					    S
					   / \
					  E   X
					 / \
					    R 
			 floor(A) = floor(S,A)->floor(E,A)->floor(NULL,A)-> then floor(NULL,A) returns NULL to floor(E,A)->floor(S,A)
			 
			 
			 *Case 3:
			 	
 					    S
					   / \
					  E   X
					 / \
					A   R
					   / \
					  H
					 / \
					    M

			     
			 *floor(G)=floor(S,A)->floor(E,A) t=floor(R,G) -> floor(H,G) -> floor(NULL,G) returns NULL to floor(H,G)->floor(R,G)->t then since t == null
			 *returns E to floor(S,A) , In this case H.left is null thus NULL recursively returns up and T will end up having value of null.
			 *If H.left = G that is floor(G) was able to locate H then t would have become H and return value of floor(E,A) would be G.
			 *
			 *The reason why going to right need to check if T is null or not IS In order to need to go right that means current node is potentially 
			 * the floor already in the example floor(G) , when reaching node E we know is going to right because if were to insert G. It must be 
			 * going to right subtree of E.  E's right subtree can contain F, the next smallest key <= G or it can contain G itself.
			 * 
			 * ceiling works the same with compare sign flipped.
			 */
			
			//floor of X doesn't exist
			if(x == null) {
				return null;
			}
			int cmp = key.compareTo(x.key);
			//floor(x) is x 
			if (cmp == 0) {
				return x;
			}
			//search left side
			if(cmp < 0) {
				return floor(x.left,key);
			}
			//could be right side only if there exists a key <= key
			Node t = floor(x.right,key);
			if(t != null) {
				//search hit , t is now floor(key)
				return t;
			}else {
				return x; // search miss , x is the floor(key)
			}
		}
		
		/*
		 * Returns minimum key >= x
		 */
		public Key ceiling(Key key) {
			Node x = ceiling(root,key);
			if(x == null) return null;
			return x.key;
		}
		private Node ceiling(Node x , Key key) {
			//If ceiling of x doesn't exist
			if(x == null) {
				return null;
			}
			//Compare Target Key with each Node it counters namely "Node x"
			int cmp = key.compareTo(x.key);
			
			// Current Node is ceiling(key)
			if(cmp == 0) {
				return x;
			}
			//Search right side
			if(cmp > 0) {
				return ceiling(x.right,key);
			}
			//It could also be at left side only if there is a key that's >= key 
			Node t = ceiling(x.left,key);
			if(t != null) {
				return t;
			}else {
				return x;
			}
		}
	
		/*
		 * Returns # of keys <= key
		 */
		public int rank(Key key){ 
			return rank(key, root);
		}
		private int rank(Key key, Node x){
		 // Return number of keys less than x.key in the subtree rooted at x.
			if (x == null) return 0;
			int cmp = key.compareTo(x.key);
			if (cmp < 0) return rank(key, x.left);
			else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
			else return size(x.left); //Target found
		}
		
		/*
		 * Returns # of keys >= key
		 */
		public int rank2(Key key) {
			return rank2(key,root);
		}
		private int rank2(Key key, Node x) {
			if(x == null) return 0;
			int cmp = key.compareTo(x.key);
			if(cmp < 0) return 1 + size(x.right) + rank2(key,x.left);
			else if(cmp > 0) return rank2(key,x.right);
			else return size(x.right);
		}
				
		/*
		 * Returns true if there is a value paired for given key , false otherwise
		 */
		public boolean contains(Key key) {
			return get(key) != null;
		}
		
		/*
		 * Returns true if tree is empty , false otherwise
		 */
		public boolean isEmpty() {
			return size() == 0;
		}
		
		/*
		 * Print tree sideways
		 */
		public void printSideWays() {
			String indent = "";
			printSideWays(root, indent);
		}
		private void printSideWays(Node x , String indent) {
			if(x != null) {
				String indent2 = indent + "  ";
				printSideWays(x.right,indent2);
				System.out.println(indent + x.key);			
				printSideWays(x.left,indent2);	
			}
		}
		
		/*
		 * Returns average of k smallest elements' key from BST
		 */
		public double getAverage(int k) {
			Integer average = 0;
			for(int i = 0 ; i < k ; i++) {
				average += (Integer)get(select(i));
				System.out.print(get(select(i)) + ",");
			}
			System.out.println("");
			return average/(double)k;
		}
		
		/*
		 * Return average of k largest elements' key from BST
		 */
		public double getAverage2(int k) {
			Integer average = 0;
			for(int i = 0 ; i < k ; i++) {
				average += (Integer)get(select2(i));
				System.out.print(get(select2(i)) + ",");
			}
			System.out.println("");
			return average/(double)k;
		}
				
		/*
		 *  print level by level
		 */
		public void printLevel() {
			printLevel(root);
		}
		private void printLevel(Node x) {
			if(x == null) return;
			
			Queue<Node> queue = new LinkedList<Node>();
			queue.add(x);
			while(!queue.isEmpty()) {
				Node curNode = queue.poll();
				System.out.print(curNode.key + ",");
				if(curNode.left != null) {
					queue.add(curNode.left);
				}
				if(curNode.right != null) {
					queue.add(curNode.right);
				}
			}
		}
		
		/*
		 * Print in order A-Z
		 */
		public void printInOrder() {
			printInOrder(root);
			System.out.println();
		}
		private void printInOrder(Node x) {
			if(x != null) {
				printInOrder(x.left);
				System.out.print(x.key + ",");
				printInOrder(x.right);
			}
		}
		
		/*
		 * Print in pre-order = LEFT,RIGHT,ME
		 */
		public void printPreOrder() {
			printPreOrder(root);
			System.out.println();
		}
		private void printPreOrder(Node x) {
			printPreOrder(x.left);
			printPreOrder(x.right);
			System.out.print(x.key + ",");
		}
		
		/*
		 * Print in post-order = ME,LEFT,RIGHT
		 */
		public void printPostOrder() {
			printPostOrder(root);
			System.out.println();
		}
		private void printPostOrder(Node x) {
			System.out.print(x.key + ",");
			printPostOrder(x.left);
			printPostOrder(x.right);
		}
		
		/*
		 * Returns list of keys in the range x,y
		 */
		public Iterable<Key> range(){
			return range(min(),max());
		}
		public Iterable<Key> range(Key x, Key y){
			Queue<Key> queue = new LinkedList<Key>(); //Create queue to store range
			range(root,queue,x,y);
			return queue;
		}
		private void range(Node currNode, Queue<Key> queue , Key low, Key high) {
			/*
			 * This is very similar to inOrder Traversal (LEFT,ME,RIGHT)
			 * compareLow tells if "low" key can be found in currNode's left subtree
			 * compareHigh tells if "high" key can be found in currNode's right subtree
			 * 
			 * If low possibly exists in left subtree , go left
			 * If low possibly exists in left subtree and high possible exits in right subtree then currNode is in range.
			 * OR currNode is LOW or HIGH then  add to queue
			 * If high possibly exists in right subtree , go right
			 * 
			 * 
			 */
			if(currNode == null) return;
			int compareLow = low.compareTo(currNode.key); 
			int compareHigh = high.compareTo(currNode.key);
			if(compareLow < 0) { // currNode > low
				range(currNode.left, queue, low , high);
			}
			// (L exists in left subtree or L is currNode)  AND (H exists in right subtree or H is currNode)
			// When both condition is met , currNode is in range.
			if(compareLow <= 0 && compareHigh >= 0) {
				queue.add(currNode.key);
			}
			if(compareHigh > 0) {
				range(currNode.right,queue,low,high);
			}
		}
		
		public static void main(String args[]) {
			BST<String,Integer> bst = new BST<String, Integer>();
			
			bst.add("S", 1);
			bst.add("E", 2);
			bst.add("A", 1);
			bst.add("C", 1);
			bst.add("R", 1);
			bst.add("H", 1);
			bst.add("M", 1);
			bst.add("X", 1);
			
			//Print tree sideways
			bst.printSideWays();
			
			
			//Code to test kth min
			System.out.print("        Index : ");
			for(int i = 0 ; i < bst.size(); i++) {
				System.out.print(i + ",");
			}
			System.out.println();
			System.out.print("Select[Index] : ");
			for(int i = 0 ; i < bst.size(); i++) {
				System.out.print(bst.select(i) + ",");
			}
			System.out.println();
			System.out.println("Rank(H) = " + bst.rank("H") + " = IndexOf(H)");
			System.out.println("Select(4) = " + bst.select(4));
			//END 
			
			System.out.println();
			
			
			//Code to test for kth max
			System.out.print("        Index : ");
			for(int i = 0 ; i< bst.size(); i++) {
				System.out.print(i + ",");
			}
			System.out.println();
			System.out.print("Select[Index] : ");
			for(int i = 0 ; i < bst.size(); i++) {
				System.out.print(bst.select2(i) + ",");
			}
			System.out.println();
			System.out.println("Rank(H) = " + bst.rank2("H"));
			System.out.println("Select(4) = " + bst.select2(4));
			//END
			
			
			//Code to test range
			System.out.println();
			for(String key : bst.range("A","Z")) {
				System.out.print(key + ",");
			}
			System.out.println();
			for(String key : bst.range()) {
				System.out.print(key + ",");
			}
			
			
//TEST CASE 2
//BST<String,Integer> bst = new BST<String,Integer>();


//			bst.add("44", 44);
//			bst.add("14", 14);
//			bst.add("06", 6);
//			bst.add("30", 30);
//			bst.add("36", 36);
//			bst.add("32", 32);
//			bst.add("57", 57);
//			bst.add("55", 55);
//			bst.add("65", 65);
//			bst.add("51", 51);
//			
//			
//			
//			bst.printSideWays();
//			System.out.print("In Order = ");
//			bst.printInOrder();
//			System.out.println();
//			
//			System.out.println("Average of lowest 4");
//			System.out.println(bst.getAverage(4));
//			System.out.println("Average of highest 4");
//			System.out.println(bst.getAverage2(4));
		}
		
		
}//END Class BST
