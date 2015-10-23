
/**
 * Tests the implementation of the skip list
 * @author Jacob
 *
 */
public class SkipListTester {
	public static void main(String[] args){
		SkipList<Integer> test = new SkipList<Integer>();
//		test.add(5);
//		test.add(7);
//		test.remove(5);
		for(int i = 0; i < 100; i++){
			test.add(i);
		}
		for(int i = 99; i > 5; i--){
			test.remove(i);
		}
		System.out.println(test.toString());
	}
}
