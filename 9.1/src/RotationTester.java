/**
 * Class to perform the self-check exercises from section 9.1
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class RotationTester {
	public static void main(String[] args){
		BinarySearchTree<String> one = new BinarySearchTree<String>();
		one.add("Now");
		one.add("is");
		one.add("the");
		one.add("time");
		one.add("for");
		one.add("all");
		one.add("good");
		one.add("men");
		one.add("to");
		one.add("come");
		one.add("to");
		one.add("the");
		one.add("aid");
		one.add("of");
		one.add("the");
		one.add("party");
		System.out.println(one.toString()); //we switch the toString method to print the words in order or in tree form
	}
}
