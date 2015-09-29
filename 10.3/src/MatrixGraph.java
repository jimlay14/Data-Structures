import java.util.*;
import java.util.function.Consumer;

/**
 * Implementation of a graph data structure with an underlying adjacency matrix
 * @author Jacob
 *
 */
public class MatrixGraph extends AbstractGraph {
	/**
	 * A matrix of edge weights
	 */
	private double[][] edges;

	/**
	 * Construct a matrix graph with the given number of vertices
	 * @param numV Number of vertices in the graph
	 * @param directed Flag indicating whether the graph is directed or not
	 */
	public MatrixGraph(int numV, boolean directed) {
		super(numV, directed);
		edges = new double[numV][numV];
		for(int i=0; i<numV; i++){
			for(int j=0; j<numV; j++){
				edges[i][j] = Double.POSITIVE_INFINITY; //fill the matrix with positive infinity values
			}
		}
	}
	
	public boolean isEdge(int source, int dest){
		return edges[source][dest] != Double.POSITIVE_INFINITY;
	}
	
	public void insert(Edge edge){
		edges[edge.getSource()][edge.getDest()] = edge.getWeight();
		if(!isDirected()){
			edges[edge.getDest()][edge.getSource()] = edge.getWeight();
		}
	}
	
	/**
	 * Internal iterator for nodes, using an underlying queue
	 * @author Jacob
	 *
	 */
	@SuppressWarnings({ "hiding", "rawtypes" })
	private class Iter<Edge> implements Iterator {
		/**
		 * A list of nodes adjacent to the node of the iterator
		 */
		private Queue<Edge> adjacentEdges;
		
		/**
		 * Constructs an iterator for the given set of edges
		 * @param adjacentEdges A queue of the edges adjacent to the source node
		 */
		public Iter(Queue<Edge> adjacentEdges){
			this.adjacentEdges = adjacentEdges;
		}

		@SuppressWarnings("unchecked")
		public void forEachRemaining(Consumer arg0) {
			((Iterator) adjacentEdges).forEachRemaining(arg0);
		}

		/**
		 * Returns whether there are any unexplored edges adjacent to the node we are iterating on
		 * @return true if there are more nodes to explore, false otherwise
		 */
		public boolean hasNext() {
			return adjacentEdges.peek() != null;
		}

		/**
		 * Returns the next unexplored edge adjacent to the node we are iterating on
		 * @return the next unexplored edge adjacent to the node we are iterating on
		 */
		public Object next() {
			return adjacentEdges.poll();
		}

		/**
		 * Remove the next edge adjacent to the node we are iterating on from the queue 
		 */
		public void remove() {
			adjacentEdges.poll();
		}
		
		public String toString(){
			return adjacentEdges.toString();
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public Iterator<Edge> edgeIterator(int source){
		Queue<Edge> adjacentEdges = new ArrayDeque<Edge>();
		int end = edges.length;
		for(int i = 0; i < end; i++){
			double weight = edges[source][i];
			if(weight != Double.POSITIVE_INFINITY){
				adjacentEdges.offer(new Edge(source, i, weight));
			}
		}
		return new Iter<Edge>(adjacentEdges);
	}
	
	public Edge getEdge(int source, int dest){
		//The weight of the edge will be the proper weight if there is an edge
		//or Double.Positive_Infinity if not
		return new Edge(source, dest, edges[source][dest]);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		int end = edges.length;
		for(int i=0; i<end; i++){
			sb.append("Node " + i + "-->\n");
			for(int j=0; j<end; j++){
				if(edges[i][j] == Double.POSITIVE_INFINITY){
					sb.append("\tnode: " + j + " is not adjacent to " + i + "\n");
				} else {
					sb.append("\tnode: " + j + ", weight: " + edges[i][j] + "\n");
				}
			}
		}
		return sb.toString();
	}
	
	@Override
	public void loadEdgesFromFile(Scanner scan){
		//System.out.println(edges.length);
		while(scan.hasNextLine())//while there are still more edges
		{
			String input = scan.nextLine();
			Scanner sc = new Scanner(input);//scan a line as an edge
			sc.useDelimiter(AbstractGraph.DELIM);//use only comma delimiter
			try
			{ //in case we fail to parse anything, such as format didn't work
				int source = sc.nextInt();//scan x position of point	
				int dest = sc.nextInt();//scan y position of point
				if(sc.hasNextDouble()){
					edges[source][dest] = sc.nextDouble();
				} else {
					edges[source][dest] = Edge.UNWEIGHTED_EDGE;
				}
			}
			catch(Exception e)	
			{
				System.out.println("Failed to parse Edge: "+input);
			}		
			sc.close();//close scanner
		}
		scan.close();
	}
}
