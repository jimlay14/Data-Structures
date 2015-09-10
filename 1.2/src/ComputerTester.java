
public class ComputerTester 
{
	public static void main(String[] args)
	{
//		Computer c1 = new Computer(); // attempt to create a new computer; invalid because computer does not have a no parameter constructor
		Computer c2 = new Computer("Ace", "AMD", 1.0, 160, 2.0); // successfully create a new Ace computer
//		Notebook c3 = new Notebook("Ace", "AMD", 2.0, 160, 1.8); // attempt tocreate a new Notebook; invalid as Notebook parameters are not specified
		Notebook c4 = new Notebook("Bravo", "Intel", 1.0, 160, 2.0, 15.5, 7.5); // successfully create a new Bravo notebook
//		System.out.println(c2.manufacturer + ", " + c4.processor); // unsuccessfully print out c2's manufacturer and c4's processor; variables cannot be accessed directly
		System.out.println(c2.getDiskSize() + ", " + c4.getRamSize());
		System.out.println(c2.toString() + "\n" + c4.toString());
	}
}
