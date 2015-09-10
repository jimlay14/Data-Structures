import java.util.*;

/**
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class TestOrderedList 
{
	
	/** Traverses ordered list and displays each element.
	 * Displays an error message if an element is out of order.
	 * @param testList An ordered list of integer
	 */
	public static void traverseAndShow(OrderedList<Integer> testList)
	{
		int prevItem = testList.get(0);
		//Traverse ordered list and display any value that is out of order
		for (int thisItem : testList) {
			System.out.println(thisItem);
			if(prevItem > thisItem) //if any item in the list is less than a previous item
				System.out.println("*** FAILED, value is " + thisItem);
			prevItem = thisItem; //move the previous item
		}
	}
	
	public static void main(String[] args)
	{
		OrderedList<Integer> testList = new OrderedList<Integer>();
		final int MAX_INT = 500;
		final int START_SIZE = 100;
		
		//create a random number generator.
		Random random = new Random();
		for (int i = 0; i < START_SIZE; i++) {
			int anInteger = random.nextInt(MAX_INT);
			testList.add(anInteger);
		}
		
		//Add to beginning and end of list.
		testList.add(-1);
		testList.add(MAX_INT + 1);
		traverseAndShow(testList); //traverse and display
		
		//Remove first, last, and middle elements.
		Integer first = testList.get(0);
		Integer last = testList.get(testList.size() - 1);
		Integer middle = testList.get(testList.size() / 2);
		testList.remove(first);
		testList.remove(middle);
		testList.remove(last);
		traverseAndShow(testList); //traverse and display
	}
	
}
