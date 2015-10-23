/**
 * Class to test the implementation of the Red-Black Tree
 * @author Jacob
 *
 */
public class RedBlackTreeTester {
	public static void main(String[] args){
		RedBlackTree<String> testOne = new RedBlackTree<String>();
		testOne.add("The");
		testOne.add("quick");
		testOne.add("brown");
		testOne.add("fox");
		testOne.add("apple");
		testOne.add("cat");
		testOne.add("hat");
		System.out.println(testOne.toString());
		
		RedBlackTree<String> testTwo = new RedBlackTree<String>();
		testTwo.add("Now");
		testTwo.add("is");
		testTwo.add("time");
		testTwo.add("for");
		testTwo.add("all");
		testTwo.add("good");
		testTwo.add("men");
		testTwo.add("to");
		testTwo.add("come");
		testTwo.add("to");
		testTwo.add("the");
		testTwo.add("aid");
		testTwo.add("of");
		testTwo.add("the");
		testTwo.add("party");
		System.out.println(testTwo.toString());
	}
}
