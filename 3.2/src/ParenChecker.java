import java.util.Stack;
import java.util.EmptyStackException;
import javax.swing.JOptionPane;

/**
 * Class to check for balanced parentheses
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class ParenChecker 
{
	//Constants
	
	/** Set of opening parenthesis characters */
	private static final String OPEN = "([{";
	
	/** Set of closing parenthesis characters, matches OPEN*/
	private static final String CLOSE = ")]}";
	
	//Methods
	
	/**
	 * Method to determine whether a character is one of the opening parentheses
	 * @param ch Character to be tested
	 * @return true if ch is one of the opening parentheses
	 */
	public static boolean isOpen(char ch)
	{
		return OPEN.indexOf(ch) > -1;
	}
	
	/**
	 * Method to determine whether a character is one of the closing parentheses
	 * @param ch Character to be tested
	 * @return true if ch is one of the closing parentheses
	 */
	public static boolean isClose(char ch)
	{
		return CLOSE.indexOf(ch) > -1;
	}
	
	/**
	 * Tests the input string to see that if contains balanced parentheses.
	 * This method tests an input string to see that each type of parenthesis is balanced.
	 * '(' is matched with ')', '[' is matched with']', and '{' is matched with '}'
	 * @param expression A String containing the expression to be examined
	 * @return true if all parentheses match
	 */
	public static boolean isBalanced(String expression)
	{
		//Create an empty stack
		Stack<Character> s = new Stack<Character>();
		boolean balanced = true;
		try {
			int index = 0;
			while(balanced && index < expression.length())
			{
				char nextCh = expression.charAt(index);
				if (isOpen(nextCh)) {
					s.push(nextCh);
				} else if (isClose(nextCh)) {
					char topCh = s.pop();
					balanced = OPEN.indexOf(topCh)
							== CLOSE.indexOf(nextCh);
				}
				index++;
			}
		} catch (EmptyStackException ex) {
			balanced = false;
		}
		return (balanced && s.empty());
	}
	
	//Tester
	
	/**
	 * Main method. Ask the user for a string and 
	 * call the ParenChecker to see whether the parentheses are balanced.
	 * @param args Not used
	 */
	public static void main(String[] args)
	{
		String expression = JOptionPane.showInputDialog(
				"Enter an expression containing parentheses");
		if (ParenChecker.isBalanced(expression)) {
			JOptionPane.showMessageDialog(null, expression 
					+ " is balanced.");
		} else {
			JOptionPane.showMessageDialog(null, expression 
					+ " is not balanced.");
		}
		System.exit(0);
	}
	
}
