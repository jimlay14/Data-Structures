
import java.util.*;

/**
 * A class to test examples from 2.1
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester {

	/**
	 * Tester main method; tests each different example of the list
	 * @param args No argument list
	 */
	public static void main(String[] args) 
	{
		List<String> dList = dwarfList();//test out the dwarf list
		System.out.println("\n");
		nonGeneric(); //test the small non-generic list
		System.out.println("\n");
		selfCheck(dList); //test self check exercise
		System.out.println("\n");
		programming();
		
//		Form of creating a generic collection:
//		CollectionClassname<E> variable = new CollectionClassName<E>();
	}
	
	/**
	 * A method for testing Example 2.1
	 * @return The ending list of dwarfs, for self check 1 testing
	 */
	public static List<String> dwarfList()
	{
		List<String> myList = new ArrayList<String>();
		myList.add("Bashful");
		myList.add("Awful");
		myList.add("Jumpy");
		myList.add("Happy");
		printList(myList);
		System.out.println("Adding Doc at 2...");
		myList.add(2, "Doc");
		printList(myList);
		System.out.println("Adding Dopey...");
		myList.add("Dopey");
		printList(myList);
		System.out.println("Removing the dwarf at 1 (Awful) ...");
		myList.remove(1);
		printList(myList);
		System.out.println("Setting Sneezy at 2 (replacing Jumpy)...");
		myList.set(2, "Sneezy");
		printList(myList);
		System.out.println("Jumpy is at index " + myList.indexOf("Jumpy") + " and therefore is not in the list.");
		System.out.println("Sneezy is at index " + myList.indexOf("Sneezy") + " and therefore is in the list.");
		return myList;
	}
	
	/**
	 * A method to demonstrate a nonGeneric list
	 * Generic warnings are suppressed to follow textbook code
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void nonGeneric()
	{
		ArrayList yourList = new ArrayList();
		yourList.add(new Integer(35));
		yourList.add("bunny");
		yourList.add(new Double(3.14));
		printNonGenericList(yourList);
//		String animal = yourList.get(1); // invalid; incompatible types when running
		System.out.print("Getting the animal...it is a ... ");
		String animal = (String) yourList.get(1); // correct version of statement
		System.out.println(animal);
//		String animalTwo = (String) yourList.get(2); //will cause cast class exception during run time		
	}
	
	/**
	 * A method to test the self check exercise for 2.1
	 * @param dwarfList the completed dwarfList example
	 */
	public static void selfCheck(List<String> dwarfList)
	{
		List<String> myList = dwarfList;
		System.out.println("Adding Pokey...");
		myList.add("Pokey"); //adds "Pokey" to the end of the list, and increases size to 6
		printList(myList);
		System.out.println("Adding Campy...");
		myList.add("Campy"); //adds "Campy to end of list, increasing size to 7
		printList(myList);
		int i = myList.indexOf("Happy"); //finds index of Happy (3), does not increase size
		System.out.println("Happy is at index " + i);
		System.out.println("Setting Bouncy at where Happy is...");
		myList.set(i, "Bouncy"); //puts bouncy where Happy is, replacing Happy (size is same)
		printList(myList);
		int j = myList.size() - 2;
		System.out.println("Removing index " + j);
		myList.remove(myList.size() - 2); // removes the second to last dwarf, decreasing the size by one (to 6)
		printList(myList);
		System.out.println("Upper casing the second dwarf...");
		String temp = myList.get(1); //getting a temporary string of the second dwarf; size does not change
		myList.set(1, temp.toUpperCase()); // replaces the second dwarf with a capitalized version of its name; size does not change
		printList(myList);
	}
	
	/**
	 * A custom method to print out all the elements of a list in a single line and the index
	 * @param theList the list to print
	 */
	public static void printList(List<String> theList)
	{
		for(int i = 0; i < theList.size(); i++)
		{
			System.out.print(theList.get(i) + ", "); // print out each item of list
		}
		System.out.println("Size: " + theList.size());
	}
	
	/**
	 * A custom method to print out all the elements of a generic list in a single line and the index
	 * @param theList the list to print
	 */
	public static void printNonGenericList(List<Object> theList)
	{
		for(int i = 0; i < theList.size(); i++)
		{
			System.out.print(theList.get(i) + ", "); // print out each item of list
		}
		System.out.println("Size: " + theList.size());
	}
	
	/**
	 * A custom method to print out all the elements of an ArrayList in a single line and the index
	 * @param theList the list to print
	 */
	public static void printList(ArrayList<String> theList)
	{
		for(int i = 0; i < theList.size(); i++)
		{
			System.out.print(theList.get(i) + ", "); // print out each item of list
		}
		System.out.println("Size: " + theList.size());
	}
	
	/**
	 * Programming exercise 1 for 2.1
	 * Replaces each occurence of oldItem in aList with newItem
	 * @param aList The list to iterate through
	 * @param oldItem The item to replace
	 * @param newItem The item to replace the old item with
	 */
	public static void replace(ArrayList<String> aList, String oldItem, String newItem)
	{
		for(int i = 0; i < aList.size(); i++) // for each item in the list
		{
			if(aList.get(i).equals(oldItem)) // if the list at this index is the old item
				aList.set(i, newItem); // replace it by resetting the index
		}
	}
	
	/**
	 * Programming exercise 2 for 2.1
	 * Deletes the first occurrence of target in aList
	 * @param aList The list to search
	 * @param target The target to delete the first instance of.
	 */
	public static void delete(ArrayList<String> aList, String target)
	{
		int i = aList.indexOf(target); //get first index of the target (indexOf finds first instance of target)
		if(i >= 0) //if the target is in the list
			aList.remove(i); //remove it
		else
			System.out.println(target + " was not in the list."); // report to user that the target is not in the list.
	}
	
	/**
	 * A method to test the replace and delete methods of 2.1
	 */
	public static void programming()
	{
		ArrayList<String> hisList = new ArrayList<String>();
		hisList.add("Thing 1");
		hisList.add("Thing 2");
		hisList.add("Thing 3");
		hisList.add("Cat in the Hat");
		hisList.add("Thing 2");
		printList(hisList);
		System.out.println("Replacing Thing 2 with kittens...");
		replace(hisList, "Thing 2", "kittens"); // test the replace method
		printList(hisList);
		System.out.println("Deleting the Cat in the Hat...");
		delete(hisList, "Cat in the Hat"); // test the delete method, when the target is in the list
		printList(hisList);
		System.out.println("Deleting the fish in the bowl...");
		delete(hisList, "fish in the bowl"); // test the delete method, when the target is not in the list
		printList(hisList);
	}

}
