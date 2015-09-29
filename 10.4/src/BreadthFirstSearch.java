import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Class to implement a breadth-first search algorithm
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class BreadthFirstSearch {
	/**
	 * Perform a breadth-first search of a graph
	 * post: The array parent will contain the predecessor of each vertex in the breadth first search tree
	 * @param graph The graph to be searched
	 * @param start The start vertex
	 * @return The array of parents
	 */
	public static int[] breadthFirstSearch(Graph graph, int start){
		Queue<Integer> theQueue = new LinkedList<Integer>();
		//Declare array parent and initialize its elements to -1
		int[] parent = new int[graph.getNumV()];
		for(int i = 0; i < graph.getNumV(); i++){
			parent[i] = -1;
		}
		//Declare array identified and initialize its elements to false
		boolean[] identified = new boolean[graph.getNumV()];
		/* Mark the start vertex as identified and insert it into the queue */
		identified[start] = true;
		theQueue.offer(start);
		
		/* Perform breadth-first search until done */
		while(!theQueue.isEmpty()){
			/* Take a vertex, current, out of the queue. Begin visiting current */
			int current = theQueue.remove();
			/* Examine each vertex, neighbor, adjacent to current. */
			Iterator<Edge> itr = graph.edgeIterator(current);
			while(itr.hasNext()){
				Edge edge = itr.next();
				int neighbor = edge.getDest();
				//If neighbor has not been identified
				if(!identified[neighbor]){
					//Mark it identified
					identified[neighbor] = true;
					//Place it into the queue
					theQueue.offer(neighbor);
					/* Insert the edge (current, neighbor) into the tree */
					parent[neighbor] = current;
				}
			}
			//Finished visiting current
		}
		return parent;
	}
	
	/**
	 * Main method to test breadth-first method 
	 * pre: args[0] is the name of the input file
	 * @param args The command line arguments
	 */
	public static void main(String[] args){
		Graph g = null;
		try {
			Scanner scan = new Scanner(new File(args[0]));
			g = AbstractGraph.createGraph(scan, true, "Matrix");
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1); //Error
		}
		
		//Perform a depth-first search
		int[] parents = BreadthFirstSearch.breadthFirstSearch(g, 0);
		System.out.println("Node and Parent in tree:");
		for(int i = 0; i < parents.length; i++){
			System.out.println(i + " " + parents[i]);
		}
	}
}
