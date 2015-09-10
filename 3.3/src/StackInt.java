/**
 * A stack is a data structure in which objects are inserted into 
 * and removed from the same end (Last-In, First-Out or LIFO)
 * @author Jacob/ Koffman & Wolfgang
 *
 * @param <E>
 */
public interface StackInt<E> 
{
	/**
	 * Pushes an item onto the stack and returns the item pushed.
	 * @param obj The object to be inserted
	 * @return The object inserted
	 */
	E push(E obj);
	
	/**
	 * Returns the object at the top of the stack without removing it.
	 * post: The stack remains unchanged
	 * @return The object at the top of the stack
	 * @throws EmptyStackException if stack is empty
	 */
	E peek();
	
	/**
	 * Returns item at the top of the stack and removes it.
	 * post: the stack is one item smaller.
	 * @return The object at the top of the stack
	 * @throws EmptyStackException if stack is empty
	 */
	E pop();
	
	/**
	 * Returns true if the stack is empty; otherwise, returns false.
	 * @return true if the stack is empty
	 */
	boolean empty();

}
