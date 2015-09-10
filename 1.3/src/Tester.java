
public class Tester 
{
	/**
	 * Tests classes Computer and Notebook with Section 1.3 tests. 
	 * @param args No control parameters
	 */
	public static void main(String[] args)
	{
		Computer myComputer = new Computer("Acme", "Intel", 2, 160, 2.4);
		Notebook yourComputer = new Notebook("DellGate", "AMD", 4, 240, 1.8, 15.0, 7.5);
		System.out.println("My computer is:\n" + myComputer);
		System.out.println(" ");
		System.out.println("Your computer is:\n" + yourComputer);
		//toString method means we do not have to write out variable.toString() for it to print out.
		
		//Following statements match the above while using polymorphism of the Computer class.
		System.out.println("\n");
		Computer theComputer = myComputer;
		Computer theNotebook = yourComputer;
		System.out.println(theComputer);
		System.out.println(" ");
		System.out.println(theNotebook);
		
		//Show the comparePower method in operation
		System.out.println("\n");
		System.out.println("" + myComputer.comparePower(yourComputer));
		System.out.println("" + myComputer.comparePower(myComputer));
		System.out.println("" + yourComputer.comparePower(myComputer));
		
		//Self Check Exercise 3
		System.out.println("\n");
		Computer comp[] = new Computer[3];
		comp[0] = new Computer("Ace", "AMD", 3, 160, 2.4);
		comp[1] = new Notebook("Dell", "Intel", 4, 350, 2.2, 15.5, 7.5);
		comp[2] = comp[1];
		 //for each computer, print out the Ram size (Computer method), then print out all of the computer's specifics dependent on type
		for(int i = 0; i < comp.length; i++)
		{
		 	System.out.println(comp[i].getRamSize() + "\n" +
		 					   comp[i].toString());
		}
		
		//Test programming excercise constructors
		System.out.println("\n");
		Computer c = new Computer(130);
		Notebook n = new Notebook(130);
		System.out.println(c);
		System.out.println(" ");
		System.out.println(n);
		
	}
}
