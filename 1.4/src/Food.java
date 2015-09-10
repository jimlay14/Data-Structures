/**
 * Abstract class that models a kind of food
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public abstract class Food 
{
	//Data Field
	private double calories;
	
	//Abstract Methods
	
	/**
	 * Calculates percentage of protein in a Food object
	 */
	public abstract double percentProtein();
	
	/**
	 * Calculates the percent of fat in a Food object
	 */
	public abstract double percentFat();
	
	/**
	 * Calculates the percent of carbohydrates in a Food object
	 */
	public abstract double percentCarbohydrates();
	
	//Actual Methods
	
	/**
	 * Access the number of calories a Food object has
	 * @return The number of calories
	 */
	public double getCalories() { return calories; } 
	
	/**
	 * Set the number of calories a Food object has
	 * @param cal The number of calories to set the Food object's number of calories to.
	 */
	public void setCalories(double cal) { calories = cal; }
	
//	Form for abstract classes
//	public abstract class ClassName
//	{
//		data field declarations
//		abstract method declarations
//		actual method definitions
//	}
}
