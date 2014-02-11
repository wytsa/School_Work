/**
 * 
 */
package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

//import edu.wou.cs260.SpellChecker.DLList.DLLNode;

/**
 * @author wytsa
 * 
 */
public class BSTreeSet<E extends Comparable<E>> implements Set<E>, CompareCount {

	public BSTreeSet(){	
		root = null;
		size = 0;
		compareCount = 0;
	}
	
	private int size;
	private Node root;
	private int compareCount;

	@Override
	public boolean add(E arg0) {
		// TODO Auto-generated method stub
		Node temp = new Node(arg0);
		if(temp.item == null){
			throw new NullPointerException();
		}
		else{
			root = add(root, arg0);
			return true;
		}
	}
	
	private Node add(Node subTree, E item){
		if(subTree == null){
			size++;
			return new Node(item);
		}
		else if(subTree.item.compareTo(item) < 0){// go left
			subTree.lChild = add(subTree.lChild, item);
		}
		else{// go right
			subTree.rChild = add(subTree.rChild, item);
		}
		return subTree;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		root = null;
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return has(root, (E) arg0);
		
	}
	
	private Boolean has(Node subTree, E item){
		if(subTree.item.compareTo(item) == 0){
			compareCount++;
			return true;
		}
		else if(subTree.item.compareTo(item) < 0){// go left
			compareCount++;
			has(subTree.lChild, item);
		}
		else if(subTree.item.compareTo(item) > 0){// go right
			compareCount++;
			has(subTree.rChild, item);
		}
		return null;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		if(root == null){
			return true;
		}
		else{
			return false;
		}
	}

	//@SuppressWarnings("unchecked")
	@Override
	public Iterator<E> iterator() {
		
		// TODO Auto-generated method stub
//		CREATE an new Queue<Node>
//		Enqueue (add) only the root node
//		WHILE ( the Queue is not empty) DO
//			Dequeue (remove) a node from the queue
//			With the node that was dequeued, if it has a left child, enqueue that child
//			With the node that was dequeued, if it has a right child, enqueue that child
//			Visit the data element from the dequeued node
//		end while
		return null;//new iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	class Node {
		// fields
		E item;
		int height;
		Node lChild;
		Node rChild;

		// methods
		// 3 constructors
		Node() {
			this(null, null, null);
		}

		Node(E item) {
			this(null, item, null);
		}

		Node(Node lChild, E item, Node rChild) {
			this.lChild = lChild;
			this.item = item;
			this.rChild = rChild;
			height = 0;
		}
	}

	@Override
	public int getLastCompareCount() {
		// TODO Auto-generated method stub
		return compareCount;
	}

}
