
public class Tester 
{
	/**
	 * Examples and programming exercises for 1.5
	 * @param args No argument list
	 */
	public static void main(String[] args) 
	{
		Object[] stuff = new Object[5];//array of any object
		stuff[0] = new Integer(25);
		stuff[1] = new Double(3.44);
		stuff[2] = new String("Yosef Yoh");
		stuff[3] = new Integer(42);
		stuff[4] = new Double(1.2345678);
		double sum = 0;
		for(int i = 0; i < stuff.length; i++)
		{
			if(stuff[i] instanceof Number)//instanceof checks to see if the object is a Number
			{
				Number next = (Number) stuff[i]; //downcast to a number
				sum += next.doubleValue();
			}
			System.out.println("sum = " + sum);
		}
		
		System.out.println("\n");
		
//		What the above would look like without polymorphism
//		if(stuff[i] instanceof Integer)
//			sum += ((Integer) stuff[i]).doubleValue();
//		else if (stuff[i] instanceof Double)
//			sum += ((Double) stuff[i]).doublevalue();
//		else if (stuff[i] instanceof Float)
//			sum += ((Float) stuff[i]).doubleValue();
		
		Employee a = new Employee("BOB", "Stockton, CA");
		Employee b = new Employee("Santia", "Fresno, CA");
		Employee c = new Employee("BOB", "Stockton, CA");
		System.out.println(a.equals(a));
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
		System.out.println("\n");
		
		Object o = new String("Hello"); //this creates a new object variable that references a String "Hello"
//		String s = o; //this causes a compiling error; object o cannot be converted to a String without a downcast
		String s = (String) o; //correct statement
		Object p = 25; // this creates a new object that references the int 25
//		int k = p; //this causes the same compiling error as before; without a downcast to an int, object p cannot be an actual int
		int k = (int) p; // correct statement
		Number n = k; // creates a new Number object from the int k; like an upcast
		System.out.println(o + "\n" + s + "\n" +  p + "\n" + k + "\n" + n);
		
		System.out.println("\n");
		Computer dell = new Notebook("DellGate", "AMD", 4, 240, 1.8, 15.0, 7.5);
		Notebook dellTwo = new Notebook("DellTacular", "WutWut", 4, 240, 3.0, 15.0, 7.5);
		Notebook dellThree = (Notebook) dell;
		System.out.println(dell.equals(dell) + "\n" + dell.equals(dellTwo) + "\n" + 
				dellTwo.equals(dellTwo) + "\n" + dell.equals(dellThree));
		
		//Test to see if arrays have a equals method
		int[] one = new int[2];
		int[] two = new int[3];
		System.out.println("\n");
		System.out.println(one.equals(one) + "\n" + one.equals(two));
	}

}
