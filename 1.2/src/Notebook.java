
/**
 * Class representing a Notebook computer
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Notebook extends Computer
{
	//data fields
	private double screenSize;
	private double weight;
	private String batteryID;
	private double chargeLeft;
	private boolean wirelessAvailable;

	//methods
	/**
	 * Initialize a Notebook with all original properties specified
	 * @param man The computer manufacturer
	 * @param proc The processor type
	 * @param ram The RAM size
	 * @param disk The disk size
	 * @param procSpeed The processor speed
	 * @param screen The screen size
	 * @param wei The weight
	 */
	public Notebook(String man, String proc, double ram, int disk,
			double procSpeed, double screen, double wei) 
	{
		super(man, proc, ram, disk, procSpeed); //parent class constructor
		screenSize = screen;
		weight = wei;
	}
	
	/**
	 * Initialize a Notebook with all properties specified
	 * @param man The computer manufacturer
	 * @param proc The processor type
	 * @param ram The RAM size
	 * @param disk The disk size
	 * @param procSpeed The processor speed
	 * @param screen The screen size
	 * @param wei The weight
	 */
	public Notebook(String man, String proc, double ram, int disk,
			double procSpeed, double cost, int slots, double screen, double wei,
			String id, double charge, boolean wireless) 
	{
		super(man, proc, ram, disk, procSpeed, cost, slots); //parent class constructor
		screenSize = screen;
		weight = wei;
		batteryID = id;
		chargeLeft = charge;
		wirelessAvailable = wireless;
	}
	
	public Notebook()
	{
		super();
		screenSize = 0.0;
		weight = 10.0;
		batteryID = "stock";
		chargeLeft = 0.0;
		wirelessAvailable = false;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBatteryID() {
		return batteryID;
	}

	public void setBatteryID(String batteryID) {
		this.batteryID = batteryID;
	}

	public double getChargeLeft() {
		return chargeLeft;
	}

	public void setChargeLeft(double chargeLeft) {
		this.chargeLeft = chargeLeft;
	}

	public boolean isWirelessAvailable() {
		return wirelessAvailable;
	}

	public void setWirelessAvailable(boolean wirelessAvailable) {
		this.wirelessAvailable = wirelessAvailable;
	}
	
//	Form of call to parent's constructor:
//	super();
//	super(argumentList);

}
