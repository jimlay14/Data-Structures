/**
 * A method to test the Self Check, Programming, and Examples from 2.3
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester 
{
	/**
	 * Main method for tests
	 * @param args No argument list
	 */
	public static void main(String[] args)
	{
		int[] anArray = {0, 1, 2, 3, 4, 5, 6, 7}; //create a new int[] named anArray
		printArray(anArray);
		System.out.println("First change...");
		for(int i = 3; i < anArray.length - 1; i++)// for each item after the fourth element in the list up until the second to last item
			anArray[i + 1] = anArray[i]; // make the next item a copy of the fourth item
		printArray(anArray); //each item after the third is the number 3
		
		System.out.println("\n");
		int[] anArray2 = {0, 1, 2, 3, 4, 5, 6, 7}; //create a new int[] named anArray
		printArray(anArray2);
		System.out.println("Second change ...");
		for(int i = anArray2.length - 1; i > 3; i--) //from the last item down to the fourth item
			anArray2[i] = anArray2[i - 1]; //make the item a copy of the item before it
		printArray(anArray2); //each item after the third item has been subtracted by one, or is the number at the index before it 
		
		System.out.println("\n"); //demonstration of the KWArrayList
		KWArrayList<Integer> ints = new KWArrayList<Integer>();
		ints.add(24);
		ints.add(26);
		ints.add(28);
		ints.add(30);
		ints.add(32);
		printArrayList(ints);
		System.out.println("Moving middle to end...");
		ints.moveMiddleToEnd(); // demonstrate moving middle to end
		printArrayList(ints);
		System.out.println("The index of 26 is " + ints.indexOf(26)); // demonstrate finding the index of an item
	}
	
	/**
	 * Custom method to print out an int array's data
	 * @param data The int array to print
	 */
	public static void printArray(int[] data)
	{
		for(int i = 0; i < data.length; i++)
			System.out.print(data[i] + ", ");
		System.out.println("length = " + data.length);
	}
	
	/**
	 * Custom method to print out a KWArrayList
	 * @param data the list to print
	 */
	public static void printArrayList(KWArrayList<Integer> data)
	{
		for(int i = 0; i < data.size(); i++)
			System.out.print(data.get(i) + ", ");
		System.out.println("size = " + data.size());
	}
		
}
