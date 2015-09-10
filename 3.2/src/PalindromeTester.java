import java.util.*;

public class PalindromeTester 
{
	public static void main(String[] args)
	{
		PalindromeFinder yes = new PalindromeFinder("Able was I ere I saw Elba");
		PalindromeFinder no = new PalindromeFinder("not a palindrome");
		PalindromeFinder one = new PalindromeFinder("a");
		PalindromeFinder noWord = new PalindromeFinder("");
		
		System.out.println("Test 1 is true: " + yes.isPalindromeAppend());
		System.out.println("Test 2 is false: " + no.isPalindromeAppend());
		System.out.println("Test 3 is true: " + one.isPalindromeAppend());
		System.out.println("Test 4 is true: " + noWord.isPalindromeAppend());
		
		String test = "Jumbing";
		System.out.println(test);
		test = test.replace('b', 'p');
		System.out.println(test);
		test = test.replaceAll("Ju", "Ca");
		System.out.println(test);
		String tester = "Take me to your leader";
		System.out.println(tester);
		String[] res = tester.split("\\s+");
		for(String s : res)
		{
			System.out.println(s);
		}
		
		System.out.println(lineReverser("The quick brown fox jumped over the lazy dog"));
	}
	
	public static String lineReverser(String input)
	{
		Stack<String> s = new Stack<String>();
		System.out.println(input);
		String[] split = input.split(" "); //split the word around any spaces
		
		for(int i = 0; i < split.length; i++)
		{
			s.push(split[i]); //add the words to the stack
		}
		
		StringBuilder result = new StringBuilder();
		while(!s.empty())
		{
			result.append(s.pop()); //append the words in reverse order
			result.append(" "); //re-add spaces
		}
		return result.toString();
	}
}
