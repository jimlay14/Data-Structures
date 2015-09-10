
public class Tester 
{
	public static void main(String[] args)
	{
		Number[] nums = new Number[5]; //create a new Number array
		nums[0] = new Integer(35); //put an Integer of value 35 into the first spot of the array
		nums[1] = new Double(3.45); //put a double of value 3.45 into the second spot of the array
		nums[4] = new Double("2.45e6"); //in the last spot of the array, put a double of value "2.45e6"
		double x = 0; //declare temporary variable x as a double
		for(int i = 0; i < nums.length; i++) // for each item in the array
		{
			if(nums[i] != null) // if this spot in the array is not null
				x += nums[i].doubleValue(); // add double value of the Number to x; making x the sum of each Number's double value
			System.out.println("x = " + x);
		}
		System.out.println("\n");

		Vegetable beet = new Vegetable(1000, 70, 30);
		System.out.println("Beet percent protein = " + beet.percentProtein());
		System.out.println("Beet percent fat = " + beet.percentFat());
		System.out.println("Beet percent carbohydrates + " + beet.percentCarbohydrates());
		
		Notebook computer = new Notebook("DellGate", "AMD", 4, 240, 1.8, 15.0, 7.5);
		System.out.println("\n");
		System.out.println("This computer is:\n" + computer);
		System.out.println("The cost benefit of this computer is: " + computer.costBenefit(1500));
	}
	
	
}
