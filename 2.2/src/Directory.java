import java.util.ArrayList;

/**
 * A class representing a phone directory; arraylist utilizing the Directoryentry class
 * @author Jacob
 *
 */
public class Directory 
{
	//data fields
	ArrayList<DirectoryEntry> theDirectory;
	
	//methods
	
	/**
	 * Constructor of a Directory
	 */
	public Directory()
	{
		theDirectory = new ArrayList<DirectoryEntry>();
	}
	
	/**
	 * A method to test the phone directory application
	 */
	public void phoneDirectory()
	{
		theDirectory.add(new DirectoryEntry("Jane Smith", "555-549-1234"));
		theDirectory.add(new DirectoryEntry("John Doe", "555-469-1893")); // adding entries
		printDirectory(theDirectory);
		int index = directorySearch(theDirectory, "Jane Smith"); // finding Jane Smith's number
		System.out.println("Our target is at " + index);
		DirectoryEntry jane = getDirectoryEntry(theDirectory, index);
		System.out.println(jane); //show that we found jane; all of the pieces work
		System.out.println("Adding Jack...");
		addOrChangeEntry("Jack", "867-5309");
		printDirectory(theDirectory);
		System.out.println("Changing John...");
		addOrChangeEntry("John Doe", "555-469-7777");
		printDirectory(theDirectory);
		System.out.println("Removing Jane...");
		removeEntry("Jane Smith");
		printDirectory(theDirectory);
	}
	
	/**
	 * A method to search a directory for the index of a name
	 * @param theDirectory The directory to search
	 * @param aName The name to look for
	 * @return The index of the name; -1 if the person is not in the list
	 */
	public int directorySearch(ArrayList<DirectoryEntry> theDirectory, String aName)
	{
		int index = theDirectory.indexOf(new DirectoryEntry(aName, "")); // search for the name
		return index; // get the proper index
	}
	
	/**
	 * A method to find the directory entry of a person if we know the index
	 * @param theDirectory The directory to search
	 * @param index The index of the person we are looking for (can throw an error if not called properly
	 * @return The directory entry of the person we are looking for; null if not in the list
	 */
	public DirectoryEntry getDirectoryEntry(ArrayList<DirectoryEntry> theDirectory, int index)
	{
		if(index != -1)
			return theDirectory.get(index); // get the directory entry, if the person is at the index
		return null; // otherwise the person is not in the list
	}
	
	/**
	 * A method to get a directory entry
	 * @param theDirectory The directory to search
	 * @param aName The name of the person we are looking for
	 * @return The proper directory entry; null if the person is not in the directory
	 */
	public DirectoryEntry getDirectoryEntry(ArrayList<DirectoryEntry> theDirectory, String aName)
	{
		int i = directorySearch(theDirectory, aName); // search for the index
		return getDirectoryEntry(theDirectory, i); //get the entry at the index
	}
	
	/**
	 * Add an entry to theDirectory or change an existing entry
	 * @param aName The name of the person being added or changed
	 * @param newNumber The new number to be assigned
	 * @return The old number, or if a new entry, null
	 */
	public String addOrChangeEntry(String aName, String newNumber)
	{
		int index = directorySearch(theDirectory, aName);//search for the proper index
		if(index != -1) //if in the list
		{
			String toReturn = theDirectory.get(index).getNumber(); //get the number so we know what to return
			theDirectory.set(index, new DirectoryEntry(aName, newNumber)); //replace the number
			return toReturn; //return the old number
		}
		else
			theDirectory.add(new DirectoryEntry(aName, newNumber)); //otherwise add the new entry
		return null; // and return null
	}
	
	/**
	 * Remove an entry
	 * @param aName The name of the person being removed
	 * @return The entry removed, or null if there is no entry for a name
	 */
	public DirectoryEntry removeEntry(String aName)
	{
		int index = directorySearch(theDirectory, aName);
		if(index != -1)
		{
			DirectoryEntry entry = theDirectory.get(index);
			theDirectory.remove(index);
			return entry;
		}
		return null;
	}
	
	/**
	 * A custom method to print out all the elements of an integer ArrayList in a single line and the index
	 * @param theList the list to print
	 */
	public void printDirectory(ArrayList<DirectoryEntry> theList)
	{
		for(int i = 0; i < theList.size(); i++)
		{
			System.out.print(theList.get(i) + ", "); // print out each item of list
		}
		System.out.println("Size: " + theList.size());
	}

}
