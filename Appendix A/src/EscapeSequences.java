
public class EscapeSequences {
	public static void main(String[] args){
		System.out.println("n \tsquare root");
		for(int n = 1; n <= 10; n++){
			System.out.println(n + "\t" + Math.sqrt(n));
		}
		
		System.out.println();
		
		System.out.println(
				"Jane\'s motto is \n\"semper fi\"\n, according to Jim"); //self-check 1
		
		System.out.println();
		
		System.out.println("p \t2 raised to p"); // Programming 1
		for(int n = 1; n <= 29; n+=2){
			System.out.println(n + "\t" + Math.pow(2, n));
		}
		
		System.out.println();
		
		System.out.println("n \tnatural log of n");
		for(int n = 1000; n <= 262144000; n *= 2){
			logVals(n);
		}
	}
	
	public static void logVals(double n){
		System.out.println(n + "\t" + Math.log(n));
	}
}
