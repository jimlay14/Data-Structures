import java.util.*;
/**
 * Class representing a right triangle; extends the Shape class
 * @author Jacob
 *
 */
public class RtTriangle extends Shape
{
	//data fields
	
	private double length = 0; // horizontal length of triangle
	private double height = 0; // height of the rectangle
	
	// methods
	
	/**
	 * Instantiate a right triangle
	 */
	public RtTriangle()
	{
		super("Right Triangle");
	}
	
	/**
	 * Instantiate a right triangle with length and height specified
	 * @param length The length of the triangle
	 * @param height The height of the triangle
	 */
	public RtTriangle(double length, double height)
	{
		super("Right Triangle");
		this.length = length;
		this.height = height;
	}

	/**
	 * A method to compute the area
	 * @return The area of the triangle
	 */
	@Override
	public double computeArea() 
	{
		return (length * height) / 2; // length times height divided by two
	}

	/**
	 * Compute the perimeter
	 * @return The perimeter of the triangle
	 */
	@Override
	public double computePerimeter() 
	{
		return length + height + Math.sqrt(Math.pow(length, 2) + Math.pow(length, 2)); // length + height + the hypotenuse
	}

	/**
	 * Read the attributes of a triangle
	 */
	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the Right Triangle:");
		length = in.nextDouble();
		System.out.println("Enter the height of the Right Triangle:");
		height = in.nextDouble();
		in.close();
	}
	
	/**
	 * Create a string representation of the Triangle
	 * @return A string representation of the rectangle
	 */
	@Override
	public String toString()
	{
		return super.toString() + ": length is " + length
				+ ", height is " + height;
	}
}
