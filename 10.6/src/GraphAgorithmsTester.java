import java.io.*;
import java.util.*;

/**
 * Class to test the implementations of Dijkstra's algorithm and Prim's Algorithm
 * @author Jacob
 *
 */
public class GraphAgorithmsTester {
	public static void main(String[] args){
		int numV = 0; // The number of vertices.
		Graph graph = null;
		//Load the graph from a file.
		try {
			Scanner scan = new Scanner(new File(args[0]));
			graph = AbstractGraph.createGraph(scan, false, "List");
			numV = graph.getNumV();
		} catch (IOException ex) {
			System.err.println("IO Error while reading graph");
			System.err.println(ex.toString());
			System.exit(1);
		}
		//arrays for predecessors and distances
		int[] pred = new int[numV];
		double[] dist = new double[numV];
		
		//Execute Dijkstra's algorithm on the graph
		int start = 0;
		GraphAlgorithms.dijkstrasAlgorithm(graph, start, pred, dist);
		System.out.println("Node, Predecessor, and Distance:");
		for(int i = 0; i < pred.length; i++){
			System.out.println(i + ":\t" + pred[i] + "\t" + dist[i]);
		}
		System.out.print("\n");
		
		//Execute Prim's algorithm on the graph
		int[] pred2 = new int[numV];
		double[] dist2 = new double[numV];
		GraphAlgorithms.primsAlgorithm(graph, start, pred2, dist2);
		System.out.println("The Minimum Spanning Tree from " + start + " includes the following edges:");
		for(int i = 0; i < pred2.length; i++){
			System.out.println(i + ":\t" + pred2[i] + "\t" + dist2[i]);
		}
	}
}
