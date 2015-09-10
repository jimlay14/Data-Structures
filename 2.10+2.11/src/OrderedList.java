import java.util.*;

/**
 * A class to represent an ordered list. The data is stored in a linked list data field.
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E>
 */
public class OrderedList<E extends Comparable<E>> implements Iterable<E>
{
	//data fields
	
	private LinkedList<E> theList = new LinkedList<E>(); // a linked list to contain the data

	//methods
	
	/**
	 * Inserts obj into the list preserving the list's order.
	 * pre: The items in the list are ordered.
	 * Post: obj has been inserted into the list such that the items are still in order.
	 * @param obj
	 */
	public void add(E obj)
	{
		ListIterator<E> iter = theList.listIterator();
		//Find the insertion position and insert.
		while (iter.hasNext()) {
			if(obj.compareTo(iter.next()) < 0) {
				//Iterator has stepped over the first element
				//that is greater than the element to be inserted.
				//Move the iterator back one.
				iter.previous();
				//Insert the element
				iter.add(obj);
				//Exit the loop and return.
				return;
			}
		}
		//Assert: All items were examined and no item is larger than 
		//the element to be inserted. (obj is at the end of the list)
		//Add the new item to the end of the list.
		iter.add(obj);
	}
	
	/**
	 * Returns the element at the spacified position.
	 * @param index The specified position
	 * @return The element at position index
	 */
	public E get(int index)
	{
		return theList.get(index);
	}

	/**
	 * Returns an iterator to this OrderedList.
	 * @return The iterator, positioning it before the first element
	 */
	public Iterator<E> iterator() 
	{
		return theList.iterator();
	}
	
	/**
	 * Returns the size of the list
	 * @return The size of the list using theList.size()
	 */
	public int size()
	{
		return theList.size();
	}
	
	/**
	 * Removes the first occurrence of obj from the list.
	 * @param obj The object to be removed
	 * @return The object removed
	 */
	public E remove(E obj)
	{
		ListIterator<E> iter = theList.listIterator();
		//Find the position and remove.
		//Temporary E toReturn
		E toReturn = null;
		while (iter.hasNext()) {
			//move iterator to next item for comparison
			toReturn = iter.next();
			if (obj.compareTo(toReturn) == 0) {
				//Iterator has stepped over the first element
				//that is equal to the element to be removed
					iter.remove();
					return toReturn;
				} else { 
					//otherwise the target is not in the list
					return null;
				}
			
		}
		//Assert: all items were examined and no item is equal to 
		//the element to be removed.
		//Check the last item in the list.
		if (obj.compareTo(toReturn) == 0) {
				iter.remove();
				return toReturn;
			}
		//otherwise the target is not in the list
		return null;
	}
	
	/**
	 * Inserts obj into the list preserving the list's order.
	 * Traverses the list backwards
	 * pre: The items in the list are ordered.
	 * Post: obj has been inserted into the list such that the items are still in order.
	 * @param obj
	 */
	public void reverseAdd(E obj)
	{
		ListIterator<E> iter = theList.listIterator(theList.size());
		//Find the insertion position and insert.
		while (iter.hasPrevious()) {
			if(obj.compareTo(iter.previous()) > 0) {
				//Iterator has stepped over the first element
				//that is less than the element to be inserted.
				//Move the iterator back one.
				iter.next();
				//Insert the element
				iter.add(obj);
				//Exit the loop and return.
				return;
			}
		}
		//Assert: All items were examined and no item is larger than 
		//the element to be inserted. (obj is at the front of the list)
		//Add the new item to the front of the list.
		iter.add(obj);
	}

}
