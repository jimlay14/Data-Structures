/**
 * Tester class for graphs
 * @author Jacob
 *
 */
public class GraphTester {
	public static void main(String[] args){
//		try {
//			Graph g = AbstractGraph.createGraph(false, "List");
//			System.out.println(g.toString());
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("\n");
		try {
			Graph g = AbstractGraph.createGraph(false, "Matrix");
			System.out.println(g.toString());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
