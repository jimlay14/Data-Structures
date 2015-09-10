/**
 * Abstract class for a geometric shape.
 * @author Jacob/ Koffman & Wolfgange
 *
 */
public abstract class Shape 
{
	//data fields
	
	/**
	 * The name of the shape
	 */
	private String shapeName = "";

	//methods
	
	/**
	 * Initializes the shapeName.
	 * @param shapeName The kind of shape.
	 */
	public Shape(String shapeName)
	{
		this.shapeName = shapeName;
	}
	
	/**
	 * Get the kind of shape
	 * @return The shapeName
	 */
	public String getShapeName() {
		return shapeName;
	}
	
	@Override
	public String toString()
	{
		return "Shape is a " + shapeName;
	}
	
	//abstract methods
	
	public abstract double computeArea();
	public abstract double computePerimeter();
	public abstract void readShapeData();
	
	
}
