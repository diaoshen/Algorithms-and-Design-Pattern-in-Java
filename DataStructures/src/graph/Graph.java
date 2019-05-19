package graph;



import java.util.LinkedList;
import java.util.List;

public class Graph {

	private int V = 0; //number of vertices
	private int E; //number of edges
	private List<Integer>[] neighbor; //adjacency list  OR  Neighbors
	
	
	/*
	 * Constructor : create a V-vertex graph with no edges
	 */
	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		neighbor = new LinkedList[V]; // Create array of linked list.
		for(int i = 0 ; i < V ; i++) {
			neighbor[i] = new LinkedList<Integer>();
		}
	}
	
	/*
	 *  #  of Vertices
	 *  Returns : number of vertices
	 */
	public int getNumV() {
		return V;
	}
	
	/*
	 * # of Edges
	 * Return : number of edges
	 */
	public int getNumE() {
		return E;
	}
	
	/*
	 * addEdge(v,w) : Add edge v-w to graph
	 */
	public void addEdge(int v , int w) {
		neighbor[v].add(w);
		neighbor[w].add(v);
		E++;
	}
	
	/*
	 *  GetNeighbor(v) : Returns neighbor of input vertex v
	 */
	public Iterable<Integer> neighbor(int v){
		return neighbor[v];
	}
	
	/*
	 * degree(v) : Returns degree of given vertex
	 */
	public static int degree(Graph G, int v) {
		int degree = 0;
		for(@SuppressWarnings("unused") int w : G.neighbor(v)) {
			degree++;
		}
		return degree;
	}
	
	/*
	 * maxDegree() : Returns max degree in a graph
	 */
	public static int maxDegree(Graph g) {
		int max = 0;
		for(int i = 0 ; i < g.getNumV(); i++) {
			int degree = degree(g,i);
			if(degree > max) 
				max = degree;
		}
		return max;
	}
	
	/*
	 * avgDegree() : Returns average degree in a graph
	 */
	public static int avgDegree(Graph g) {
		return 2* g.getNumE() / g.getNumV();
	}
	
	/*
	 * numSelfLoops() : Returns number of self loops in a graph
	 */
	public static int numSelfLoops(Graph g) {
		int count = 0;
		//For each vertex
		for(int v = 0 ; v < g.getNumV() ; v++) {
			//For each neighbor of vertex v
			for(int n : g.neighbor(v)) {
				if(n == v) count++;
			}
		}
		return count/2; //If there is a self loop then it will appear 2x
		//This is because addEdge adds twice in the list for self loop
		//So count is really double counted.
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
