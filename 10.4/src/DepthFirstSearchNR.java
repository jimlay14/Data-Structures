import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Implementation of depth-first search algorithm that does not use recursion
 * @author Jacob
 *
 */
public class DepthFirstSearchNR {

    // Data Fields
    /** A reference to the graph being searched. */
    private Graph graph;
    /** Array of parents in the depth-first search tree. */
    private int[] parent;
    /** Flag to indicate whether this vertex has been visited. */
    private boolean[] visited;
    /** The array that contains each vertex in discovery order. */
    private int[] discoveryOrder;
    /**
	 * The index that indicates the discovery order
	 */
	private int discoverIndex = 0;
    /** The array that contains each vertex in finish order. */
    private int[] finishOrder;
	/**
	 * The index that indicates the finish order
	 */
	private int finishIndex;
    
    // Constructors
    
	/**
	 * Constructs the depth-first search of the specified graph,
	 * selecting the start vertices in the specified order.
	 * The first vertex visited is order[0]
	 * @param graph The graph
	 * @param order The array giving the order in which the start vertices should be selected
	 */
	public DepthFirstSearchNR(Graph graph){
		this.graph = graph;
		int n = graph.getNumV();
		parent = new int[n];
		visited = new boolean[n];
		discoveryOrder = new int[n];
		finishOrder = new int[n];
		finishIndex = finishOrder.length;
		for(int i = 0; i < n; i++){
			parent[i] = -1; //Declare array parent and initialize its elements to -1
		}
		
		for(int i = 0; i < n; i++){
			if(!visited[i])
				depthFirstSearch(i);
		}
	}
	
	/**
	 * Non-recursively depth-first search the graph starting at vertex current
	 * @param current The start vertex
	 */
	public void depthFirstSearch(int start) {
		// Let s be a stack, then push the start vertex onto it
		Stack<Integer> s = new Stack<Integer>();
		s.push(start);
		//While s is not empty
		while(!s.isEmpty()){
			int v = s.pop();
			//If v is not discovered
			if(!visited[v]){
				//label v as discovered
				visited[v] = true;
				discoveryOrder[discoverIndex++] = v;
				//For all edges adjacent to v
				Iterator<Edge> itr = graph.edgeIterator(v);
				while(itr.hasNext()){
					int u = itr.next().getDest();
					s.push(u);
					parent[u] = v;
				}
				finishIndex = finishIndex - 1;
				finishOrder[finishIndex] = v;
			}
		}
	}

    /** Get the finish order
     *  @return finish order
     */
    public int[] getFinishOrder() {
        return finishOrder;
    }

    /** Get the discovery order
     *  @return discovery order
     */
    public int[] getDiscoveryOrder() {
        return discoveryOrder;
    }

    /** Get the parent
     *  @return the parent
     */
    public int[] getParent() {
        return parent;
    }
    
	/**
	 * Main method to test depth-first method 
	 * pre: args[0] is the name of the input file
	 * @param args The command line arguments
	 */
	public static void main(String[] args){
		Graph g = null;
		int n = 0;
		try {
			Scanner scan = new Scanner(new File(args[0]));
			g = AbstractGraph.createGraph(scan, true, "List");
			n = g.getNumV();
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1); //Error
		}
		
		//Perform a depth-first search
		//int[] testOrder = {1,1,1,1,1,1,1};
		DepthFirstSearchNR dfs = new DepthFirstSearchNR(g);
		int[] dOrder = dfs.getDiscoveryOrder();
		int[] fOrder = dfs.getFinishOrder();
		System.out.println("Discovery and finish order:");
		for(int i = 0; i < n; i++){
			System.out.println(dOrder[i] + " " + fOrder[i]);
		}
	}
}
