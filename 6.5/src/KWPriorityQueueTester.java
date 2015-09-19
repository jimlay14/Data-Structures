/**
 * Tester for the KWPriorityQueue
 * @author Jacob
 *
 */
public class KWPriorityQueueTester {
	private static final double P1 = 0.8;
	private static final double P2 = 0.2;
	
	public static void main(String[] args){
		
		//Build and print arrays from Self-Check Exercise #2
		KWPriorityQueue<String> tester = new KWPriorityQueue<String>();
		tester.offer("this");
		tester.offer("is");
		tester.offer("the");
		tester.offer("house");
		tester.offer("that");
		tester.offer("jack");
		tester.offer("built");
		System.out.println(tester.toString() +"\n");
		
		KWPriorityQueue<String> tester2 = new KWPriorityQueue<String>();
		tester2.offer("built");
		tester2.offer("is");
		tester2.offer("the");
		tester2.offer("house");
		tester2.offer("that");
		tester2.offer("jack");
		tester2.offer("this");
		System.out.println(tester2.toString() +"\n");
		
		//Self-Check Exercise 4
		KWPriorityMaxQueue<Integer> tester3 = new KWPriorityMaxQueue<Integer>();
		tester3.offer(new Integer(15));
		tester3.offer(new Integer(25));
		tester3.offer(new Integer(10));
		tester3.offer(new Integer(33));
		tester3.offer(new Integer(55));
		tester3.offer(new Integer(47));
		tester3.offer(new Integer(82));
		tester3.offer(new Integer(90));
		tester3.offer(new Integer(18));
		System.out.println(tester3.toString() +"\n");
		
		//Self-Check Exercise 5
		KWPriorityQueue<Double> tester4 = new KWPriorityQueue<Double>();
		tester4.offer(new Double(P1 * 256 + P2 * 1100)); //P1 * 256 + P2 * 1100 = 424.8 (Document 1)
		tester4.offer(new Double(P1 * 512 + P2 * 1101)); //P1 * 512 + P2 * 1101 = 629.8 (Document 2)
		tester4.offer(new Double(P1 * 64 + P2 * 1102)); //P1 * 64 + P2 * 1102 = 271.6 (Document 3)
		tester4.offer(new Double(P1 * 96 + P2 * 1103)); //P1 * 96 + P2 * 1103 = 297.4 (Document 4)
		System.out.println(tester4.toString() +"\n");
		
		//Testing out that stream* (later)
	}
}
