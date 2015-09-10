/**
 * Class representing a computer
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Computer 
{
	//data fields
	private String manufacturer;
	private String processor;
	private double ramSize;
	private int diskSize;
	private double processorSpeed;
	private double cost;
	private int expansionSlots;
	
	//FOR SECTION 1.3
	private static final String DEFAULT_MAN = "MyBrand";
	private static final String PROC = "MyProcessor";
	private static final double RAM = 4.0;
	private static final int DSIZE  = 151;
	private static final double PROCSPEED = 2.4;
	
	//methods
	/**
	 * Initialize a Computer object with all original properties specified
	 * @param man The computer manufacturer
	 * @param processor The processor type
	 * @param ram The RAM size
	 * @param disk The disk size
	 * @param procSpeed The processor speed
	 */
	public Computer(String man, String processor, double ram, int disk, double procSpeed) 
	{
		manufacturer = man;
		this.processor = processor;
		ramSize = ram;
		diskSize = disk;
		processorSpeed = procSpeed;
	}
	
	/**
	 * Initialize a Computer object with all properties specified
	 * @param man The computer manufacturer
	 * @param processor The processor type
	 * @param ram The RAM size
	 * @param disk The disk size
	 * @param procSpeed The processor speed
	 * @param cost The original cost of the computer
	 * @param slots The number of expansion slots the computer has
	 */
	public Computer(String man, String processor, double ram, int disk, double procSpeed, double cost, int slots) 
	{
		manufacturer = man;
		this.processor = processor;
		ramSize = ram;
		diskSize = disk;
		processorSpeed = procSpeed;
		this.cost = cost;
		expansionSlots = slots;
	}
	
	public Computer()
	{
		this(DEFAULT_MAN, PROC, RAM, DSIZE, PROCSPEED);
	}
	
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	/**
	 * Computes the computer's processing power
	 * @return The computer's processing power
	 */
	public double computePower() { return ramSize * processorSpeed; }
	
	/**
	 * Return the computer RAM size
	 * @return The RAM of the computer
	 */
	public double getRamSize() { return ramSize;	}
	
	public void setRamSize(double ramSize) {
		this.ramSize = ramSize;
	}

	/**
	 * Get the processor speed
	 * @return The processor speed
	 */
	public double getProcessorSpeed() { return processorSpeed; }
	
	public void setProcessorSpeed(double processorSpeed) {
		this.processorSpeed = processorSpeed;
	}

	/**
	 * Access the computer's disk Size
	 * @return The disk size of the computer
	 */
	public int getDiskSize() { return diskSize; }
	
	public void setDiskSize(int diskSize) {
		this.diskSize = diskSize;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getExpansionSlots() {
		return expansionSlots;
	}

	public void setExpansionSlots(int expansionSlots) {
		this.expansionSlots = expansionSlots;
	}

	/**
	 * Return a string representation of the computer
	 */
	public String toString()
	{
		String result = "Manufacturer: " + manufacturer +
				"\nCPU: " + processor +
				"\nRAM: " + ramSize + " gigabytes" +
				"\nDisk: " + diskSize + " gigabytes" +
				"\nProcessor speed: " + processorSpeed + " gigahertz";
		return result;
	}
	
	//public Computer()
	
	//FOR SECTION 1.3:
	
	/**
	 * Constructor allowing only the processor to be specified
	 * @param processor The user specified processor
	 */
	public Computer(String processor)
	{
		this(DEFAULT_MAN, processor, RAM, DSIZE, PROCSPEED);
	}
	
	/**
	 * Constructor allowing only the RAM size to be specified
	 * @param ram The user specified RAM size
	 */
	public Computer(double ram)
	{
		this(DEFAULT_MAN, PROC, ram, DSIZE, PROCSPEED);
	}
	
	/**
	 * Constructor allowing only the disk size to be specified
	 * @param diskSize
	 */
	public Computer(int disk)
	{
		this(DEFAULT_MAN, PROC, RAM, disk, PROCSPEED);
	}
	
	/**
	 * Compares power of this computer and its argument computer
	 * @param aComputer The computer being compared to this computer
	 * @return -1 if this computer has less power, 0 if the same, and 1 if this computer has more power
	 */
	public int comparePower(Computer aComputer)
	{
		if(this.computePower() < aComputer.computePower())
			return -1;
		else if(this.computePower() == aComputer.computePower())
			return 0;
		else return 1;
	}
}

