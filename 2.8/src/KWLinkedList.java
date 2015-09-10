import java.util.*;

/**
 * A class that implements a double-linked list and a ListIterator
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class KWLinkedList<E> 
{
	//data fields
	private Node<E> head = null; //reference to the head of the list
	private Node<E> tail = null; //reference to the tail of the list
	private int size = 0; // size of the list
	
	//methods
	
	/**
	 * Return a ListIterator at the given position
	 * @param i The index to start the listIterator at
	 * @return A list iterator at the specified index
	 */
	public KWListIter listIterator(int i)
	{
		return new KWListIter(i);
	}
	
	/**
	 * Return a ListIterator at the head of the list
	 * @return A list iterator at the head of the list
	 */
	public KWListIter listIterator()
	{
		return listIterator(0);
	}
	
	/**
	 * Add an item at position index
	 * @param index The position at which the item is to be inserted
	 * @param obj The object to be inserted
	 * @throws IndexOutOfBoundsException if the index is out of range(i < 0 || i >size())
	 */
	public void add(int index, E obj)
	{
		listIterator(index).add(obj);
	}
	
	/**
	 * Inserts obj as the first element of the list
	 * @param obj The object to be inserted
	 */
	public void addFirst(E obj)
	{
		listIterator().add(obj);
	}
	
	/**
	 * Inserts obj as the last element of the list
	 * @param obj The object to be inserted
	 */
	public void addLast(E obj)
	{
		listIterator(size).add(obj);
	}
		
	/**
	 * Returns the object at the specified index
	 * @param index  The index at which we will return the item
	 * @return The object at the specified index
	 */
	public E get(int index)
	{
		return listIterator(index).next();
	}
	
	/**
	 * Returns the object at the end of the list
	 * @return The object at the end of the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getLast()
	{
		return get(size-1);
	}
	
	/**
	 * Returns the object at the beginning of the list
	 * @return The object at the beginning of the list
	 * @throws NoSuchElementException if the list is empty
	 */
	public E getFirst()
	{
		return get(0);
	}
	
	/**
	 * Return the size of the list
	 * @return The size of the list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Inner class to implement the ListIterator interface
	 * @author Jacob/ Koffman & Wolfgang
	 *
	 */
	private class KWListIter implements ListIterator<E>
	{
		//data fields
		private Node<E> nextItem; //reference to next item
		private Node<E> lastItemReturned; //reference to last item returned
		private int index = 0;
		
		//constructor
		/**
		 * Construct a KWListIter that will reference the ith item
		 * @param i The index of the item to be referenced
		 */
		public KWListIter(int i)
		{
			//Validate i parameter
			if(i < 0 || i > size){
				throw new IndexOutOfBoundsException(
						"Ivalid index " + i);
			}
			lastItemReturned = null; //no item returned yet
			//special case of last item
			if(i == size)
			{
				index = size;
				nextItem = null;
			} else { //start at the beginning
				nextItem = head;
				for(index = 0; index < i; index++)
					nextItem = nextItem.next;
			}
		}
		
		/**
		 * Indicate whether movement forward is defined
		 * @return true if call to next will not throw an exception
		 */
		@Override
		public boolean hasNext()
		{
			return nextItem != null;
		}
		
		/**
		 * Move the iterator forward and return the next item
		 * @return The next item in the list
		 * @throws NoSuchElementException if there is no such object
		 */
		@Override
		public E next()
		{
			if(!hasNext()) //if there is no element to return, throw an exception
				throw new NoSuchElementException();
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			index++;
			return lastItemReturned.data;
		}
		
		/**
		 * Indicate whether movement backward is defined
		 * @return true if call to previous will not throw an exception
		 */
		@Override
		public boolean hasPrevious()
		{
			return(nextItem == null && size != 0 
					|| nextItem.prev != null);
		}
		
		/**
		 * Move the iterator backward and return the previous item
		 * @return The previous item in the list
		 * @throws NoSuchElementException if there is no such object
		 */
		@Override
		public E previous()
		{
			if(!hasPrevious()) //check if there is an element to return
				throw new NoSuchElementException();
			if(nextItem == null){ //iterator is past the last element
				nextItem = tail;
			} else { //point to previous
				nextItem = nextItem.prev;
			}
			lastItemReturned = nextItem;
			index--;
			return lastItemReturned.data;
		}
		
		/**
		 * Add a new item between the item that will be returned
		 * by next and the item that will be returned by previous.
		 * If previous is called after add, the element added is returned
		 * @param obj The item to be inserted
		 */
		@Override
		public void add(E obj)
		{
			if(head == null) //Add to an empty list
			{
				head = new Node<E>(obj);
				tail = head;
			} else if (nextItem == head) { //insert at head
				Node<E> newNode = new Node<E>(obj); //create a new node
				newNode.next = nextItem; //link it to the nextItem
				nextItem.prev = newNode; //link nextItem to the new node
				head = newNode; //new node is now the head
			} else if (nextItem == null) { //insert at tail
				Node<E> newNode = new Node<E>(obj); //create a new node
				tail.next = newNode; //link the tail to the new node
				newNode.prev = tail; //link the new node to the tail
				tail = newNode; //new node is now the tail
			} else { //insert into the middle
				Node<E> newNode = new Node<E>(obj); //create a new node
				//link it to nextItem.prev
				newNode.prev = nextItem.prev;
				nextItem.prev.next = newNode;
				//link it to the nextItem
				newNode.next = nextItem;
				nextItem.prev = newNode;
			}
			//increase size and index and set lastItemReturned
			size++;
			index++;
			lastItemReturned = null;
		}

		@Override
		public int nextIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int previousIndex() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public void remove() 
		{
			if(lastItemReturned == null) { //invalid expression; must have an item to remove
				throw new IllegalStateException();
			}
			if(lastItemReturned == nextItem) //if the last call made was a previous call
			{
				if (lastItemReturned == head) { //remove at head
					nextItem = head.next; //move iterator to second item
					nextItem.prev = null; //pull head out
					head = nextItem; //move head pointer
				} else if (lastItemReturned == tail) { //removing tail
					nextItem = tail.prev; //move pointer to item before tail
					nextItem.next = null; //erase pointer to tail
					tail = nextItem; //move tail pointer
					index--; //move index
				} else { //removing from middle
				//link items around element
					nextItem.prev.next = nextItem.next;
					nextItem.next.prev = nextItem.prev;
					nextItem = nextItem.next; //move pointer
				}
			} else { //if the last call made was a next call
				if (lastItemReturned == head) { //remove at head
					nextItem.prev = null; //pull head out
					head = nextItem; //move head pointer
					index--; //decrease index
				} else if (lastItemReturned == tail) { //removing tail
					lastItemReturned.prev.next = null;//item before tail points to null
					nextItem = lastItemReturned.prev;//next item is the new tail
					tail = nextItem; //update tail
					index--; //decrease index
				} else { //remove from middle
					lastItemReturned.prev.next = nextItem;
					nextItem.prev = lastItemReturned.prev;
					index--; //decrease index
				}
			}
			size--; //Decrease size, regardless of where the element is removed from
			lastItemReturned = null;			
		}

		@Override
		public void set(E arg0) {
			// TODO Auto-generated method stub
			
		}
	}

	/**
	 * A Node that is the building block for a single-linked list
	 * @author Jacob/ Koffman & Wolfgang
	 *
	 * @param <E> The data the node references
	 */
	private static class Node<E>
	{
		//data fields
		private E data; // reference to the data
		private Node<E> next; // reference to the next node
		private Node<E> prev; //reference to previous node
		
		//Constructors
		
		/**
		 * Create a new node with a null next field.
		 * @param dataItem The data stored
		 */
		private Node(E dataItem)
		{
			data = dataItem;
			next = null;
		}
		
		/**
		 * Create a new node that references another node
		 * @param dataItem The data stored
		 * @param nodeRef The node referenced by new node
		 */
		private Node(E dataItem, Node<E> nodeRef)
		{
			data = dataItem;
			next = nodeRef;
		}
	}
}
