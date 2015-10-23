
/**
 * Implementation of a Binary Search Tree
 * @author Jacob / Koffman & Wolfgang
 *
 * @param <E> The type of data in the tree. Must be a Comparable object.
 */
@SuppressWarnings("serial")
public class BinarySearchTree<E extends Comparable<E>>
								extends BinaryTree<E>
								implements SearchTree<E>{
	//Data Fields
	/**
	 * Return value from the public add method
	 */
	protected boolean addReturn;
	/** 
	 * Return value from the public delete method 
	 */
	protected E deleteReturn;
	
	//Methods
	
	public String toString(){
		return super.toString();
	}
	
	public String inorder(){
		StringBuilder sb = new StringBuilder();
		inOrderTraverse(root, sb);
		return sb.toString();
	}
	
	/**
	 * Perform an inorder traversal, returning the tree in ascending order (new lines separate characters)
	 * @param node The local root
	 * @param sb The string bufer to save the output
	 */
	private void inOrderTraverse(Node<E> node, StringBuilder sb){
		if(node == null){
			//do nothing
		} else {
			inOrderTraverse(node.left, sb);
			sb.append(node.toString());
			sb.append("\n");
			inOrderTraverse(node.right, sb);
		}
	}
	
	/**
	 * Starter method add
	 * pre: The object to be inserted must implement the Comparable interface
	 * @param item The item being inserted
	 * @return true if the object is inserted, false if the object already exists in the tree
	 */
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}

	/**
	 * Recursive add method
	 * post: The data field addReturn is set to true if the item is added to the tree, false if the item is already in the tree
	 * @param localRoot The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root that now contains the inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item){
		if(localRoot == null){
			//item is not in the tree - insert it
			addReturn = true;
			return new Node<E>(item);
		} else {
			int compare = item.compareTo(localRoot.data);
			if (compare == 0){
				//item is equal to localRoot.data
				addReturn = false;
				return localRoot;
			} else if (compare < 0){
				//item is less than localRoot.data
				localRoot.left = add(localRoot.left, item);
				return localRoot;
			} else {
				//item is greater than localRoot.data
				localRoot.right = add(localRoot.right, item);
				return localRoot;
			}
		}
	}
	
	public boolean contains(E target) {
		E result = find(target);
		return result == target;
	}

	/**
	 * Starter method find.
	 * pre: The target object must implement the Comparable interface.
	 * @param target The Comparable object being sought
	 * @return The object if found, otherwise null
	 */
	public E find(E target) {
		return find(root, target);
	}
	
	/**
	 * Recursive find method
	 * @param localRoot The local subtree's root
	 * @param target The object being sought
	 * @return The object, if found, otherwise null
	 */
	private E find(Node<E> localRoot, E target){
		if(localRoot == null)
			return null;
		//Compare target with the data field at the root
		int compResult = target.compareTo(localRoot.data);
		if(compResult == 0)
			return localRoot.data;
		else if (compResult < 0)
			return find(localRoot.left, target);
		else
			return find(localRoot.right, target);
	}

	/**
	 * Starter method delete
	 * post: The object is not in the tree
	 * @param target The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in the tree
	 * @throws ClassCast Exception if target does not implement Comparable
	 */
	public E delete(E target){
		root = delete(root, target);
		return deleteReturn;
	}
	
	/**
	 * Recursive delete method
	 * post: The item is not in the tree;
	 * 		 deleteReturn is equal to the deleted item
	 * 		 as it was stored in the tree or null
	 *		 if the item was not found
	 * @param localRoot The root of the current subtree
	 * @param item The item to be deleted
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> delete(Node<E> localRoot, E item){
		if(localRoot == null){
			//item is not in the tree
			deleteReturn = null;
			return localRoot;
		}
		//search for the item to delete
		int compResult = item.compareTo(localRoot.data);
		if(compResult < 0){
			//item is smaller than localRoot.data
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0){
			//item is larger than localRoot.data
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			//item is at local root
			deleteReturn = localRoot.data;
			if(localRoot.left == null){
				//if there is no left child, return right child which can also be null
				return localRoot.right;
			} else if (localRoot.right == null){
				//if there is no right child, return left child
				return localRoot.left;
			} else {
				//Node being deleted has 2 children, replace the data with inorder predecessor
				if(localRoot.left.right == null){
					//the left child has no right child. Replace the data with the data in the left child
					localRoot.data = localRoot.left.data;
					localRoot.left = localRoot.left.left; // replace the left child with its left child
					return localRoot;	
				} else {
					//Search for the inorder predecessor and replace deleted node's data with it
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}
	
	/**
	 * Find the node that is the inorder predecessor and replace it with its left child (if any)
	 * post: the inorder predecessor is removed from the tree
	 * warning: only call on nodes with known right children
	 * @param parent The parent of possible inorder predecessor
	 * @return The data in the inorder predecessor
	 */
	private E findLargestChild(Node<E> parent){
		//if the right child has no right child, it is the inorder predecessor
		if(parent.right.right == null){
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		} else {
			return findLargestChild(parent.right);
		}
	}
	
	public boolean remove(E target) {
		delete(target);
		return deleteReturn == target;
	}
	
	/**
	 * Starter method delete for if we want to replace with leftmost child of right subtree
	 * post: The object is not in the tree
	 * @param target The object to be deleted
	 * @return The object deleted from the tree or null if the object was not in the tree
	 * @throws ClassCast Exception if target does not implement Comparable
	 */
	public E deleteS(E target){
		root = deleteS(root, target);
		return deleteReturn;
	}
	
	/**
	 * Recursive delete method (replace with leftmost child of right subtree)
	 * post: The item is not in the tree;
	 * 		 deleteReturn is equal to the deleted item
	 * 		 as it was stored in the tree or null
	 *		 if the item was not found
	 * @param localRoot The root of the current subtree
	 * @param item The item to be deleted
	 * @return The modified local root that does not contain the item
	 */
	private Node<E> deleteS(Node<E> localRoot, E item){
		if(localRoot == null){
			//item is not in the tree
			deleteReturn = null;
			return localRoot;
		}
		//search for the item to delete
		int compResult = item.compareTo(localRoot.data);
		if(compResult < 0){
			//item is smaller than localRoot.data
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0){
			//item is larger than localRoot.data
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			//item is at local root
			deleteReturn = localRoot.data;
			if(localRoot.left == null){
				//if there is no left child, return right child which can also be null
				return localRoot.right;
			} else if (localRoot.right == null){
				//if there is no right child, return left child
				return localRoot.left;
			} else {
				//Node being deleted has 2 children, replace the data with inorder predecessor
				if(localRoot.right.left == null){
					//the right child has no left child. Replace the data with the data in the right child
					localRoot.data = localRoot.right.data;
					localRoot.right = localRoot.right.right; // replace the right child with its right child
					return localRoot;	
				} else {
					//Search for the inorder predecessor and replace deleted node's data with it
					localRoot.data = findSmallestChild(localRoot.right);
					return localRoot;
				}
			}
		}
	}
	
	/**
	 * Find the node that is the smallest child in a subtree
	 * warning: only use if it is known that the parent has a left child
	 * @param parent The root of the subtree
	 * @return The smallest child in the subtree
	 */
	private E findSmallestChild(Node<E> parent){
		//if the left child has no left child, it is the smallest item in the subtree
		if(parent.left.left == null){
			E returnValue = parent.left.data;
			parent.left = parent.left.right;
			return returnValue;
		} else {
			return findSmallestChild(parent.left);
		}
	}

}
