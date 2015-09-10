import java.util.*;

import javax.swing.JOptionPane;

/**
 * Translates an infix expression to a postfix expression
 * @author Jacob/ Koffman & Wolfgang
 * 
 */
public class InfixToPostfix {
	// Nested Class

	/** Class to report a syntax error */
	@SuppressWarnings("serial")
	public static class SyntaxErrorException extends Exception {
		/**
		 * Construct a SyntaxErrorException 
		 * with the specified message
		 * @param message The message
		 */
		SyntaxErrorException(String message) {
			super(message);
		}
	}

	// Data Fields

	/** The operator stack */
	private Stack<Character> operatorStack;
	/** The operators */
	private static final String OPERATORS = "+-*/^";
	/** The precedence of the operators matches order in OPERATORS. */
	private static final int[] PRECEDENCE = { 1, 1, 2, 2, 3};
	/** The postfix string */
	private StringBuilder postfix;

	// Methods

	/**
	 * Convert a string from infix to postfix.
	 * @param infix The infix expression
	 * @return The postfix expression equivalent to infix
	 * @throws SyntaxErrorException
	 */
	public String convert(String infix) throws SyntaxErrorException {
		operatorStack = new Stack<Character>();
		postfix = new StringBuilder();
		String[] tokens = infix.split("\\s+");
		boolean lastOperand = true;
		try {
			// process each token in the infix string.
			for (int i = 0; i < tokens.length; i++) {
				char firstChar = tokens[i].charAt(0);
				// Is it an operand?
				if(Character.isJavaIdentifierStart(firstChar)
						|| Character.isDigit(firstChar)) {
					if(lastOperand && i != 0)
					{
						throw new SyntaxErrorException(
								"Adjacent pair of operands");
					}
					postfix.append(tokens[i]);
					postfix.append(' ');
					lastOperand = true;
				} else if (isOperator(firstChar)) {
					// Is it an operator?
					if(!lastOperand)
					{
						throw new SyntaxErrorException(
								"Adjacent pair of operators");
					}
					processOperator(firstChar);
					lastOperand = false;
				} else {
					throw new SyntaxErrorException(
							"Unexpected Character Encountered: " + firstChar);
				}
			} // end loop.

			// Pop any remaining operators and append them to postfix.
			while (!operatorStack.empty()) {
				char op = operatorStack.pop();
				postfix.append(op);
				postfix.append(' ');
			}
			// assert: Stack is empty, return result.
			return postfix.toString();
		} catch (EmptyStackException ex) {
			throw new SyntaxErrorException("Syntax Error: The stack is empty");
		}
	}

	/**
	 * Method to process operators.
	 * @param op The operator
	 * @throws EmptyStackException
	 */
	private void processOperator(char op) {
		if (operatorStack.empty()) {
			operatorStack.push(op);
		} else {
			// Peek the operator stack and
			// let topOp be top operator.
			char topOp = operatorStack.peek();
			if (precedence(op) > precedence(topOp)) {
				operatorStack.push(op);
			} else {
				// Pop all stack operators with equal
				// or higher precedence than op.
				while (!operatorStack.empty()
						&& precedence(op) <= precedence(topOp)) {
					operatorStack.pop();
					postfix.append(topOp);
					postfix.append(' ');
					if (!operatorStack.empty()) {
						// Reset topOp.
						topOp = operatorStack.peek();
					}
				}
				// assert: Operator stack is empty or
				// current operator precedence >
				// top of stack operator precedence
				operatorStack.push(op);
			}
		}
	}

	/**
	 * Determine whether a character is an operator.
	 * @param ch The character to be tested
	 * @return true if ch is an operator
	 */
	private boolean isOperator(char ch) {
		return OPERATORS.indexOf(ch) != -1;
	}

	/**
	 * Determine the precedence of an operator.
	 * @param op The operator
	 * @return The precedence
	 */
	private int precedence(char op) {
		return PRECEDENCE[OPERATORS.indexOf(op)];
	}

	public static void main(String[] args) {
		InfixToPostfix inToPost = new InfixToPostfix();
		String infix = JOptionPane.showInputDialog("Enter an infix expression");
		try {
			String postfix = inToPost.convert(infix);
			JOptionPane.showMessageDialog(null, "Infix expression " + infix
					+ "\nconverts to " + postfix);
		} catch (SyntaxErrorException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		System.exit(0);
	}

}
