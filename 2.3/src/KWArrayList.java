import java.util.*;

/**
 * A class that implements some of the methods of the Java (generic) ArrayList class
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class KWArrayList<E> 
{
	//data fields
	private static final int INITIAL_CAPACITY = 10; // default initial capacity
	
	private E[] theData; // underlying data array
	private int size = 0; // current size
	private int capacity = 0; // the current capacity
	
	//methods
	/**
	 * Constructor of the ArrayList<E>
	 */
	@SuppressWarnings("unchecked") // suppress the unchecked warning resulting from E being unknown
	public KWArrayList()
	{
		capacity = INITIAL_CAPACITY; //start size at 10
		theData = (E[]) new Object[capacity]; //correct way to create an array of E objects
		//theData = new E[capacity] would be incorrect due to unspecified array type
	}
	
	/**
	 * A method to construct a KWArrayList with a given initial capacity
	 * @param initCapacity
	 */
	@SuppressWarnings("unchecked")
	public KWArrayList(int initCapacity)
	{
		if(initCapacity <= 0) // if the starting capacity is less than or equal to 0, throw an exception
			throw new IllegalArgumentException("Not a valid starting capacity"); //if 0, the capacity cannot increase with reallocation
		capacity = initCapacity; //start size at given amount
		theData = (E[]) new Object[capacity];
	}
	
	/**
	 * A method to add an entry to the end of the list
	 * O(n) = O(1) no shifting of items
	 * @param anEntry The entry to add
	 * @return Statement on whether the addition was successful; always true
	 */
	public boolean add(E anEntry)
	{
		if(size == capacity) // if the array is full
			reallocate(); // double the size of the array
		
		theData[size] = anEntry; //add the element at the end of the list
		size++; //adjust the size
		return true; // successful adding
	}
	
	/**
	 * A method to add an entry at a given index
	 * 
	 * O(n) = O(n) (shifting of items)
	 * @param index The desired index of the item
	 * @param anEntry The item to add
	 */
	public void add(int index, E anEntry)
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
	 * 
	 * O(n) = O(1) (contains no loops; few code)
	 * @param index The index to get the item from
	 * @return The item at the given index
	 */
	public E get(int index)
	{
		if(index < 0 || index >= size) // if the index is invalid (less than zero or out of bounds)
			throw new ArrayIndexOutOfBoundsException(index); //throw an exception to the user
		
		return theData[index]; //get the item at the given index
	}
	
	/**
	 * A method to insert a new item at a given index, and return the old value
	 * 
	 * O(n) = O(1) (no loops and few lines)
	 * @param index The index to add the new item at
	 * @param newValue The new item to add
	 * @return The old value at the given index
	 */
	public E set(int index, E newValue)
	{
		if(index < 0 || index >= size) //if we have an invalid index
			throw new ArrayIndexOutOfBoundsException(index); // throw an exception to the user
		
		E oldValue = theData[index]; //get the old data
		theData[index] = newValue; //set the new data to the old index
		return oldValue; // return the previous data
	}
	
	/**
	 * A method to remove an item; shifting the items that follow forward
	 * 
	 * O(n) = O(n) (shifting items)
	 * @param index The index to remove
	 * @return The item removed
	 */
	public E remove(int index)
	{
		if(index < 0 || index >= size) //if there is an invalid index
			throw new ArrayIndexOutOfBoundsException(index); // throw an exception
		
		E returnValue = theData[index]; //get the item to remove
		
		for(int i = index + 1; i < size; i++) // for each item after the index
			theData[i - 1] = theData[i]; // shift the item forward
		
		size--; //decrease the size
		return returnValue; // return the removed item
	}
	
	/**
	 * Create a new array twice the size of the current array
	 * 
	 * O(n) = O(1) (two operations that are done in constant time)
	 */
	public void reallocate()
	{
		capacity = 2 * capacity; // double the capacity
		theData = Arrays.copyOf(theData, capacity); // copy over elements; fills extra space with null
	}
	
	/**
	 * A method to find the first index of a target
	 * 
	 * O(n) = O(n) (loop through each item)
	 * @param target The target to look for
	 * @return The index of the target; -1 if the target is not in the list
	 */
	public int indexOf(E target)
	{
		for(int i = 0; i < size; i++)
		{
			if(target.equals(theData[i]))
				return i; //return the index of the first occurence
		}
		return -1; // we did not find the target
	}
	
	/**
	 * A method to get the size of the KWArrayList
	 * O(n) = O(1) (just returning a variable)
	 * @return The size of the list
	 */
	public int size()
	{
		return size;
	}
	
	/**
	 * Move middle object of the array list to the end
	 * O(n) = O(n) (remove is an O(n) operation; other than that there are only two lines of code)
	 */
	public void moveMiddleToEnd()
	{
		int index = size / 2; //find middle index
		E toMove = remove(index); //remove from the middle and get the variable
		add(toMove); //add the variable at the end
	}
}
