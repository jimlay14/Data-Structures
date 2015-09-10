import java.util.*;
/**
 * A class representing a Circle, extending the Shape class
 * @author Jacob
 *
 */
public class Circle extends Shape
{
	//data fields
	
	private double radius = 0; // circle's dimensions are based on its radius
	
	//methods
	
	/**
	 * Insantiate a basic circle
	 */
	public Circle()
	{
		super("Circle");
	}

	/**
	 * Instantiate a circle with a given radius
	 * @param radius The radius of the circle
	 */
	public Circle(double radius) 
	{
		super("Circle");
		this.radius = radius;
	}
	
	/**
	 * Get the radius of the circle
	 * @return The radius
	 */
	public double getRadius()
	{
		return radius;
	}

	/**
	 * Compute the area
	 * @return The area of the circle
	 */
	@Override
	public double computeArea() 
	{
		return Math.pow(radius, 2) * Math.PI; // radius squared times pi
	}

	/**
	 * Compute the perimeter
	 * @return The perimeter of the circle
	 */
	@Override
	public double computePerimeter() 
	{
		return (radius * 2) * Math.PI; // diameter times pi for the circumference
	}

	/**
	 * Read the attributes of a Circle
	 * I plan to extend this later to handle user input error
	 */
	@Override
	public void readShapeData() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the radius of the Circle");
		radius = in.nextDouble();
		in.close(); // close scanner for formatting
	}
	
	/**
	 * Create a string representation of the rectangle.
	 * @return A string representation of the rectangle
	 */
	@Override
	public String toString()
	{
		return super.toString() + ": radius is " + radius;
	}

}
