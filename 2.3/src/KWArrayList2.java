import java.util.*;

/**
 * A non-generic implementation of the ArrayList, as used in earlier versions of Java
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class KWArrayList2 
{
	//data fields
	private static final int INITIAL_CAPACITY = 10; // default initial capacity
	
	private Object[] theData; // underlying data array
	private int size = 0; // current size
	private int capacity = 0; // the current capacity
	
	//methods
	/**
	 * Constructor of the ArrayList
	 */
	public KWArrayList2()
	{
		capacity = INITIAL_CAPACITY; //start size at 10
		theData = new Object[capacity]; //
	}
	
	/**
	 * A method to add an entry to the end of the list
	 * @param anEntry The entry to add
	 * @return Statement on whether the addition was successful; always true
	 */
	public boolean add(Object anEntry)
	{
		if(size == capacity) // if the array is full
			reallocate(); // double the size of the array
		
		theData[size] = anEntry; //add the element at the end of the list
		size++; //adjust the size
		return true; // successful adding
	}
	
	/**
	 * A method to add an entry at a given index
	 * @param index The desired index of the item
	 * @param anEntry The item to add
	 */
	public void add(int index, Object anEntry)
	{
		if(index < 0 || index > size) // if we have an invalid index (index at size is good; note that here)
			throw new ArrayIndexOutOfBoundsException(index); // throw an error report to the user
		
		if(size == capacity) // if the array is full
			reallocate(); //double the size of the array
		
		for(int i = size; i > index; i--) // for each item after the given index
			theData[i] = theData[i - 1]; //shift the item
		
		theData[index] = anEntry; //place the new item
		size++; // adjust size
	}
	
	/**
	 * A method to get an item from a given index
	 * @param index The index to get the item from
	 * @return The item at the given index
	 */
	public Object get(int index)
	{
		if(index < 0 || index >= size) // if the index is invalid (less than zero or out of bounds)
			throw new ArrayIndexOutOfBoundsException(index); //throw an exception to the user
		
		return theData[index]; //get the item at the given index
	}
	
	/**
	 * A method to insert a new item at a given index, and return the old value
	 * @param index The index to add the new item at
	 * @param newValue The new item to add
	 * @return The old value at the given index
	 */
	public Object set(int index, Object newValue)
	{
		if(index < 0 || index >= size) //if we have an invalid index
			throw new ArrayIndexOutOfBoundsException(index); // throw an exception to the user
		
		Object oldValue = theData[index]; //get the old data
		theData[index] = newValue; //set the new data to the old index
		return oldValue; // return the previous data
	}
	
	/**
	 * A method to remove an item; shifting the items that follow forward
	 * @param index The index to remove
	 * @return The item removed
	 */
	public Object remove(int index)
	{
		if(index < 0 || index >= size) //if there is an invalid index
			throw new ArrayIndexOutOfBoundsException(index); // throw an exception
		
		Object returnValue = theData[index]; //get the item to remove
		
		for(int i = index + 1; i < size; i++) // for each item after the index
			theData[i - 1] = theData[i]; // shift the item forward
		
		size--; //decrease the size
		return returnValue; // return the removed item
	}
	
	/**
	 * Create a new array twice the size of the current array
	 */
	public void reallocate()
	{
		capacity = 2 * capacity; // double the capacity
		theData = Arrays.copyOf(theData, capacity); // copy over elements; fills extra space with null
	}
}
