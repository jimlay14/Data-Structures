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
		manufacturer = null;
		this.processor = null;
		ramSize = 0.0;
		diskSize = 0;
		processorSpeed = 0.0;
		cost = 100.0;
		expansionSlots = 3;
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
}
