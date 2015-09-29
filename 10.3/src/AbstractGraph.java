import java.util.*;
import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Abstract base class for graphs. A graph is a set of vertices
 * and a set of edges. Vertices are represented by integers from 0 to n - 1.
 * Edges are ordered pairs of vertices.
 * @author Jacob / Koffman & Wolfgang
 *
 */
public abstract class AbstractGraph implements Graph {
	
	//Data Fields
	
	/**
	 * Number of vertices
	 */
	private int numV;
	/**
	 * Flag to indicate whether this is a directed graph
	 */
	private boolean directed;
	/**
	 * Comma delimiter string parsing in graphs
	 */
	public static final String DELIM = ","; //for file parsing

	
	//Constructor
	
	/**
	 * Construct a graph with the specified number of vertices. 
	 * The boolean directed indicates whether or not this is a directed graph
	 * @param numV The number of vertices
	 * @param directed The directed flag
	 */
	public AbstractGraph(int numV, boolean directed){
		this.numV = numV;
		this.directed = directed;
	}
	
	
	//Methods

	public int getNumV() {
		return numV;
	}

	public boolean isDirected() {
		return directed;
	}

	public void insert(Edge e) {
		// Completed in non abstract implementations
	}

	public boolean isEdge(int source, int dest) {
		//completed in non abstract implementations
		return false;
	}

	public Edge getEdge(int source, int dest) {
		//completed in non abstract implementations
		return null;
	}

	public Iterator<Edge> edgeIterator(int source) {
		//completed in non abstract implementations
		return null;
	}
	
	/**
	 * Load the edges of a graph from the data in an input file.
	 * The file should contain a series of lines, each line
	 * with two or three data values. The first is the source,
	 * the second is the destination, and the optional third is the weight.
	 * @param scan The Scanner connected to the data file
	 */
	public void loadEdgesFromFile(Scanner scan){
		//implemented by non abstract subclasses
	}
	
	/**
	 * Create a graph without a specified scanner, using a JFileChooser to pick out a graph
	 * @param isDirected true if the Graph is to be a directed graph
	 * @param type Flag for whether the graph is implemented with an adjacency list or an adjacency matrix
	 * @return A graph from the user's chosen file
	 * @throws IlegalArgumentException if type is neither "Matrix" nor "List"
	 */
	public static Graph createGraph(boolean isDirected, String type) throws IOException {
		Scanner sc = null;
		JFileChooser chooser = new JFileChooser(); //a file chooser
		chooser.setFileFilter(new FileNameExtensionFilter("Text files", "txt")); //for txt files
		int returnVal = chooser.showOpenDialog(chooser); //show the dialog to OPEN
		if(returnVal == JFileChooser.APPROVE_OPTION){ //if they picked something
			try {
				sc = new Scanner(chooser.getSelectedFile()); //parse it with Scanner
			} catch(Exception e) {
				System.out.println("Error loading from file: "+e);
				e.printStackTrace();
			}
		}
		return createGraph(sc, isDirected, type);
	}
	
	/**
	 * Factory method to create a graph and load the data from an input file.
	 * The first line of the input file should contain the number of vertices.
	 * The remaining lines should contain the edge data as described in loadEdgesFromFile.
	 * @param scan The scanner connected to the data file
	 * @param isDirected true if this is a directed graph, false otherwise
	 * @param type The string "Matrix" if an adjacency matrix is to be created, 
	 * 		       and the string "List" if an adjacency list is to be created.
	 * @return The Graph from the data file
	 * @throws IlegalArgumentException if type is neither "Matrix" nor "List"
	 */
	public static Graph createGraph(Scanner scan, 
									boolean isDirected, 
									String type) throws IOException {
		int numV = scan.nextInt();
		scan.nextLine(); //move to the next line
		AbstractGraph returnValue = null;
		if(type.equalsIgnoreCase("Matrix"))
			returnValue = new MatrixGraph(numV, isDirected);
		else if (type.equalsIgnoreCase("List"))
			returnValue = new ListGraph(numV, isDirected);
		else
			throw new IllegalArgumentException();
		returnValue.loadEdgesFromFile(scan);
		return returnValue;
	}

}
