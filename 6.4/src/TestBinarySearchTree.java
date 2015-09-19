import java.util.*;

/**
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class TestBinarySearchTree
{
	
	/** Traverses binary search tree and displays each element.
	 * Out of order elements can then be searched for
	 * @param testTree A binary search tree of integers
	 */
	public static void traverseAndShow(BinarySearchTree<Integer> testTree)
	{
		System.out.println(testTree.toString());
	}
	
	public static void main(String[] args)
	{
		BinarySearchTree<Integer> testTree = new BinarySearchTree<Integer>();
		final int MAX_INT = 500;
		final int START_SIZE = 100;
		
		//create a random number generator.
		Random random = new Random();
		for (int i = 0; i < START_SIZE; i++) {
			int anInteger = random.nextInt(MAX_INT);
			testTree.add(anInteger);
		}
		
		//Add to beginning and end of list.
		testTree.add(-1);
		testTree.add(MAX_INT + 1);
		traverseAndShow(testTree); //traverse and display
	}
}
