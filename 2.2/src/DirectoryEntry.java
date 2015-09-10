
/**
 * A class representing the phone directory application from 2.2
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class DirectoryEntry 
{
	//data fields
	String name;
	String number;
	
	//methods

	/**
	 * Constructor for a new directory entry with name and number specified
	 * @param name The name of the entry
	 * @param number The number of the entry
	 */
	public DirectoryEntry(String name, String number)
	{
		this.name = name;
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	/**
	 * Return a string representation of a DirectoryEntry
	 */
	@Override
	public String toString()
	{
		return "Name: " + name + "; Number: " + number;
	}
	
	/**
	 * Equals method for the Directory Entry
	 */
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() == obj.getClass())
		{
			DirectoryEntry other = (DirectoryEntry) obj; //downcast to DirectoryEntry
			return name.equals(other.name); //return if name is the same
		}
		return false;
	}
}
