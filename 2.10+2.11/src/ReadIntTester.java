import java.util.*;

public class ReadIntTester 
{
	public static void main(String[] args)
	{
		Scanner n = new Scanner(System.in);
		ReadInt.readInt(n, 0, 10);
		
		readInt(n, 0, 100);
	}
	
	/**
	 * Stub for the method readInt
	 * pre: A Scanner has been created for the method to use, 
	 * and a min and max input have been created
	 * post: The input is scanned until a number within the proper range is found.
	 * @return 0; stub
	 */
	public static int readInt(Scanner n, int minN, int maxN)
	{
		System.out.println("readInt has been called");
		System.out.println("minN = " + minN + " maxN = " + maxN);
		n.close();
		return 0;
	}
	
	//Self Check 4
	//a. (white-box testing):
	// -) Input with minNlarger than maxN, to test the IllegalArgumentException.
	// -) Add a print statement for when inRange changes from false to true (and is made).
	// -) Input with n in range and n out of range to test the InputMismatchException.
	// -) Add a print statement for when n is made and changes from the inputs
	//b. (black-box testing):
	// -) Input a number below, within, and above range to see if the response is correct.
	// -) Input a minN that is smaller, equal to, and greater than maxN.
}
