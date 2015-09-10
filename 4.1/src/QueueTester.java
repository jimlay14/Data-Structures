import java.util.*;

public class QueueTester 
{
	public static void main(String[] args)
	{
		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		stackOne.push(-1);
		stackOne.push(15);
		stackOne.push(23);
		stackOne.push(44);
		stackOne.push(4);
		stackOne.push(99);
		
		while(!stackOne.empty())
		{
			Integer toMove = stackOne.pop();
			stackTwo.push(toMove);
			queue.offer(toMove);
		}
		
		while(!stackTwo.empty() && !queue.isEmpty())
		{
			System.out.println("Stack prints: " + stackTwo.pop()
					+ "; Queue prints: " + queue.poll());
		}
	}
}
