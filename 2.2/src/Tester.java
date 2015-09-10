import java.util.*;

/**
 * A class to test the examples and exercises of 2.2
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester {

	/**
	 * A method to test the examples and exercises of 2.2
	 * @param args No argument list
	 */
	public static void main(String[] args) 
	{
		intArrayAdder(); // test example 2.3
		System.out.println("\n");
		Directory theDirectory = new Directory(); // create a new directory
		theDirectory.phoneDirectory(); // test the phone directory application
	}
	
	/**
	 * A method to test example 2.3 
	 * @return The ArrayList result
	 */
	public static ArrayList<Integer> intArrayAdder()
	{
		ArrayList<Integer> someInts = new ArrayList<Integer>();
		int[] nums = {5, 7, 2, 15};
		for(int i = 0; i < nums.length; i++)
			someInts.add(nums[i]);//for each item in the array, add it to the ArrayList
		printList(someInts);
		
		int sum = 0;
		for(int i = 0; i < someInts.size(); i++)
			sum += someInts.get(i); // sum up items
		System.out.println("sum is " + sum); // print out sum
		
		return someInts;
	}
	
	/**
	 * A custom method to print out all the elements of an integer ArrayList in a single line and the index
	 * @param theList the list to print
	 */
	public static void printList(ArrayList<Integer> theList)
	{
		for(int i = 0; i < theList.size(); i++)
		{
			System.out.print(theList.get(i) + ", "); // print out each item of list
		}
		System.out.println("Size: " + theList.size());
	}
	
}
