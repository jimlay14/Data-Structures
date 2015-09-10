import java.util.*;

/**
 * A class to test out the shape hierarchy
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class ShapeTester {

	/**
	 * Perform the following steps:
	 * 1. Ask the user for the type of figure.
	 * 2. Ask the user for the characteristics of that figure
	 * 3. Compute the perimeter
	 * 4. Compute the area.
	 * 5. Display the result
	 * @param args Command line arguments not used
	 */
	public static void main(String[] args) 
	{
		Shape myShape;
		double perimeter;
		double area;
		myShape = getShape(); // ask for figure type
		myShape.readShapeData(); // read the shape data
		perimeter = myShape.computePerimeter(); // compute perimeter
		area = myShape.computeArea(); // compute area
		displayResult(myShape, area, perimeter); // display the result
		System.exit(0); // exit the program
	}
	
	/**
	 * Ask user for the type of figure.
	 * @return An instance of of the selected shape
	 */
	@SuppressWarnings("resource") // prevent warning from not closing scanner
	public static Shape getShape()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter C for Circle");
		System.out.println("Enter R for Rectangle");
		System.out.println("Enter T for Right Triangle");
		String figType = in.next();
		if(figType.equalsIgnoreCase("c")){
			return new Circle();
		}
		if(figType.equalsIgnoreCase("r")){
			return new Rectangle();
		}
		else if(figType.equalsIgnoreCase("t")){
			return new RtTriangle();
		}
		else{
			return null;
		}	
	}
	
	/**
	 * Display the result of the computation
	 * @param myShape The shape to display the result of
	 * @param area The area of the figure
	 * @param perim The perimeter of the figure
	 */
	private static void displayResult(Shape myShape, double area, double perim)
	{
		System.out.println(myShape);
		System.out.printf("The area is %.2f%nThe perimeter is %.2f%n",
				area, perim);
	}

}
