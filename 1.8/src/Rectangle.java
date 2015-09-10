import java.util.*;

/**
 * Represents a rectangle and extends Shape
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Rectangle extends Shape
{
	//data fields
	
	private double width = 0; //width of the rectangle
	private double height = 0; //height of the rectangle
	
	//methods
	
	/**
	 * Initialize a basic rectangle
	 */
	public Rectangle()
	{
		super("Rectangle");
	}
	
	/**
	 * Construct a rectangle of a specified size
	 * @param width The width of the rectangle
	 * @param height The height of the rectangle
	 */
	public Rectangle(double width, double height)
	{
		super("Rectangle");
		this.width = width;
		this.height = height;
	}

	/**
	 * Get the width
	 * @return The width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * Get the height
	 * @return The height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Compute the area
	 * @return The area of the rectangle
	 */
	@Override
	public double computeArea()
	{
		return height * width;
	}

	/**
	 * Compute the perimeter
	 * @return The perimeter of the rectangle
	 */
	@Override
	public double computePerimeter() 
	{
		return 2 * (height + width);
	}

	/**
	 * Read the attributes of the rectangle
	 * I wanted to extend this by catching user input error, but it does not seem to work- further testeing needed
	 */
	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in); //create a new scanner
		System.out.println("Enter the width of the Rectangle"); //ask user for width
		width = in.nextDouble(); //get width		}
		System.out.println("Enter the height of the Rectangle"); //ask user for height
		height = in.nextDouble(); //get height
		in.close(); // close scanner for proper formatting
	}
	
	/**
	 * Create a string representation of the rectangle
	 * @return A string representation of the rectangle
	 */
	@Override
	public String toString()
	{
		return super.toString() + ": width is " + width
				+ ", height is " + height;
	}

}
