import java.util.*;

/**
 * Class that can evaluate a postfix expression
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class PostfixEvaluator 
{
	//Nested Class
	/** Class to report a syntax error */
	@SuppressWarnings("serial")
	public static class SyntaxErrorException extends Exception
	{
		/**
		 * Construct a SyntaxErrorException with the
		 * specified message
		 * @param message The message
		 */
		SyntaxErrorException(String message)
		{
			super(message);
		}
	}
	
	//Constant
	
	/** A list of operators */
	private static final String OPERATORS = "+-*/";
	
	//Data field
	
	/** The operand stack */
	private Stack<Integer> operandStack;
	
	//Methods
	
	/**
	 * Evaluates the current operation.
	 * This function pops the two operands off the operand
	 * stack and applies the operator.
	 * @param op A character representing the operator
	 * @return The result of applying the operator
	 * @throws EmptyStackException if pop is attempted on 
	 * an empty stack
	 */
	private int evalOp(char op)
	{
		//Pop the two operands off the stack.
		int rhs = operandStack.pop();
		int lhs = operandStack.pop();
		int result = 0;
		//Evaluate the operator.
		switch (op) {
			case '+' : result = lhs + rhs;
					break;
			case '-' : result = lhs - rhs;
					break;
			case '*' : result = lhs * rhs;
					break;
			case '/' : result = lhs / rhs;
					break;
		}
		return result;
	}
	
	/**
	 * Determines whether a character is an operator
	 * @param ch The character to be tested
	 * @return true if the character is an operator
	 */
	private boolean isOperator(char ch)
	{
		return OPERATORS.indexOf(ch) != -1;
	}
	
	/**
	 * Evaluates a postfix expression
	 * @param expression The expression to be evaluated
	 * @return The value of the expression
	 * @throws SyntaxErrorException if a syntax error is detected
	 */
	public int eval(String expression) throws SyntaxErrorException
	{
		//create an empty stack.
		operandStack = new Stack<Integer>();
		
		//process each token
		String[] tokens = expression.split("\\s+");
		try {
			for (String nextToken : tokens)
			{
				char firstChar = nextToken.charAt(0);
				//Does it start with a digit?
				if (Character.isDigit(firstChar)) {
					//Get the integer value.
					int value = Integer.parseInt(nextToken);
					//push value onto operand stack.
					operandStack.push(value);
				} //Is it an operator?
				else if (isOperator(firstChar)) {
					//Evaluate the operator.
					int result = evalOp(firstChar);
					//push result onto the operand stack.
					operandStack.push(result);
				} else {
					//Invalid character.
					throw new SyntaxErrorException(
							"Invalid character encountered: " + firstChar);
				}
			} //End for
			
			//No more tokens - pop result from operand stack.
			int answer = operandStack.pop();
			//Operand stack should be empty.
			if (operandStack.empty()) {
				return answer;
			} else {
				//Indicate syntax error.
				throw new SyntaxErrorException(
						"Syntax Error: Stack should be empty");
			}
		} catch (EmptyStackException ex) {
			//Pop was attempted on an empty stack.
			throw new SyntaxErrorException(
					"Syntax Error: The stack is empty");
		}
	}
	
}
