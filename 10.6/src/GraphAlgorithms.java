import java.util.*;

/**
 * Class to implement Dijkstra's Algorithm and Prim's Algorithm
 * @author Jacob / Koffman & Wolfgang
 *
 */
public class GraphAlgorithms {
	/**
	 * Dijkstra's Shortest Path algorithm
	 * pre: graph to be searched is a weighted directed graph with only positive weights
	 * 		pred and dist are arrays of size V
	 * @param graph The weighted graph to be searched
	 * @param start The start vertex
	 * @param pred Output array to contain the predecessors in the shortest path
	 * @param dist Output array to contain the distance in the shortest path
	 */
	public static void dijkstrasAlgorithm(Graph graph,
										  int start,
										  int[] pred,
										  double[] dist){
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		//Initialize V - S
		for(int i = 0; i < numV; i++){
			if(i != start)
				vMinusS.add(i);
		}
		// Initialize pred and dist
		for(int v : vMinusS){
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		//Main loop
		while(vMinusS.size() != 0){
			//Find the value u in V - S with the smallest dist[u]
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS){
				if(dist[v] < minDist){
					minDist = dist[v];
					u = v;
				}
			}
			// Remove u from vMinusS
			vMinusS.remove(u);
			//Update the distances
			Iterator<Edge> edgeIter = graph.edgeIterator(u);
			while(edgeIter.hasNext()){
				Edge edge = edgeIter.next();
				int v = edge.getDest();
				if(vMinusS.contains(new Integer(v))){
					double weight = edge.getWeight();
					if(dist[u] + weight < dist[v]){
						dist[v] = dist[u] + weight;
						pred[v] = u;
					}
				}
			}
		}
	}
	
	/**
	 * Prim's Minimum Spanning Tree 
	 * @param graph
	 * @param start
	 * @return
	 */
	public static void primsAlgorithm(Graph graph,
												 int start,
												 int[] pred,
												 double[] dist){
		int numV = graph.getNumV();
		HashSet<Integer> vMinusS = new HashSet<Integer>(numV);
		//Initialize V - S
		for(int i = 0; i < numV; i++){
			if(i != start)
				vMinusS.add(i);
		}
		// Initialize pred and dist
		for(int v : vMinusS){
			pred[v] = start;
			dist[v] = graph.getEdge(start, v).getWeight();
		}
		//Main loop
		while(vMinusS.size() != 0){
			//Find the value u in V - S with the smallest dist[u]
			double minDist = Double.POSITIVE_INFINITY;
			int u = -1;
			for(int v : vMinusS){
				if(dist[v] < minDist){
					minDist = dist[v];
					u = v;
				}
			}
			// Remove u from vMinusS
			vMinusS.remove(u);
			//Update the distances
			Iterator<Edge> edgeIter = graph.edgeIterator(u);
			while(edgeIter.hasNext()){
				Edge edge = edgeIter.next();
				int v = edge.getDest();
				if(vMinusS.contains(new Integer(v))){
					double weight = edge.getWeight();
					if(weight < dist[v]){
						dist[v] = weight;
						pred[v] = u;
					}
				}
			}
		}
	}
}
