
/**
 * A class to test the double linked list and list iterator of KWLinkedList
 * @author Jacob
 *
 */
public class Tester 
{
	/**
	 * Run several tests of the KWLinkedList
	 * @param args No argument list
	 */
	public static void main(String[] args)
	{
		KWLinkedList<String> test = new KWLinkedList<String>();
		
		for(int i = 0; i < 10; i++)
		{
			test.addLast(("String: " + i));
			System.out.println(test.getFirst());
		}
		
		for(int i = 5; i < 10; i++)
		{
			test.add(i, ("String: " + i + "x"));
		}
		
		System.out.println("\n");
		
		for(int i = 0; i < test.getSize(); i++)
		{
			System.out.println(test.get(i));	
		}
				
	}
}
