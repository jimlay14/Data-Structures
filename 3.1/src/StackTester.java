import java.util.*;

public class StackTester 
{
	public static void main(String[] args)
	{
		Stack<Integer> stackOne = new Stack<Integer>();
		Stack<Integer> stackTwo = new Stack<Integer>();
		Stack<Integer> stackThree = new Stack<Integer>();
		
		stackOne.push(-1);
		stackOne.push(15);
		stackOne.push(23);
		stackOne.push(44);
		stackOne.push(4);
		stackOne.push(99);
		
		stackTwo.push(15);
		stackTwo.push(1);
		stackTwo.push(4);
		stackTwo.push(44);
		stackTwo.push(23);
		stackTwo.push(99);
		
		int size = stackOne.size();
		for(int i = 0; i < size; i++)
		{
			stackThree.push(stackOne.pop());
		}
		
		for(int i = 0; i < size; i++)
		{
			System.out.println("Stack two: " + stackTwo.pop());
			System.out.println("Stack three: " + stackThree.pop());
		}

	}
}
