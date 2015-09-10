import java.util.EmptyStackException;

/**
 * Class to implement interface StackInt<E> as a linked list
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E> The data type to be stored
 */
public class LinkedStack<E> implements StackInt<E>
{
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
	
	//Data fields
	
	private Node<E> topOfStackRef = null; //reference to the first stack node

	/**
	 * Insert a new item on top of the stack.
	 * post: The new item is the top item on the stack.
	 * 		 All other items are one position lower.
	 * @param obj The item to be inserted
	 * @return the data that was inserted
	 */
	@Override
	public E push(E obj) 
	{
		topOfStackRef = new Node<E>(obj, topOfStackRef);
		return obj;
	}

	/**
	 * Return the top item on the stack.
	 * pre: The stack is not empty.
	 * post: The stack remains unchanged.
	 * @return The top item on the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E peek() 
	{
		if(empty())
			throw new EmptyStackException();
		return topOfStackRef.data;
	}

	/**
	 * Remove and return the top item on the stack
	 * pre: The stack is not empty.
	 * post: The top item on the stack has been 
	 * 		 removed and the stack is one item smaller.
	 * @return The top item on the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E pop() 
	{
		if(empty()) {
			throw new EmptyStackException();
		}
		E result = topOfStackRef.data;
		topOfStackRef = topOfStackRef.next;
		return result;
	}

	/**
	 * See whether the stack is empty.
	 * @return true if the stack is empty
	 */
	@Override
	public boolean empty() 
	{
		return topOfStackRef == null;
	}
	
	/**
	 * Return the number of elements in the linked stack
	 * @return The number of elements
	 */
	public int size()
	{
		Node<E> temp = topOfStackRef;
		int toReturn = 0;
		if(temp == null)
			return 0;
		while(temp.next != null)
			toReturn++;
		return toReturn;
	}

}
