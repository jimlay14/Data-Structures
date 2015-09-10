
public class Employee 
{
	//data fields
	private String name;
	private double hours;
	private double rate;
	private String address;
	
	private static final double HOURS = 8.0;
	private static final double RATE = 10.0;
	
	//Methods- override of equals method
	@Override
	public boolean equals(Object obj)
	{
		if(obj == this)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() == obj.getClass())
		{
			Employee other = (Employee) obj; //downcast to Employee
			return name.equals(other.name) && address.equals(other.address); //return if name and address are the same
		}
		return false;
	}
	
	/**
	 * Constructor for the Employee
	 * @param n Name for an employee
	 * @param h Hours for an employee
	 * @param r Pay rate for an employee
	 * @param add Address for an employee
	 */
	public Employee(String n, double h, double r, String add)
	{
		name = n;
		hours = h;
		rate = r;
		address = add;
	}
	
	public Employee (String n, String add)
	{
		this(n, HOURS, RATE, add);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

}
