import java.io.*;
import java.util.*;

/**
 * Class to build an index (6.4 Case Study)
 * @author Jacob/ Koffman & Wolfgang
 *
 */
public class IndexGenerator {
	//Data Fields
	/**
	 * Tree for storing the index
	 */
	private TreeSet<String> index;
	
	//Methods
	public IndexGenerator(){
		index = new TreeSet<String>();
	}
	
	/**
	 * Reads each word in a data file and stores it in an index along with its line number
	 * post: lowercase form of each word with its line number is stored in the index
	 * @param scan A Scanner object
	 */
	public void buildIndex(Scanner scan){
		int lineNum = 0; //line number
		//keep reading lines until done
		while(scan.hasNextLine()){
			lineNum++;
			//extract each token and store it in index
			String token;
			while((token = scan.findInLine("[\\p{L}\\p{N}']+")) != null){
				token = token.toLowerCase();
				index.add(String.format("%s,  %3d", token, lineNum));
			}
			scan.nextLine(); //clear the scan buffer
		}
	}
	
	/**
	 * Displays the index, one word per line
	 */
	public void showIndex(){
		//use an iterator to access and display tree data
		for(String next : index){
			System.out.println(next);
		}
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner("This PC/Documents/Essay1-Program[1]");
		IndexGenerator ig = new IndexGenerator();
		ig.buildIndex(sc);
		ig.showIndex();
	}
}
