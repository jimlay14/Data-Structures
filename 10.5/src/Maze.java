import java.io.*;
import java.util.*;

/**
 * Program to solve a maze represented as a graph.
 * This program performs a breadth-first search of the graph
 * to find the "shortest" path from the start vertex to the end.
 * It is assumed that the start vertex is 0, and the end vertex is numV - 1.
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class Maze {
	/**
	 * Main method to solve the maze.
	 * pre: args[0] contains the name of the input file.
	 * @param args Command line argument
	 */
	public static void main(String[] args){
		int numV = 0; // The number of vertices.
		Graph theMaze = null;
		//Load the graph from a file.
		try {
			Scanner scan = new Scanner(new File(args[0]));
			theMaze = AbstractGraph.createGraph(scan, false, "List");
			numV = theMaze.getNumV();
		} catch (IOException ex) {
			System.err.println("IO Error while reading graph");
			System.err.println(ex.toString());
			System.exit(1);
		}
		//Perform breadth-first search
		int[] parent = BreadthFirstSearch.breadthFirstSearch(theMaze, 0);
		//Construct the path
		Stack thePath = new Stack();
		int v = numV - 1;
		while(parent[v] != -1){
			thePath.push(new Integer(v));
			v = parent[v];
		}
		//Output the path.
		System.out.println("The shortest path is:");
		while(!thePath.empty()){
			System.out.println(thePath.pop());
		}
	}
}
