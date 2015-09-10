/**
 * Class to represent a linked list with a link from each node to the next node
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E> The data with which the linked list references
 */
public class SingleLinkedList<E> 
{
	//data fields
	private Node<E> head = null; //reference to list head
	private int size; //number of items in the list
	
	/**
	 * Add an item to the front of the list.
	 * O(n) = O(1) Only two operations are performed, not dependent upon size
	 * @param item The item to be added
	 */
	public void addFirst(E item)
	{
		head = new Node<E>(item, head); //make the last head the second item
		size++; //increase size
	}
	
	/**
	 * Get the value at the index
	 * O(n) = O(n) only runs as far as index, but must iterate
	 * @param index The position of the element to return
	 * @return The data at index
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E get(int index)
	{
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index)); //if out of bounds, throw an exception
		}
		Node<E> node =  getNode(index);
		return node.data; //otherwise return the data
	}
	
	/**
	 * Sets the data value at index
	 * O(n) = O(n) no shifting elements, but must iterate to the item
	 * @param index The position of the item to change
	 * @param newValue The new value
	 * @return The data value previousl at index
	 * @throws IndexOutOfBoundsExeception if index is out of range
	 */
	public E set(int index, E newValue)
	{
		if(index < 0 || index >= size){
			throw new IndexOutOfBoundsException(Integer.toString(index)); //if out of bounds, throw an exception
		}
		Node<E> node = getNode(index); //get the node at the index
		E result = node.data; //get the data to return
		node.data = newValue; //replace value
		return result; //return removed data
	}
	
	/**
	 * Insert the specified item at index
	 * O(n) = O(n) no shifting elements; adding is a constant time operation, but must still iterate to find index
	 * @param index The position where the item is to be inserted
	 * @param item The item to be inserted
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public void add(int index, E item)
	{
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index)); //if out of bounds, throw an exception
		}
		if(index == 0){
			addFirst(item);//if the index is the head, add the element as the head
		}
		else{ //otherwise add the new data at the given index
			Node<E> node = getNode(index-1);
			addAfter(node, item);
		}
	}
	
	/**
	 * Append item to the end of the list
	 * O(n) = O(n) no shifting of elements (faster than arrayList) but must iterate
	 * @param item The item to be appended
	 * @return true (as specified by Collections interface
	 */
	public boolean add(E item)
	{
		add(size, item);
		return true;
	}
	
	/**
	 * Remove the item at index
	 * O(n) = O(n) no shifting elements; removing is a constant time operation, yet there is still iteration
	 * @param index The position where the item is to be inserted
	 * @return The data removed
	 * @throws IndexOutOfBoundsException if index is out of range
	 */
	public E remove(int index)
	{
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException(Integer.toString(index)); //if out of bounds, throw an exception
		}
		if(index == 0){
			return removeFirst();//if the index is the head, add the element as the head
		}
		else{ //otherwise add the new data at the given index
			Node<E> node = getNode(index-1);
			return removeAfter(node);
		}
	}
	
	/**
	 * Method to return the index of a given item
	 * O(n) = O(n) iterate to find item
	 * @param target The data to look for
	 * @return The index of the node reference to the data
	 */
	public int indexOf(E target)
	{
		Node<E> nodeRef = head;
		int i = 0;
		while(nodeRef != null && nodeRef.data != target)
		{
			nodeRef = nodeRef.next;
			i++;
		}
		if(nodeRef != null)
			return i;
		return -1; // we did not find the target
	}
	
	/**
	 * Remove the first occurrence of element item
	 * O(n) = O(n) must iterate through list to find item, but there is no need to shift elements forward
	 * @param item The item to be removed
	 * @return true if item is found and remove, otherwise, return false
	 */
	public boolean remove(E item)
	{
		int toRemove = indexOf(item);
		if(toRemove == -1)
			return false;
		else
			remove(toRemove);
		return true;
	}
	
	/**
	 * Insert a new item before the one at position index,
	 * Starting at 0 for the list head. The new item is inserted between
	 * the one at position index -1 and the one formerly at the position index
	 * O(n) = O(n) must iterate through list
	 * @param index the index where the new item is to be inserted
	 * @param item The item to be inserted
	 */
	public void addNoHelper(int index, E item)
	{
		if(index < 0 || index > size+1)
			throw new IndexOutOfBoundsException(Integer.toString(index));
		if(index == 0)
		{
			head = new Node<E>(item, head); //make the last head the second item
			size++; //increase size
		}
		else{
			Node<E> node = getNode(index-1);
			node.next = new Node<E>(item, node.next);
			size++;
		}
	}
	
	/**
	 * Add a node after a given node
	 * @param node The node preceding the new item
	 * @param item The item to insert
	 */
	private void addAfter(Node<E> node, E item)
	{
		node.next = new Node<E>(item, node.next);
		size++;
	}
	
	/**
	 * Remove the node after a given node
	 * @param node The node before the one to be removed
	 * @return The data from the removed node, or null if there is no node to remove
	 */
	private E removeAfter(Node<E> node)
	{
		Node<E> temp = node.next; //temporary reference to the node we will remove
		if(temp != null) //if there is a node to remove
		{
			node.next = temp.next; //remove it
			size--; //decrease size
			return temp.data; //return the removed data
		}	
		return null; //otherwise return null
	}
	
	/**
	 * Remove the first node from the list
	 * @return The removed node's data or null if the list is empty
	 */
	private E removeFirst()
	{
		Node<E> temp = head;
		if(head != null) //if there is a head
		{
			head = head.next; //remove the head and reference next item
			size--;//decrease the size
			return temp.data; //return the former head's data
		}
		return null; //return null if there is no head
	}
	
	/**
	 * Find the node at a specified position
	 * @param index The position of the node sought
	 * @return The node at index or null if it does not exist
	 */
	private Node<E> getNode(int index)
	{
		Node<E> node = head;
		for(int i = 0; i < index && node != null; i++)
		{
			node = node.next;
		}
		return node;
	}
	
	public int getSize() {
		return size;
	}

	/**
	 * Return a string representation of the linked list
	 * O(n) = O(n) The order is dependent upon the size of the list
	 */
	@Override
	public String toString()
	{
		Node<E> nodeRef = head;
		StringBuilder result = new StringBuilder(); //begin building a string
		while(nodeRef != null) //while there are still nodes to reference
		{
			result.append(nodeRef.data); //add the data
			if(nodeRef.next != null)
			{
				result.append(" ==> "); //arrow to next item
			}
			nodeRef = nodeRef.next; //advance down the list
		}
		return result.toString();
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
