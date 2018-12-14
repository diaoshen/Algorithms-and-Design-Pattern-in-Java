package binary_search_tree;

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
 * public Value 	get(Key key)				//Returns value of given key
 * public void 		add(Key key , Value val)  	//Adds a node to tree with given key and associated value
 * public Key		min()						//Returns minimum key in tree
 * public Key		max()						//Returns maximum key in tree
 * public Key 		floor(Key key)				//Returns largest key <= parameter key
 * public Key		ceiling(Key key)			//Returns smallest key >= parameter key
 * public boolean 	contains(Key key);			//Returns true if a value of a given key exists or not
 * public boolean 	isEmpty();					//Returns true if BST is empty , false otherwise
 * 
 * TODO: 
 * RANK() ???
 * public Key select(int k)   SEE Module 6 , pg 21
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
		 * Returns kth (zero based) key
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
			if(x == null) return null;
			
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
			if(node == null) return null;
			int cmp = key.compareTo(node.key);
			if(cmp < 0) {
				node.left = delete(node.left,key);
			}else if(cmp > 0) {
				node.right = delete(node.right,key);
			}else {
				if(node.right == null) {
					return node.left;
				}
				if(node.left == null) {
					return node.right;
				}
				Node t = node;
				node = min(t.right);
				node.right = deleteMin(t.right);
				node.left = t.left;
			}
			node.nField = size(node.left) + size(node.right) + 1;
			return node;
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
			node.right = deleteMax(node.right);
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
			//For example.. it went from root.left -> root.left.right
			//When search from root.left.right , there could be a search hit or miss 
			Node t = floor(x.right,key);
			if(t != null) {
				//search hit
				return t;
			}else {
				return x; // search miss , so for above example, if root.left.right fails then floor must be at root.left
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
				return floor(x.right,key);
			}
			//It could also be at left side only if there is a key that's >= key 
			Node t = floor(x.left,key);
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
			else return size(x.left);
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
		
		
		
	
}//END Class BST
