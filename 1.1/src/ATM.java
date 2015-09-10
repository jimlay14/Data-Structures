
/**
 * Interface for an ATM
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public interface ATM 
{
	/**
	 * Verifies a user's PIN
	 * @param pin The user's PIN
	 * @return Whether the PIN was verified
	 */
	boolean verifyPIN(String pin);
	
	/**
	 * Allows user to select an account
	 * @return A string representation of the account selected
	 */
	String selectAccount();
	
	/**
	 * Withdraw a specified amount of money
	 * @param account The account from which to withdraw
	 * @param amount The amount of money withdrawn
	 * @return Whether the operation was successful
	 */
	boolean withdraw(String account, double amount);
	
	/**
	 * Display result of an operation
	 * @param account The account for the operation
	 * @param amount The amount of money
	 * @param success Whether or not the operation was successful
	 */
	void display(String account, double amount, boolean success);
	
	/**
	 * Display's the user's PIN verification
	 * @param pin The user's PIN
	 * @param success Whether or not the PIN was valid
	 */
	void display(String pin, boolean success);
	
	/**
	 * Displays an account balance
	 * @param account The account selected
	 */
	void showBalance(String account);
	
//
//	 * Basic interface form
//
//	public interface interfaceName
//	{
//		abstract method headings
//		constant declarations
//	}
}
