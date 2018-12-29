package red_black_binary_search_tree;
/*
 * Author : DIAO
 * Time created : 12/18/2018
 */

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;



//import binary_search_tree.BST;

/*
 * RED-BLACK BINARY SEARCH TREE V1
 * 
 * This version of RED-BLACK BST has a 1-1 mapping to 2-3 Tree
 * 
 */

/*
 * Current Supported Operations :
 * 
 * public 	int 		size()						//Returns total number of TreeNodes 
 * private	boolean 	isRed(TreeNode x)			//Returns true if a TreeNode is red , Default = BLACK
 * private	TreeNode	rotateLeft(TreeNode h)		//Switch color between h and h.right and return h.right
 * private 	TreeNode	rotateRight(TreeNode h)		//Switch color between h and h.left and return h.left
 * private 	void		flipColors(TreeNode h)		//Change h to red  and childs of h to black
 * public 	void		add(Key key , Value val)	//Add a key/value pair to BST
 */


//Template class RedBlackBST uses Generic type "Key" and "Value"
//Key extends Comparable so compareTo can be used.
public class RedBlackBST <Key extends Comparable<Key> , Value> {

	
	/*
	 * Private members
	 */
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private TreeNode root;
	
	private class TreeNode{
		Key key;						//key
		Value val;						//associated value
		TreeNode left,right;			//Left subtree , right subtree
		int n;							// # of treenodes in this subtree
		boolean color;					//Color of node
		
		/*
		 * Constructor to create a TreeNode
		 */
		TreeNode(Key key, Value val, int N, boolean color){
			this.key = key;
			this.val = val;
			this.n = N;
			this.color = color;
		}
	}//END TREENODE CLASS
	
	
	
	/*
	 * Operation Definitions : 
	 */
	
	/*
	 * IsEmpty? 
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/*
	 * Returns total number of nodes
	 */
	public int size() {
		return size(root);
	}
	private int size(TreeNode x) {
		return x == null ? 0 : x.n;
	}
	
	/*
	 * Returns the height of the BST(for debugging purposes)
	 * @return the height of the BST( a 1-node tree has height 0)
	 */
	public int height() {
		return height(root);
	}
	private int height(TreeNode x) {
		if (x == null) return -1;
		return 1 + Math.max(height(x.left), height(x.right));
	}
	
	/*
	 * is a node red?  Default color of a null tree is BLACK=FALSE, Any newly created TreeNode is RED
	 */
	private boolean isRed(TreeNode x) {
		if(x == null) return BLACK; 
		return x.color = RED;
	}
	
	/*
	 * is a node black?
	 */
	private boolean isBlack(TreeNode x) {
		return isRed(x) ? false : true;
	}
	
	/*
	 * Left Rotation
	 */
	private TreeNode rotateLeft(TreeNode h) {
		/*
		 * Input h is BLACK. h.right is RED , To switch them perform:
		 * Steps : 
		 * 1. Create a TreeNode and point to h.right(The RED Node)
		 * 2. Connect H's right link to X's left link
		 * 3. Connect X's left  link to H
		 * 4. X is the new root so update colors by setting X's color to H's color
		 * 5. H is now RED 
		 * 6. update N Field
		 */
		TreeNode x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		x.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	/*
	 * Right rotation
	 */
	private TreeNode rotateRight(TreeNode h) {
		/*
		 *Similar Steps to rotateLeft
		 */
		TreeNode x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		x.n = h.n;
		h.n = size(h.left) + size(h.right) + 1;
		return x;
	}
	
	/*
	 * Color Flip
	 */
	private void flipColors(TreeNode h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}
	
	/*
	 *  add key/value pair 
	 */
	public void add(Key key , Value val) {
		if(key == null) throw new IllegalArgumentException("First arg to add() is null");
		if(val == null) {
			delete(key);
			return;
		}
		root = add(root, key , val);
		root.color = BLACK;
	}
	private TreeNode add(TreeNode currNode , Key key , Value val) {
		
		/*
		 * Add  operation for the most part is same as regular BST
		 * Difference is : all new TreeNode is RED and must check for balance after inserting.
		 * 
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
		if( currNode == null) { 
			return new TreeNode(key , val , 1 , RED);
		}		
		/*
		 * Key is a generic type , could be Int , String , Double
		 * Because Key extends comparable , compareTo() knows what's the real data type of Key. 
		 */
		int cmp = key.compareTo(currNode.key);
		if(cmp < 0) { // key < current node's key , go left
			currNode.left = add(currNode.left , key , val); //calling add will eventually reach to x==null and turns a new node to be attach to x.left
		}else if(cmp > 0) { // key > current node's key , go right
			currNode.right = add(currNode.right , key , val);
		}else {	// key == current node's key , key trying to add already exist , update val
			currNode.val = val;
		}
		
		//When done inserting.. Tree might be un-balanced, so perform below steps to balance tree
		
		//BLACK LEFT  , RED RIGHT    then should rotate LEFT
		if(isRed(currNode.right) && !isRed(currNode.left)) {
			currNode = rotateLeft(currNode);
		}
		//2 Left RED link in a row    then should rotate RIGHT
		if(isRed(currNode.left) && isRed(currNode.left.left)) {
			currNode = rotateRight(currNode);
		}
		//Color Flip
		if(isRed(currNode.left) && isRed(currNode.right)) {
			flipColors(currNode);
		}
		
		currNode.n = size(currNode.left) + size(currNode.right) + 1;
		return currNode; // This returns to possibly case 2,3,4 thus will perform balance check at each level		
	}
	
	/*
	 * Return value of given key
	 */
	public Value get(Key key) {
		TreeNode x = root;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if(cmp == 0) return x.val;
			else if(cmp <0) x = x.left;
			else x = x.right;
		}
		return null;
	}
	@SuppressWarnings("unused")
	private Value get(TreeNode h , Key key) {
		TreeNode x = h;
		while(x != null) {
			int cmp = key.compareTo(x.key);
			if(cmp == 0) return x.val;
			else if(cmp <0) x = x.left;
			else x = x.right;
		}
		return null;
	}
	
	/*
	 * If tree contains input key
	 */
	public boolean contains(Key key) {
		return get(key) != null ? true : false;
	}
	
	/*
	 * fix un-balance (Perform series of local transformation to restore balance)
	 */
	private TreeNode fix(TreeNode h) {
		if(isRed(h.right))
			h = rotateLeft(h);
		if(isRed(h.left) && isRed(h.left.left)) 
			h = rotateRight(h);
		if(isRed(h.left) && isRed(h.right)) 
			flipColors(h);
		
		h.n = size(h.left) + size(h.right) + 1;
		
		return h;
	}
	
	/*
	 * Helper function for deleteMax()
	 * Purpose : turn h into a 3-node or 4-node depending on h.left.left
	 */
	private TreeNode makeRedRight(TreeNode h) {
		//TODO assert(h != null) && isRed(h.left)
	
		flipColors(h); 
		//Now h is a 4-node after flipColors(h)
		if(isRed(h.left.left)) { // If there is 2 red in a row  h is a 5-node instead of 4-node
			//Break 5-node 
			h = rotateRight(h);
			flipColors(h);
			//Now h is a 3-node
		}
		return h; //In the end, h.right must be in either a 3-node or 4-node
	}
	
	/*
	 * Helper function for deleteMin()
	 * Purpose : to turn h into a 3-node or 4-node depending on h.right.left
	 */
	private TreeNode makeRedLeft(TreeNode h) {
		flipColors(h);
		//Now h is a 4-node
		if(isRed(h.right.left)) { //Why check h.right.left and not h.right.right? because is not possible to have a red link on the right after adding.
			//Break 5-node
			h.right = rotateRight(h.right); //After this will create 2 red link in a row on right
			h = rotateLeft(h); // move the 2 red link to left
			flipColors(h); // this will fix 2 red link in a row problem.
		}
		return h;
	}
	
	/*
	 * Delete minimum key
	 */
	public void deleteMin() {
		if(isEmpty()) throw new NoSuchElementException("BST underflow");
		
		//Root could be the minimum so get root to RED  OR serve as initial delete
		if(isBlack(root.left) && isBlack(root.right)) root.color = RED;

		
		root = deleteMin(root);
		if(!isEmpty()) {
			root.color = BLACK;
		}
	}
	private TreeNode deleteMin(TreeNode h) {
		if(h.left == null) // remove node on bottom level (h must be RED by invariant)
			return null;
		
		if(isBlack(h.left) && isBlack(h.left.left)) //Push red link down if necessary
			h = makeRedLeft(h);
		
		h.left = deleteMin(h.left); // Move down one level
		
		return fix(h);
	}
	
	/*
	 * Delete maximum key
	 * 
	 * General strategy is carry a red-link down right subtree , if target key is found. It is within a 3-node or 4-node
	 * that way deleting a 3/4 node will not destroy balance.
	 */
	public void deleteMax() {
		if(isEmpty()) throw new NoSuchElementException("BST Underflow");
		
		//if both children of root are black, set root to RED  ( MAKE RED IF NO RED)
		if(isBlack(root.left) && isBlack(root.right)) {
			root.color = RED;
		}
		
			root = deleteMax(root);
			if(!isEmpty()) {
				root.color = BLACK;
			}		
	}
	private TreeNode deleteMax(TreeNode h) {
		if(isRed(h.left))
			h = rotateRight(h); //lean 3-nodes to right , prep for deletion
		if(h.right == null) {//remove node on bottom level (h must be RED by invariant)
			return null;
		}
		//Carry red-link down if there is not a red link at next level
		/*
		 * Also.. if h.right is the target max. then h.right must be in 3-node. That can only happen if h.right OR h.right.left is RED
		 * if none is RED , makeRedRight must be called so that h.right will be either a 3-node or 4-node
		 * 
		 * If makeRedRight() ever ran, its result will always be either h.right is RED or h.right.right is RED
		 * Now..
		 * Why check h.right + h.right.left and  NOT  h.right + h.right.right ? Answer is simple. 
		 * h.right.right should not have RED-LINK initially by design. h.right.right will possibly have red-link
		 * after first makeRedRight is called. It does make sense to check h.right for RED or h.right.left for RED 
		 * initially. 
		 * 
		 * If calling makeRedRight returns h.right is RED then when calling deleteMax(h.right which I name it x) , If x.right is target
		 * then it will be deleted. since previous deleteMax called makeRedRight and returned h.right is RED. If h.right is not target. It will try to rotate a red to right
		 * if exists a red on the left. If doesn't have red to rotate then will continue to perform x.right && x.right.left check
		 * to make a red lean right(prepare for next level). Since makeRedRight() returned h.right to be red. IT is guarantee that
		 * h.right.right IS NOT RED BY DESIGN OF makeRedRight() ! so to determine next level is ready for deletion(next node is in RED link) It needs 
		 * to check x.right  because it is possible that there exists a red on the left and was rotated to right by previous operation.
		 * If h.right is RED then next level is prep. Red can also exists at right.left by design of LLRBBST. so checking for right.left can also see if next lvl is RED ready.
		 * 
		 * If calling makeRedRight returns h.right.right is RED then similar things happens... it will still need to check
		 *  RIGHT and RIGHT.LEFT to determine if next level is RED or not. If not RED , Make RED right
		 *  
		 *
		 * NOTE: If you think about it .. if next node IS in fact target max.. it must be in RED LINK. AND WHERE ? Possibly the red link must exists?
		 * IT MUST exists h.right because it is possible that rotateRight made h.right is RED or exists at h.right.left by design
		 * 
		 * NOTE: If is for minimum.. red link can only exists h.left and h.left.left by same logic
		 * 
		 * 
		 */
		if(isBlack(h.right) && isBlack(h.right.left)) //h.right is not RED
		h = makeRedRight(h); //Make it RED
		h.right = deleteMax(h.right); // Move down one level
		h.n = size(h.left) + size(h.right) + 1;
		return fix(h); //fix right red link , double red link , break 4-node on the way up.
	}
	
	/*
	 * Delete a key/value pair
	 */
	public void delete(Key key) {
		if(key == null) {
			throw new IllegalArgumentException("argument to delete() is null");
		}
		if(!contains(key)) return;
		root = delete(root,key);
		if(!isEmpty()) root.color = BLACK;
	}
	private TreeNode delete(TreeNode h , Key key) {
		int cmp = key.compareTo(h.key);
		if(cmp < 0) { // Similar to DeleteMin Code)
			if(isBlack(h.left) && isBlack(h.left.left)) {
				h = makeRedLeft(h);
			}
			h.left = delete(h.left,key);
		} else { //RIGHT OR EQUAL (Similar to DeleteMax Code)
			//Either right or equal , still need to prep a RED to right
			if(isRed(h.left)) {
				h = rotateRight(h);
			}
			//EQUAL AND AT BOTTOM
			if(cmp == 0 && h.right == null) { //By design of LLRB, h.right must be null as if h.right is not null then perfect black doesn't exist. thus h.right must be null for successor
				return null;
			}
			//Carry red link down if necessary , just like in deleteMax()
			if(isBlack(h.right) && isBlack(h.right.left)) {
				h = makeRedRight(h);
			}
			// Now to check if is TARGET
			if(cmp == 0) {
				TreeNode min = min(h.right);
				h.key = min.key; //Replace target key with successor
				h.val = min.val;
				h.right = deleteMin(h.right);
				
			}else { // Just like in deleteMax() , if current isn't TARGET , then move one level down.
				h.right = delete(h.right,key);
			}	
		}
		return fix(h);
	}
	
	/*
	 * Return minimum key
	 */
	public Key min() {
		if(isEmpty()) throw new NoSuchElementException("Trying to get min key from empty tree");
		TreeNode x = root;
		while(x.left != null) {
			x = x.left;
		}
		return x == null ? null : x.key;
	}
	
	/*
	 * Helper function for delete() : Returns successor node
	 */
	private TreeNode min(TreeNode h) {
		TreeNode x = h;
		while(x.left != null) {
			x = x.left;
		}
		return x == null? null : x;
	}
	
	/*
	 * Return maximum key
	 */
	public Key max() {
		if(isEmpty()) throw new NoSuchElementException("Trying to get max key from empty tree");
		TreeNode x = root;
		while(x.right != null) {
			x = x.right;
		}
		return x == null ? null : x.key;
	}
	
    /**
     * Returns the largest key in the symbol table less than or equal to key
     * @param key the key
     * @return the largest key in the symbol table less than or equal to key
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if key is null
     */
	public Key floor(Key key) {
		if(key == null) throw new IllegalArgumentException("arugment to floor() is null");
		if(isEmpty()) throw new NoSuchElementException("floor() was called , but tree was empty");
		TreeNode x = floor(root,key);
		if(x == null) return null;
		else		  return x.key;
	}
	private TreeNode floor(TreeNode x , Key key) {
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
		TreeNode t = floor(x.right,key);
		if(t != null) {
			//search hit , t is now floor(key)
			return t;
		}else {
			return x; // search miss , x is the floor(key)
		}		
	}
	
    /**
     * Returns the smallest key in the symbol table greater than or equal to {@code key}.
     * @param key the key
     * @return the smallest key in the symbol table greater than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Key ceiling(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        TreeNode x = ceiling(root, key);
        if (x == null) return null;
        else           return x.key;  
    }

    // the smallest key in the subtree rooted at x greater than or equal to the given key
    private TreeNode ceiling(TreeNode x, Key key) {  
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp > 0)  return ceiling(x.right, key);
        TreeNode t = ceiling(x.left, key);
        if (t != null) return t; 
        else           return x;
    }
    
    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table. 
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>¨C1
     */
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("argument to select() is invalid: " + k);
        }
        TreeNode x = select(root, k);
        return x.key;
    }

    // the key of rank k in the subtree rooted at x
    private TreeNode select(TreeNode x, int k) {
        // assert x != null;
        // assert k >= 0 && k < size(x);
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    }  
    
    /**
     * Return the number of keys in the symbol table strictly less than {@code key}.
     * @param key the key
     * @return the number of keys in the symbol table strictly less than {@code key}
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to rank() is null");
        return rank(key, root);
    } 

    // number of keys less than key in the subtree rooted at x
    private int rank(Key key, TreeNode x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 
    
    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<Key> keys() {
        if (isEmpty()) return new LinkedList<Key>();
        return keys(min(), max());
    }
    /**
     * Returns all keys in the symbol table in the given range,
     * as an {@code Iterable}.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return all keys in the sybol table between {@code lo} 
     *    (inclusive) and {@code hi} (inclusive) as an {@code Iterable}
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *    is {@code null}
     */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to keys() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to keys() is null");

        Queue<Key> queue = new LinkedList<Key>();
        // if (isEmpty() || lo.compareTo(hi) > 0) return queue;
        keys(root, queue, lo, hi);
        return queue;
    } 
    // add the keys between lo and hi in the subtree rooted at x
    // to the queue
    private void keys(TreeNode x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 
    
    /**
     * Returns the number of keys in the symbol table in the given range.
     *
     * @param  lo minimum endpoint
     * @param  hi maximum endpoint
     * @return the number of keys in the sybol table between {@code lo} 
     *    (inclusive) and {@code hi} (inclusive)
     * @throws IllegalArgumentException if either {@code lo} or {@code hi}
     *    is {@code null}
     */
    public int size(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
        if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
	
	/*
	 * In order traversal
	 */
	public void printInOrder() {
		printInOrder(root);
	}
	private void printInOrder(TreeNode x) {
		if(x != null) {
			printInOrder(x.left);
			System.out.print(x.key + ",");
			printInOrder(x.right);
		}
	}
	
	  /***************************************************************************
	    *  Check integrity of red-black tree data structure.
	    ***************************************************************************/
	    @SuppressWarnings("unused")
		private boolean check() {
	        if (!isBST())            System.out.println("Not in symmetric order");
	        if (!isSizeConsistent()) System.out.println("Subtree counts not consistent");
	        if (!isRankConsistent()) System.out.println("Ranks not consistent");
	        if (!is23())             System.out.println("Not a 2-3 tree");
	        if (!isBalanced())       System.out.println("Not balanced");
	        return isBST() && isSizeConsistent() && isRankConsistent() && is23() && isBalanced();
	    }

	    // does this binary tree satisfy symmetric order?
	    // Note: this test also ensures that data structure is a binary tree since order is strict
	    private boolean isBST() {
	        return isBST(root, null, null);
	    }

	    // is the tree rooted at x a BST with all keys strictly between min and max
	    // (if min or max is null, treat as empty constraint)
	    // Credit: Bob Dondero's elegant solution
	    private boolean isBST(TreeNode x, Key min, Key max) {
	        if (x == null) return true;
	        if (min != null && x.key.compareTo(min) <= 0) return false;
	        if (max != null && x.key.compareTo(max) >= 0) return false;
	        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
	    } 

	    // are the size fields correct?
	    private boolean isSizeConsistent() { return isSizeConsistent(root); }
	    private boolean isSizeConsistent(TreeNode x) {
	        if (x == null) return true;
	        if (x.n != size(x.left) + size(x.right) + 1) return false;
	        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
	    } 

	    // check that ranks are consistent
	    private boolean isRankConsistent() {
	        for (int i = 0; i < size(); i++)
	            if (i != rank(select(i))) return false;
	        for (Key key : keys())
	            if (key.compareTo(select(rank(key))) != 0) return false;
	        return true;
	    }

	    // Does the tree have no red right links, and at most one (left)
	    // red links in a row on any path?
	    private boolean is23() { return is23(root); }
	    private boolean is23(TreeNode x) {
	        if (x == null) return true;
	        if (isRed(x.right)) return false;
	        if (x != root && isRed(x) && isRed(x.left))
	            return false;
	        return is23(x.left) && is23(x.right);
	    } 

	    // do all paths from root to leaf have same number of black edges?
	    private boolean isBalanced() { 
	        int black = 0;     // number of black links on path from root to min
	        TreeNode x = root;
	        while (x != null) {
	            if (!isRed(x)) black++;
	            x = x.left;
	        }
	        return isBalanced(root, black);
	    }

	    // does every path from the root to a leaf have the given number of black links?
	    private boolean isBalanced(TreeNode x, int black) {
	        if (x == null) return black == 0;
	        if (!isRed(x)) black--;
	        return isBalanced(x.left, black) && isBalanced(x.right, black);
	    } 

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RedBlackBST<String,Integer> bst = new RedBlackBST<String, Integer>();
		
		bst.add("S", 1);
		bst.add("E", 2);
		bst.add("A", 1);
		bst.add("C", 1);
		bst.add("R", 1);
		bst.add("H", 1);
		bst.add("M", 1);
		bst.add("X", 1);
		
		
		bst.printInOrder();
		System.out.println(" Size = " + bst.size());

		
		
		while(bst.size() > 0) {
			bst.deleteMax();
			bst.printInOrder();
			System.out.println(" Size = " + bst.size());
		}
		bst.deleteMax(); //This should throw exception !  , b/c tree is null/empty
		bst.printInOrder();
		System.out.println(" Size = " + bst.size());
		
	}//END MAIN

}//END RedBlackBST
