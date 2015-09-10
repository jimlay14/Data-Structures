
public class ControlStatements 
{
	public static void main(String[] args)
	{
		{
			double x = 3.45;
			double y = 2 * x;
			int i = (int) y;
			i++;
			System.out.println(i);
		}
		
		int x = 5;
		int y = 5;
		int result = 0;
		char operator = '+';
		
		switch(operator){
		case '+':
			result = x + y;
			break;
		case '-':
			result = x - y;
			break;
		case '*':
			result = x * y;
			break;
		case '/':
			result = x / y;
			break;
		}
		
		System.out.println("Result = " + result);
		
		int sum = 0;
		int prod = 1;
		
		int nextInt = 1;
		do {
			if(nextInt % 2 == 0){
				sum += nextInt;
			} else {
				prod *= nextInt;
			}
			nextInt++;
		} while(nextInt <= result);
		
		System.out.println("Sum of evens = " + sum);
		System.out.println("Product of odds = " + prod);
	}
}
