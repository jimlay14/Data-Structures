/**
 * Class to test the AVL Tree implementation
 * @author Jacob
 *
 */
public class AVLTreeTester {
	
	public static void main(String[] args){
		AVLTree<String> testOne = new AVLTree<String>();
		testOne.add("The");
		testOne.add("quick");
		testOne.add("brown");
		testOne.add("fox");
		testOne.add("apple");
		testOne.add("cat");
		testOne.add("hat");
		System.out.println(testOne.toString());
		
		AVLTree<Integer> testTwo = new AVLTree<Integer>();
		testTwo.add(30);
		testTwo.add(40);
		testTwo.add(15);
		testTwo.add(25);
		testTwo.add(90);
		testTwo.add(80);
		testTwo.add(70);
		testTwo.add(85);
		testTwo.add(15);
		testTwo.add(72);
		System.out.println(testTwo.toString());
		
		AVLTree<String> testThree = new AVLTree<String>();
		testThree.add("Now");
		testThree.add("is");
		testThree.add("time");
		testThree.add("for");
		testThree.add("all");
		testThree.add("good");
		testThree.add("men");
		testThree.add("to");
		testThree.add("come");
		testThree.add("to");
		testThree.add("the");
		testThree.add("aid");
		testThree.add("of");
		testThree.add("the");
		testThree.add("party");
		System.out.println(testThree.toString());
 	}

}
