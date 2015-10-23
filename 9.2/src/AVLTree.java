
/**
 * Self-balancing binary search tree using the algorithm defined by Adelson-Velskii and Landis
 * @author Jacob / Koffman & Wolfgang
 *
 * @param <E> The data type of objects stored in the tree. Must be a Comparable object
 */
@SuppressWarnings("serial")
public class AVLTree<E extends Comparable<E>>
	extends BinarySearchTreeWithRotate<E> {
	
	
	//Data fields
	/**
	 * Flag to indicate the height of the treee has increased
	 */
	private boolean increase;
	/**
	 * Flag to indicate whether an item is inserted
	 */
	private boolean addReturn;
	
	/**
	 * add starter method
	 * pre: the item to insert implements the Comparable interface
	 * @param item The item to be inserted.
	 * @return true if the object is inserted; false if the object already exists in the tree
	 * @throws ClassCastException if item is not Comparable
	 */
	@Override
	public boolean add(E item){
		increase = false;
		root = add((AVLNode<E>) root, item);
		return addReturn;
	}
	
	/**
	 * Recursive add method. Inserts the given object into the tree.
	 * post: addReturn is set to true if the item is inserted,
	 * 		 false if the item is already in the tree
	 * @param localRoot The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root of the subtree with the item inserted
	 */
	private AVLNode<E> add(AVLNode<E> localRoot, E item){
		// If the local root is null, return a new AVLNode with the item inserted
		if(localRoot == null){
			addReturn = true;
			increase = true;
			return new AVLNode<E>(item);
		}
		// Compare the item to the data in the current root. If equal, do not insert item 
		int compare = item.compareTo(localRoot.data);
		if(compare == 0){
			//Item is already in tree
			increase = false;
			addReturn = false;
			return localRoot;
		}
		// If the item is less than the local root's value, recursively call add on left subtree
		if(compare < 0){
			localRoot.left = add((AVLNode<E>) localRoot.left, item);
			if(increase){
				decrementBalance(localRoot);
				if(localRoot.balance < AVLNode.LEFT_HEAVY){
					increase = false;
					return rebalanceLeft(localRoot);
				}
			}
			return localRoot; // Re-balance not needed
		}
		else {
			localRoot.right = add((AVLNode<E>) localRoot.right, item);
			if(increase){
				incrementBalance(localRoot);
				if(localRoot.balance > AVLNode.RIGHT_HEAVY){
					increase = false;
					return rebalanceRight(localRoot);
				}
			}
			return localRoot; // Re-balance not needed
		}
	}
	
	/**
	 * Method to re-balance left
	 * pre: localRoot is the root of an AVL subtree that is critically left-heavy
	 * post: balance is restored
	 * @param localRoot Root of the AVL subtree that needs re-balancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot){
		//Obtain reference to left child
		AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
		//see whether left-right heavy
		if(leftChild.balance > AVLNode.BALANCED){
			//Obtain reference to left-right child.
			AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
			/*
			 * Adjust the balances to be their new values after the rotations are performed
			 */
			if(leftRightChild.balance < AVLNode.BALANCED){
				leftChild.balance = AVLNode.BALANCED;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.RIGHT_HEAVY;
			} else if (leftRightChild.balance > AVLNode.BALANCED){
				leftChild.balance = AVLNode.LEFT_HEAVY;
				leftRightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			} else {
				//Left-Right balanced case
				leftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			//Perform left rotation
			localRoot.left = rotateLeft(leftChild);
		} else {	
			//Left-left case
			leftChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		//now rotate the local root right
		return (AVLNode<E>) rotateRight(localRoot);
	}
	
	/**
	 * Method to re-balance right
	 * pre: localRoot is the root of an AVL subtree that is critically right-heavy
	 * post: balance is restored
	 * @param localRoot Root of the AVL subtree that needs re-balancing
	 * @return a new localRoot
	 */
	private AVLNode<E> rebalanceRight(AVLNode<E> localRoot){
		//Obtain reference to right child
		AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;
		//see whether right-left heavy
		if(rightChild.balance < AVLNode.BALANCED){
			//Obtain reference to right-left child.
			AVLNode<E> RightLeftChild = (AVLNode<E>) rightChild.left;
			/*
			 * Adjust the balances to be their new values after the rotations are performed
			 */
			if(RightLeftChild.balance < AVLNode.BALANCED){
				rightChild.balance = AVLNode.RIGHT_HEAVY;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			} else if (RightLeftChild.balance > AVLNode.BALANCED){
				rightChild.balance = AVLNode.BALANCED;
				RightLeftChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.LEFT_HEAVY;
			} else {
				//Right-Left balanced case
				rightChild.balance = AVLNode.BALANCED;
				localRoot.balance = AVLNode.BALANCED;
			}
			//Perform right rotation
			localRoot.right = rotateRight(rightChild);
		} else {	
			//Right-right case
			rightChild.balance = AVLNode.BALANCED;
			localRoot.balance = AVLNode.BALANCED;
		}
		//now rotate the local root left
		return (AVLNode<E>) rotateLeft(localRoot);
	}
	
	/**
	 * Decrement the balance of the given node
	 * @param node The node to decrement the balance of
	 */
	private void decrementBalance(AVLNode<E> node){
		node.balance--;
		if(node.balance == AVLNode.BALANCED){
			//If now balanced, overall height has not increased
			increase = false;
		}
	}
	
	/**
	 * Increment the balance of the given node
	 * @param node The node to increment the balance of
	 */
	private void incrementBalance(AVLNode<E> node){
		node.balance++;
		if(node.balance == AVLNode.BALANCED){
			//If now balanced, overall height has not increased
			increase = false;
		}
	}
	
	/**
	 * Class to represent an AVL Node. 
	 * It extends the BinaryTree.Node by adding the balance field
	 * @author Jacob / Koffman & Wolfgang
	 *
	 * @param <E> The data type of objects stored in the node. Must be a Comparable object.
	 */
	private static class AVLNode<E> extends Node<E> {

		//Data Fields
		/**
		 * Constant to indicate left-heavy
		 */
		public static final int LEFT_HEAVY = -1;
		/**
		 * Constant to indicate balanced
		 */
		public static final int BALANCED = 0;
		/**
		 * Constant to indicate right-heavy
		 */
		public static final int RIGHT_HEAVY = 1;
		/**
		 * balance is right subtree height - left subtree height
		 */
		private int balance;
		
		//Methods
		
		/**
		 * Construct a node with the given item as the data field
		 * @param data The data field
		 */
		public AVLNode(E data) {
			super(data);
			balance = BALANCED;
		}
		
		/**
		 * Return a string representation of this object.
		 * The balance value is appended to the contents
		 * @return String representation of this object
		 */
		public String toString(){
			return balance + ": " + super.toString();
		}
		
	}
}
