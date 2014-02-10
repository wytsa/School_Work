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
		else if(isEmpty()){
			addRootEmpty(temp);
			return true;
		}
		else{
			addSubRoot(temp);
			return true;
		}
	}

	private void addSubRoot(Node temp) {
		// TODO Auto-generated method stub
		
	}

	private void addRootEmpty(Node temp) {
		// TODO Auto-generated method stub
		temp.height = 0;
		root = temp;
		size = 1;		
	}
	

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		root = null;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
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
