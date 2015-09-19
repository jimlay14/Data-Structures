import java.io.*;

public class BinaryTreeTester {
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		BinaryTree<String> test = new BinaryTree("Root",
												new BinaryTree("Left",
														null,
														null),
												new BinaryTree("Right",
														null,
														null));
		
		System.out.println(test.toString()); //print out initial tree
		
		//Write out the initial tree to a file
		try {
			ObjectOutputStream out =
					new ObjectOutputStream(new FileOutputStream("Binary Tree Test"));
			out.writeObject(test);
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		
		//Read the file back in
		BinaryTree<String> redux = null;
		try {
			ObjectInputStream in =
					new ObjectInputStream(new FileInputStream("Binary Tree Test"));
			redux = (BinaryTree<String>) in.readObject();
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
		
		System.out.println(redux.toString());//prove that the file was read back in correctly
		
		System.out.println(test.oneLinePreorder()); //Programming exercise 1
		System.out.println(test.oneLinePostorder()); //Programming exercise 2
		System.out.print(test.oneLineInorder()); //Programming exercise 3
	}
}
