import java.util.*;

/**
 * A class to test out examples from 1.6
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester 
{
	/**
	 * Test examples for section 1.6 - by Koffman & Wolfgang
	 * @param args No argument list
	 */
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		try{
			int num = getIntValue(scan);
			processPositiveInteger(num);
		} catch(IllegalArgumentException ex){
			System.err.println(ex.getMessage());
			System.exit(1); // error indication
		}
		System.exit(0); // normal exit
		
//		If it is possible for count to be 0, the following statement will cause a division by 0 error,
//		Also known as an ArithmeticException
//		average = sum / count;
//		The following statement will check for 0, avoiding the error
//		if(count == 0)
//			average = 0;
//		else
//			average = sum / count;

		
//		This loop would cause an ArrayIndexOutOfBoundsException, as it will be out of bounds on the last pass
//		int[] scores = new int[500];
//		for(int i = 0; i <= x.length; i++)
//			x[i] = i*i;
	}

	
	/**
	 * A method to get an int value from a scanner
	 * If the scanner does not provide an int value, this method will catch the unchecked exception that is thrown and handle it
	 * @param scan The scanner to get the int from
	 * @return The scanner's next int
	 */
	public static int getIntValue(Scanner scan)
	{
		int nextInt = 0; // next int value
		boolean validInt = false; // flag for valid input
		while(!validInt)
		{
			try{
				System.out.println("Enter number of kids:");
				nextInt = scan.nextInt();
				validInt = true;
			} catch(InputMismatchException ex){
				scan.nextLine(); // clear buffer
				System.out.println("Bad data -- enter an integer");
			}
		}
		System.out.println("int = " + nextInt);
		return nextInt;
	}
	
	/**
	 * A method to process a positive integer
	 * @param n The integer input; an IllegalArgumentException will be thrown if n is not positive, but this will not be handled
	 */
	public static void processPositiveInteger(int n)
	{
		if(n < 0)
		{
			throw new IllegalArgumentException("Invalid negative argument");
		}
		else
		{
			//process n as required
			//... (we will not have any processing here)
			System.out.println("Finished processing " + n);
		}
	}
}
