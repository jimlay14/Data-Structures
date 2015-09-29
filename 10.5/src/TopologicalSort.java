import java.io.*;
import java.util.*;

/**
 * Class for outputting the topological sort of a directed graph that contains no cycles.
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class TopologicalSort {
	/**
	 * Main method that performs a topological sort.
	 * pre: args[0] contains the name of the file 
	 * 				that contains the graph. It has no cycles.
	 * @param args The command line arguments
	 */
	public static void main(String[] args){
		Graph theGraph = null;
		int numVertices = 0;
		try {
			//Connect Scanner to input file
			Scanner scan = new Scanner(new File(args[0]));
			//Load the graph from the data file
			theGraph = AbstractGraph.createGraph(scan, true, "List");
			numVertices = theGraph.getNumV();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		//Perform the depth-first search
		DepthFirstSearch dfs = new DepthFirstSearch(theGraph);
		//obtain the finish order
		int[] finishOrder = dfs.getFinishOrder();
		//Print the vertices in reverse finish order.
		System.out.println("The topological sort is:");
		for(int i = numVertices - 1; i >= 0; i--)
			System.out.println(finishOrder[i]);
	}
}
