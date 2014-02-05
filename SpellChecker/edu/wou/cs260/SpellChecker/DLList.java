/**
 * 
 */
package edu.wou.cs260.SpellChecker;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.NoSuchElementException;

/**
 * @author sam wytoski
 *
 */
public class DLList<E>  implements List<E>, Queue<E>, CompareCount{
	
	public DLList(){
	}
	
	private int size;
	private DLLNode head;
	private DLLNode tail;
	private int compareCount;

	@Override
	public boolean add(E arg0) {
		DLLNode temp = new DLLNode(arg0);
		if(temp.data == null){
			throw new NullPointerException();
		}
		else if(isEmpty()){
			head = temp;
			tail = temp;
			size = 1;
			return true;
		}
		else{
			temp.prev = tail;
			temp.prev.next = temp;
			tail = temp;
			size = size + 1;
			return true;
		}
	}

	@Override
	public void add(int arg0, E arg1) {
		DLLNode temp = new DLLNode(arg1);
		if(temp.data == null){
			throw new NullPointerException();
		}
		else if(arg0 < 0 || arg0 > size){
			throw new IndexOutOfBoundsException();
		}
		else if(isEmpty()){
			head = temp;
			tail = temp;
			size = 1;
		}
		else if(arg0 == 0){
			temp.next = head;
			temp.next.prev = temp;
			head = temp;
			size++;
		}
		else if(arg0 == size){
			temp.prev = tail;
			tail.next = temp;
			tail = temp;
			size ++;
		}
		else{
			DLLNode spot = getNode(arg0);
			spot.prev.next = temp;
			temp.prev = spot.prev;
			temp.next = spot;
			spot.prev = temp;
			size ++;
		}
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public boolean contains(Object arg0) {
		compareCount = 0;
		DLLNode temp = head;
		if(arg0.equals(null)){			
			throw new NullPointerException();
		}
		compareCount++;
		int i = 0;
		while(i < size){
			if(temp.getData() == arg0){
				return true;
			}
			else{
				temp = temp.next;
			}
			compareCount++;
			i++;
		}		
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public E get(int arg0) {
		E temp = null;
		if(arg0 < 0 || arg0 >= size){
			throw new IndexOutOfBoundsException();
		}
		else if(arg0 == 0){
			temp = head.data;
		}
		else if(arg0 == size){
			temp = tail.data;
		}
		else{
			temp = getNode(arg0).data;
		}
		return temp;
	}

	@Override
	public int indexOf(Object arg0) {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		if(head == null){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new DLLIterator();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		DLLNode temp = head;
		if(arg0.equals(null)){
			throw new NullPointerException();
		}
		int i = 0;
		while(i < size){
			temp = temp.next;
			i++;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		if(arg0 < 0 || arg0 >= size){
			throw new IndexOutOfBoundsException();
		}
		else{
			E temp = getNode(arg0).data;
			deleteNode(arg0);
			size--;
			return temp;
		}
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		return null;
	}

	@Override
	public int size() {
		// returns the size of the list
			return size;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return null;
	}
	
	@Override
	public int getLastCompareCount() {
		
		return compareCount;
	}

	@Override
	public E element() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		return head.data;
	}

	@Override
	public boolean offer(E arg0) {
		add(size, arg0);
		//TODO
		return false;
	}

	@Override
	public E peek() {
		if(isEmpty()){
			return null;
		}
		else{
			return head.data;
		}		
	}

	@Override
	public E poll() {
		if(isEmpty()){
			return null;
		}
		else{
			E temp = (E) head.data;
			deleteNode(0);
			return temp;
		}
	}
	
	@Override
	public E remove() {
		if(isEmpty()){
			throw new NoSuchElementException();
		}
		else{
			DLLNode temp = getNode(0);
			deleteNode(0);
			return temp.data;
		}
	}
	
	private DLLNode getNode(int arg0) {
		DLLNode temp = new DLLNode();
		if(arg0 < 0 || arg0 > size){
			throw new IndexOutOfBoundsException();
		}
		else if(arg0 == 0){
			return head;
		}
		else if(arg0 == size){
			return tail;
		}
		else
		{
			for(int i = 0; i <= arg0; i++){
				if(i == 0){
					temp = head;
				}
				else{
				temp = temp.next;
				}
			}
			return temp;
		}
	}
	
 	private DLLNode deleteNode(int arg0){
		DLLNode temp = getNode(arg0);
		if(temp == null){
			throw new NullPointerException();
		}
		else if(temp.prev == null){
			head = temp.next;
			head.prev = null;
			return null;
		}
		else if(temp.next == null){
			tail = temp.prev;
			tail.next = null;
			return null;
		}
		else{
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			return null;
		}
	}
	
	class DLLNode {
    
		DLLNode prev;    
		E data;    
		DLLNode next; 
		
		DLLNode() { 
			this(null, null, null);    
			} 
		
		DLLNode(E d) {
			this(null, d, null);
			}    
		
		DLLNode(DLLNode p, E d, DLLNode n) {        
			prev = p; 
			data = d; 
			next = n;    
			}
		public E getData(){
			return data;
		}
		
		public DLLNode getNext(){
			
			return next; 
		}
	}

	class DLLIterator implements Iterator<E> {
 		
 		DLLNode current = head;
 		
 		public boolean hasNext() {
 	    	if(current.next == null){
 	    		return false;
 	    	}
 	    	else
 	    	{ 	    		
 	    		return true;
 	    	}
 	    }

		public E next() {
 	    	if(current != null){
 	    		E result = current.data;
 	    		current = current.next;
 	    		return result;
 	    	}
 	    	else{
 	    		throw new NoSuchElementException();
 	    	}
 	    }

 	    public void remove() {
 	    	DLList.this.remove(current.prev.data);
 	    }
 	}
}
