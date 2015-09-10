import java.util.*;

/**
 * Class ListStack implements the interface StackInt<E> as
 * an adapter to the List. This implementation is functionally
 * equivalent to that given in java.util.Stack<E> except that the
 * underlying List<E> is not publicly exposed
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E> The data type to be stored
 */
public class ListStack<E> implements StackInt<E>
{
	//Data fields
	
	/** The list containing the data */
	private List<E> theData;
	
	//Methods
	
	/**
	 * Construct an empty stack using an ArrayList as the container
	 */
	public ListStack()
	{
		theData = new ArrayList<E>();
	}

	/**
	 * Push an item onto the stack
	 * post: The object is at the top of the stack.
	 * @param obj The object to be pushed
	 * @return the object pushed
	 */
	@Override
	public E push(E obj)
	{
		theData.add(obj);
		return obj;
	}

	/**
	 * Peek at the top object of the stack.
	 * @return The top object of the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E peek() 
	{
		if (empty())
			throw new EmptyStackException();
		return theData.get(theData.size() - 1);
	}

	/**
	 * Pop the top object off the stack.
	 * post: The object at the top of the stack is removed.
	 * @return the top object, which is removed
	 * @throws EmptyStackException if the stack is empty 
	 */
	@Override
	public E pop() 
	{
		if(empty())
			throw new EmptyStackException();
		return theData.remove(theData.size()-1);
	}

	/**
	 * See whether the stack is empty.
	 * @return true if the stack is empty
	 */
	@Override
	public boolean empty() 
	{
		return theData.size() == 0;
	}

}
