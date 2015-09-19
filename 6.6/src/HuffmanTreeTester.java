
/**
 * Tester for the HuffmanTree
 * @author Jacob
 *
 */
public class HuffmanTreeTester {
	public static void main(String[] args){
		//build tree in Figure 6.37
		String letters = "abcde";
		HuffmanTree.HuffData<Character> letterA = new HuffmanTree.HuffData<Character>(64, new Character(letters.charAt(0)));
		HuffmanTree.HuffData<Character> letterB = new HuffmanTree.HuffData<Character>(13, new Character(letters.charAt(1)));
		HuffmanTree.HuffData<Character> letterC = new HuffmanTree.HuffData<Character>(22, new Character(letters.charAt(2)));
		HuffmanTree.HuffData<Character> letterD = new HuffmanTree.HuffData<Character>(32, new Character(letters.charAt(3)));
		HuffmanTree.HuffData<Character> letterE = new HuffmanTree.HuffData<Character>(103, new Character(letters.charAt(4)));
		@SuppressWarnings("unchecked")
		HuffmanTree.HuffData<Character>[] data = new HuffmanTree.HuffData[5];
		data[0] = letterA;
		data[1] = letterB;
		data[2] = letterC;
		data[3] = letterD;
		data[4] = letterE;
		HuffmanTree<Character> tree = new HuffmanTree<Character>();
		tree.buildTree(data);
		//Print the tree
		tree.printTree();
		System.out.print("\n");
		//Decode message in Self-Check exercise 3
		System.out.println(tree.decode("11101011011001111") + "\n");
		
		//build tree for Self-Check exercise 4
		String ops = "*+-/%";
		HuffmanTree.HuffData<Character> opMult = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(0)));
		HuffmanTree.HuffData<Character> opPlus = new HuffmanTree.HuffData<Character>(30, new Character(ops.charAt(1)));
		HuffmanTree.HuffData<Character> opMin = new HuffmanTree.HuffData<Character>(25, new Character(ops.charAt(2)));
		HuffmanTree.HuffData<Character> opDiv = new HuffmanTree.HuffData<Character>(10, new Character(ops.charAt(3)));
		HuffmanTree.HuffData<Character> opMod = new HuffmanTree.HuffData<Character>(5, new Character(ops.charAt(4)));
		@SuppressWarnings("unchecked")
		HuffmanTree.HuffData<Character>[] data2 = new HuffmanTree.HuffData[5];
		data2[0] = opMult;
		data2[1] = opPlus;
		data2[2] = opMin;
		data2[3] = opDiv;
		data2[4] = opMod;
		HuffmanTree<Character> tree2 = new HuffmanTree<Character>();
		tree2.buildTree(data2);
		//Print the tree
		tree2.printTree();
		System.out.print("\n");
		
		//Build theoretical "same weight" tree for Self-Check Exercise 5
		HuffmanTree.HuffData<Character> opMult2 = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(0)));
		HuffmanTree.HuffData<Character> opPlus2 = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(1)));
		HuffmanTree.HuffData<Character> opMin2 = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(2)));
		HuffmanTree.HuffData<Character> opDiv2 = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(3)));
		HuffmanTree.HuffData<Character> opMod2 = new HuffmanTree.HuffData<Character>(50, new Character(ops.charAt(4)));
		@SuppressWarnings("unchecked")
		HuffmanTree.HuffData<Character>[] data3 = new HuffmanTree.HuffData[5];
		data3[0] = opMult2;
		data3[1] = opPlus2;
		data3[2] = opMin2;
		data3[3] = opDiv2;
		data3[4] = opMod2;
		HuffmanTree<Character> tree3 = new HuffmanTree<Character>();
		tree3.buildTree(data3);
		//Print the tree
		tree3.printTree();
		System.out.print("\n");
	}
}
