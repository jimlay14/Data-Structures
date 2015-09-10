import java.util.EmptyStackException;
import java.util.Arrays;

/**
 * Implementation of the interface StackInt<E> using an array
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E> The data type to be stored
 */
public class ArrayStack<E> implements StackInt<E>
{
	//Data fields
	
	/** Storage for stack */
	private E[] theData;
	
	/** Index to top of stack */
	int topOfStack = -1; // Initially empty stack
	
	private static final int INITIAL_CAPACITY = 10; //initial capacity
	private int capacity = INITIAL_CAPACITY; //ability to change capacity
	
	//Methods
	
	/**
	 * Construct an empty stack with the default initial capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayStack()
	{
		theData = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	/**
	 * Insert a new item on top of the stack.
	 * post: The new item is the top item on the stack.
	 * 		 All other items are one position lower.
	 * @param obj The item to be inserted
	 * @return The item that was inserted
	 */
	@Override
	public E push(E obj) 
	{
		if(topOfStack == theData.length - 1)
		{
			reallocate();
		}
		topOfStack++;
		theData[topOfStack] = obj;
		return obj;
	}

	/**
	 * Peek at the top object of the stack.
	 * @return The top object on the stack
	 * @throws EmptyStackException if the stack is empty
	 */
	@Override
	public E peek() 
	{
		if(empty())
			throw new EmptyStackException();
		return theData[topOfStack];
	}

	/**
	 * Remove and return the top item on the stack
	 * pre: The stack is not empty
	 * post: The top item on the stack has been 
	 * 		 removed and the stack is one item smaller.
	 * @return The top item on the stack
	 */
	@Override
	public E pop() 
	{
		if(empty())
			throw new EmptyStackException();
		return theData[topOfStack--];
	}

	/**
	 * See whether the stack is empty
	 * @return true if the stack is empty
	 */
	@Override
	public boolean empty() 
	{
		return topOfStack == -1;
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

}
