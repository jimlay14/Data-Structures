/**
 * Class to perform tests on our single-linked list, and exercises
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SingleLinkedList<String> names  = new SingleLinkedList<String>();
		names.addFirst("Sam");
		names.addFirst("Harry");
		names.addFirst("Dick");
		names.addFirst("Tom");
		System.out.println(names.toString());
		
		//programming 2
		names.addFirst("Bill");
		names.add(names.indexOf("Sam"), "Sue"); // utilize indexOf method to put Sue in front of Sam
		names.remove(0); //Bill is first, so remove first
		names.remove(names.indexOf("Sam")); //remove Sam at his index
		System.out.println(names.toString());
		
		//programming 3 test
		names.remove("Harry");
		System.out.println(names.toString());
		
		//programming 4 test
		names.addNoHelper(2, "Adam");
		System.out.println(names.toString());
	}

}
