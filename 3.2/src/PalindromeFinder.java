import java.util.*;

/**
 * Class with methods to check whether a string is a palindrome
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class PalindromeFinder 
{
	/**
	 * String to store in stack
	 */
	private String inputString;
	
	/**
	 * Stack to hold characters
	 */
	private Stack<Character> charStack = new Stack<Character>();
	
	/**
	 * Store the argument String in a stack of characters
	 * @param str String of characters to store in the stack
	 */
	public PalindromeFinder(String str)
	{
		inputString = str;
		fillStack();
	}
	
	/**
	 * Method to fill a stack of characters from an input string
	 */
	private void fillStack()
	{
		for(int i = 0; i < inputString.length(); i++)
		{
			charStack.push(inputString.charAt(i));
		}
	}
	
	/**
	 * Method to build a string containing the charcaters in a stack
	 * post: The stack is empty
	 * @return The string containing the words in the stack
	 */
	private String buildReverse()
	{
		StringBuilder result = new StringBuilder();
		while(!charStack.empty())
		{
			//remove top item from stack and append it to the result.
			result.append(charStack.pop());
		}
		return result.toString();
	}
	
	/**
	 * Returns whether the string is a palindrome
	 * @return True if the string is a palindrome, if not then false
	 */
	public boolean isPalindrome()
	{
		return inputString.equalsIgnoreCase(buildReverse());
	}
	
	/**
	 * Programming exercise 2 from 3.2
	 * uses a loop to compare characters 
	 * at the front and back of the string
	 * @return true if the string is a palindrome
	 */
	public boolean isPalindromeLoop()
	{
		String temp = inputString.toLowerCase();//ignore case by making the string lower case
		boolean isPalindrome = true;
		for(int i = 0; i < inputString.length()/2; i++)
		{
			if(temp.charAt(i) != temp.charAt(temp.length()-i-1))
			{
				isPalindrome = false;
			}
		}
		return isPalindrome;
	}
	
	public boolean isPalindromeAppend()
	{
		StringBuilder toCompare = new StringBuilder();
		for(int i = 0; i < inputString.length(); i++)
		{
			toCompare.append(inputString.charAt(inputString.length()-1-i));
		}
		return inputString.equalsIgnoreCase(toCompare.toString());
	}
}
