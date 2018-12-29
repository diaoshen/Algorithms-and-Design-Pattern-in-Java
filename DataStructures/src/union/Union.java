package union;

public class Union {

	/*
	 * id[i] = where (ID i / component i) belong to
	 */
	protected int[] id; //access to component/part by ID #
	protected int count; //number of components
	protected int sz[]; //size of each component
	
	
	/*
	 * Constructor
	 */
	public Union(int n) {
		//initially there are n components , with each component's size is 1
		//no sites/parts are connected
		count = n;
		id = new int[n];
		sz = new int[n];
		for(int i = 0 ; i < n ; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	/*
	 * Connected : returns true if component p1,p2 is in same part.
	 */
	public boolean connected(int p1 , int p2) {
		return find(p1) == find(p2);
		
	}
	
	/*
	 * Find : returns component identifier for p (0 to N-1)
	 */
	public int find(int p) {
		return quickFind(p);
	}
	
	
	/**************************************************************/

	
	/*
	 * QuickFind : returns what part component p belong to
	 * O(1)
	 */
	public int quickFind(int p) {
		return id[p];
	}
	
	/*
	 * SlowUnion : turn part 1 to part 2
	 * O(n)
	 */
	public void slowUnion(int p1, int p2) {
		//Get what "parts" component p1,p2 belong to
		int part1 = quickFind(p1);
		int part2 = quickFind(p2);
		
		//Connect part 1 to part 2 (turn any component that's part1 to part2)
		if(part1 != part2) {
			//For each component in part 1 , turn it into part 2
			for(int i = 0 ; i< id.length; i++) {
				//If component i belongs to part 1
				if(id[i] == part1) {
					id[i] = part2; //Turn into part2
					count--; //decrement component count
				}
			}
		}
	}
	
	/**************************************************************/
	
	
	
	
	
	/**************************************************************/
	
	/*
	 * SlowFind : returns what part component p belong to
	 * O(1) best case
	 * O(n) worst case (linked list tree)
	 */
	public int slowFind(int p) {
		/*
		 * Definition : 
		 * If id[p] == component ID p then p is the main part or the root of tree
		 */
		
		//Go up while is not root
		while(p != id[p]) {
			p = id[p]; //Move up the tree to see if is root
		}
		//If gets here.. p is root of input param p
		return p; 
	}
	
	/*
	 * QuickUnion : turn part 1 to part 2
	 */
	public void quickUnion(int p1 , int p2) {
		int p1_part = slowFind(p1);
		int p2_part = slowFind(p2);
		//Connect if not in same part
		if(p1_part != p2_part) {
			//parent of root p1 is root p2
			id[p1_part] = p2_part;
			count--;
		}
	}
	
	/**************************************************************/
	
	
	
	
	
	
	/*
	 * WeightedUnion
	 * 
	 * Properties: depth of any node in a forest for N sites is at most logN
	 * Therefore WeightedUnion or slowFind will have worst case O(logN)
	 */
	public void WeightedUnion(int p1 , int p2) {
		int p1_part = slowFind(p1);
		int p2_part = slowFind(p2);
		if(p1_part != p2_part) {
			//smaller part become a part of larger part
			if(sz[p1_part] < sz[p2_part]) {
				id[p1_part] = p2_part; 
				sz[p2_part] += sz[p1_part];
			}else {
				id[p2_part] = p1_part;
				sz[p1_part] += sz[p2_part];
			}
		}
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
