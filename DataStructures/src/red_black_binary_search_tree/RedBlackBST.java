package red_black_binary_search_tree;
/*
 * Author : DIAO
 * Time created : 12/18/2018
 */

/*
 * RED-BLACK BINARY SEARCH TREE V1
 */

/*
 * Current Supported Operations :
 * 
 * public 	int size()						//Returns total number of TreeNodes 
 * private	boolean isRed(TreeNode x)		//Returns true if a TreeNode is red , Default = BLACK
 * 
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
	 * Returns total number of nodes
	 */
	public int size() {
		return size(root);
	}
	private int size(TreeNode x) {
		return x == null ? 0 : x.n;
	}
	
	/*
	 * is a node red?  Default color of a null tree is BLACK=FALSE, Any newly created TreeNode is RED
	 */
	private boolean isRed(TreeNode x) {
		if(x == null) return BLACK; 
		return x.color = RED;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
