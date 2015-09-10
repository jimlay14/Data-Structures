import java.util.*;

public class ReadInt 
{
	public static int readInt(Scanner scan, int minN, int maxN)
	{
		if(minN > maxN)
			throw new IllegalArgumentException(
					"In readInt, minN " + minN + " not <= maxN " + maxN);
		boolean inRange = false; //assume no valid number read
		System.out.println("inRange = " + inRange);
		int n = 0;
		while (!inRange) { //repeat until valid number read.
			System.out.println(
					"Enter an integer from " + minN + " to " + maxN + ": ");
			try {
				n = scan.nextInt();
				inRange = (minN <= n && n <= maxN);
				System.out.println("n = " + n + " inRange = " + inRange);
			} catch (InputMismatchException ex) {
				scan.nextLine();
				System.out.println("not an integer - try again");
			}
		} //end while
		System.out.println("End of program");
		return n; //n is in range
	}
}
