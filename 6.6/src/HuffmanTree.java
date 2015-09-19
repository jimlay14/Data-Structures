import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.io.*;

/**
 * Class to represent and build a Huffman tree (generic)
 * @author Jacob / Koffman & Wolfgang
 *
 */
@SuppressWarnings("serial")
public class HuffmanTree<T> implements Serializable{
	//Data fields
	/**
	 * A reference to the completed Huffman tree
	 */
	private BinaryTree<HuffData<T>> huffTree;
	
	//Methods
	/**
	 * Builds the Huffman tree using the given alphabet and weights
	 * post: huffTree contains a reference to the Huffman tree
	 * @param symbols An array of HuffData objects
	 */
	public void buildTree(HuffData<T>[] symbols){
		//Create a new priority queue for storing BinaryTree<HuffData<T>> objects
		Queue<BinaryTree<HuffData<T>>> theQueue =
				new PriorityQueue<BinaryTree<HuffData<T>>>
					(symbols.length, new CompareHuffmanTrees<T>());
		//load the queue with the leaves (leaves are in order of weight)
		for(HuffData<T> nextSymbol : symbols){
			BinaryTree<HuffData<T>> aBinaryTree =
					new BinaryTree<HuffData<T>>(nextSymbol, null, null);
			theQueue.offer(aBinaryTree);
		}
		//Build the tree
		while (theQueue.size() > 1){
			BinaryTree<HuffData<T>> left = theQueue.poll();
			BinaryTree<HuffData<T>> right = theQueue.poll();
			double wl = left.getData().weight;
			double wr = right.getData().weight;
			//Create new tree with sum of weights of children
			HuffData<T> sum = new HuffData<T>(wl + wr, null);
			BinaryTree<HuffData<T>> newTree =
					new BinaryTree<HuffData<T>>(sum, left, right);
			theQueue.offer(newTree);
		}
		//The queue should now contain only one item
		huffTree = theQueue.poll();
	}
	
	public String printTree(){
		PrintStream out = new PrintStream(System.out);
		String code = "";
		printCode(out, code, huffTree);
		return out.toString();
	}
	
	/**
	 * Outputs the resulting code
	 * @param out  A PrintStream to write the output to
	 * @param code The code up to this node
	 * @param tree The current node in the tree
	 */
	private void printCode(PrintStream out, String code, BinaryTree<HuffData<T>> tree){
		HuffData<T> theData = tree.getData();
		if(theData.symbol != null){
			if(theData.symbol.equals(" ")){
				out.println("space: " + code);
			} else {
				out.println(theData.symbol + ": " + code);
			}
		} else {
			printCode(out, code + "0", tree.getLeftSubtree());
			printCode(out, code + "1", tree.getRightSubtree());
		}
	}
	
	/**
	 * Decodes an encrypted message using the current huffman tree
	 * @param codedMessage The string of the coded message
	 * @return The decoded message as a String
	 */
	public String decode(String codedMessage){
		StringBuilder result = new StringBuilder();
		BinaryTree<HuffData<T>> currentTree = huffTree;
		int len = codedMessage.length();
		for(int i = 0; i < len; i++){
			if(codedMessage.charAt(i) == '1'){
				currentTree = currentTree.getRightSubtree();
			} else {
				currentTree = currentTree.getLeftSubtree();
			}
			if(currentTree.isLeaf()){
				HuffData<T> theData = currentTree.getData();
				result.append(theData.symbol);
				currentTree = huffTree;
			}
		}
		return result.toString();
	}
	
	/**
	 * Programming Exercise 5; encodes a string of letters
	 * @param letters The string of letters passed in
	 * @param codes Binary digits for the symbols
	 */
	public void encode(String letters, String[] codes){
		//TODO
	}
	
	//Inner Classes
	/**
	 *  A comparator for Huffman trees; nested class
	 * @author Jacob
	 *
	 * @param <T>
	 */
	private static class CompareHuffmanTrees <T> implements Comparator<BinaryTree<HuffData<T>>>{
		/**
		 * Compare two objects
		 * @param treeLeft the left-hand object
		 * @param treeRight the right-hand object
		 * @return -1 if treeLeft is less than right
		 * 			0 if treeLeft and treeRight are equal
		 * 			and 1 if left is greater than right
		 */
		public int compare(BinaryTree<HuffData<T>> treeLeft, BinaryTree<HuffData<T>> treeRight) {
			double wLeft = treeLeft.getData().weight;
			double wRight = treeRight.getData().weight;
			return Double.compare(wLeft, wRight);
		}

		public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
				Function<? super T, ? extends U> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T, U> Comparator<T> comparing(
				Function<? super T, ? extends U> arg0,
				Comparator<? super U> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T> Comparator<T> comparingDouble(
				ToDoubleFunction<? super T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T> Comparator<T> comparingInt(
				ToIntFunction<? super T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T> Comparator<T> comparingLong(
				ToLongFunction<? super T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T> Comparator<T> nullsFirst(Comparator<? super T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T> Comparator<T> nullsLast(Comparator<? super T> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
			// TODO Auto-generated method stub
			return null;
		}

		public Comparator<BinaryTree<HuffData<T>>> reversed() {
			// TODO Auto-generated method stub
			return null;
		}

		public Comparator<BinaryTree<HuffData<T>>> thenComparing(
				Comparator<? super BinaryTree<HuffData<T>>> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <U extends Comparable<? super U>> Comparator<BinaryTree<HuffData<T>>> thenComparing(
				Function<? super BinaryTree<HuffData<T>>, ? extends U> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public <U> Comparator<BinaryTree<HuffData<T>>> thenComparing(
				Function<? super BinaryTree<HuffData<T>>, ? extends U> arg0,
				Comparator<? super U> arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		public Comparator<BinaryTree<HuffData<T>>> thenComparingDouble(
				ToDoubleFunction<? super BinaryTree<HuffData<T>>> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Comparator<BinaryTree<HuffData<T>>> thenComparingInt(
				ToIntFunction<? super BinaryTree<HuffData<T>>> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		public Comparator<BinaryTree<HuffData<T>>> thenComparingLong(
				ToLongFunction<? super BinaryTree<HuffData<T>>> arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	/**
	 * A datum in the Huffman Tree
	 * @author Jacob / Koffman & Wolfgang
	 *
	 */
	public static class HuffData<T> implements Serializable {
		//Data Fields
		/**
		 * The weight or probability assigned to this HuffData
		 */
		private double weight;
		/**
		 * The symbol if the datum is a leaf
		 */
		private T symbol;
		
		public HuffData(double weight, T symbol){
			this.weight = weight;
			this.symbol = symbol;
		}
	}
}
