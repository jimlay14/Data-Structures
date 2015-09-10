
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
	
	//New for 1.3
	private static final String DEFAULT_NB_MAN = "MyBrand";
	private static final double SSIZE = 15.0;
	private static final double WEI = 7.0;
	
	//Implementation of abstract methods (1.4)
	
	/**
	 * Get the cost benefit ratio of a Notebook with a given cost
	 */
	public double costBenefit(double cost)
	{
		if(cost == 0)
			return 0;
		return (super.computePower() * screenSize * 10.0) / cost;
	}
	
	/**
	 * Get the cost benefit ratio of a Notebook; assuming a cost has been set
	 */
	public double costBenefit()
	{
		if(super.getCost() == 0)
			return 0;
		return costBenefit(super.getCost());
	}
	
	//Override of equals method (1.5)
	@Override
	public boolean equals(Object obj)
	{
		boolean computerE = super.equals(obj);
		if(computerE == true)
		{
			Notebook n = (Notebook) obj;
			return ((Double) screenSize).equals((Double) n.screenSize) && ((Double) weight).equals((Double) n.weight);
		}
		return false;
	}

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
		screenSize = SSIZE;
		weight = WEI;
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
	
//FOR SECTION 1.3:
	
	/**
	 * basic toString method for Notebooks (does not include extensions)
	 */
	@Override
	public String toString()
	{
		String result = super.toString() +
				"\nScreen size: " + screenSize + " inches" +
				"\nWeight: " + weight + " pounds";
		return result;
	}
	
	/**
	 * Initialize a Notebook with 6 properties specified; see other constructor for parameter descriptions
	 */
	public Notebook(String proc, int ram, int disk, double procSpeed, double screen, double wei)
	{
		this(DEFAULT_NB_MAN, proc, ram, disk, procSpeed, screen, wei);
	}
	
	/**
	 * Constructor allowing only the processor to be specified
	 * @param processor
	 */
	public Notebook(String processor)
	{
		super(processor);
		screenSize = SSIZE;
		weight = WEI;
	}
	
	public Notebook(double ram)
	{
		super(ram);
		screenSize = SSIZE;
		weight = WEI;
	}
	
	public Notebook(int disk)
	{
		super(disk);
		screenSize = SSIZE;
		weight = WEI;
	}
	
//	Form of call to parent's constructor:
//	super();
//	super(argumentList);
	
//  Form of call to parent's methods:
//	super.methodName();
//	super.methodName(argumentList);
	
//	Form of this method:
//	this(argumentList); Invokes constructor of this class with matching argument list

}


