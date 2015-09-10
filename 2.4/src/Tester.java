/**
 * A c;ass containing examples and program tests from 2.4
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		int n = 3;
		
//	    a.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				System.out.println(i + " " + j); // n * n output; i * j
//		O(n) = O(n^2)
		System.out.println("Test A complete" + "\n");
		
//		b.
		for(int i = 0; i < n; i++)
			for(int j = 0; j < 2; j++)
				System.out.println(i + " " + j); // executes n * 2 times; n^2 depending on size
//		O(n) = O(n) (does not increase quadratically after n = 3)
		System.out.println("Test B complete" + "\n");
		
//		c.
		for(int i = 0; i < n; i++) // normal loop
			for(int j = n - 1; j >= i; j--) // executes n, n - 1; ... 1 times
				System.out.println(i + " " + j); // executes n + (n * (n - 1)/ 2) times
//		O(n) = O(n^2)
		System.out.println("Test C complete" + "\n");
		
//		d.
		for(int i = 1; i < n; i++) // loop minus 1
			for(int j = 0; j < i; j++) // loop until other is reached; 1, 2, ...n-1 times
				System.out.println(i + " " + j); // executes n * (n - 1)/ 2 times (another form of above loop)
//		O(n) = O(n^2)
		System.out.println("Test D complete" + "\n");
		
		programCompare(); //run programming exercise
		
	}
	
	/**
	 * Basic search an array for an item's index
	 * Search executes on average x.length / 2 times
	 * Execution time is directly proportional to size of the array: x.length
	 * O(n) = O(n)
	 */
	public static int search(int[] x, int target)
	{
		for(int i = 0; i < x.length; i++)
		{
			if(x[i] == target) //
				return i; // average over all cases is x.length / 2
		}
		return -1; //item not found; for loop executes x.length times
	}
	
	/**
	 * Determine whether two arrays have no common elements
	 * @param x One array
	 * @param y The other array
	 * @return True if there are no common elements
	 * 
	 * Loop body executes x.length times
	 * Search method executes y.length times
	 * Total execution time: product of x.length and y.length
	 * O(n) = O(n^2) (product of two inputs; assuming equal length)
	 */
	public static boolean areDifferent(int[] x, int[] y)
	{
		for(int i = 0; i < x.length; i++)
		{
			if(search(y, x[i]) != -1)
				return false; // if one item from x is in y, the two have common elements
		}
		return true;
	}
	
	/**
	 * Determines whether contents of an array are all unique
	 * @param x The arrray
	 * @return True if all elements are unique
	 * 
	 * First loop executes x.length times
	 * Second loop executes x.ength times
	 * Total execution time: x.length^2
	 * O(n) = O(n^2)
	 */
	public static boolean areUnique1(int[] x)
	{
		for(int i = 0; i < x.length; i++) // loop executes x.length times
		{
			for(int j = 0; j < x.length; j++) // loop executes x.length times
			{
				if(i != j && x[i] == x[j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Determine whether contents of an array are all unique in a more efficient manner than 1
	 * @param x The array
	 * @return True if all elements of x are unique
	 * 
	 * First loop excutes x.length times
	 * Second loop executes x.length - 1 the first time, x.length - 2 the second, and so on
	 * Total execution: x.length * (x.length - 1)/2
	 * O(n) = O(n^2) (but still faster than other version of method
	 */
	public static boolean areUnique2(int[] x)
	{
		for(int i = 0; i < x.length; i++) // one loop
		{
			for(int j = i + 1; j < x.length; j++) // second loop iterates one less time than first loop
			{
				if(x[i] == x[j])
					return false; // return false if two different items are the same
			}
		}
		return true; // no elements are the same
	}
	
	/**
	 * Program to perform the comparisons of programming exercise 1 for section 2.4
	 */
	public static void programCompare()
	{
		for(int n = 10; n < 110; n+=10) // for increments of 10 up until 100
		{
			double y1 = 100 * n + 10; // find y1
			double y2 = 5 * n * n + 2; //find y2
			System.out.println("y1 = " + y1 +
					" y2 = " + y2); //print out the comparison
		}
	}

}
