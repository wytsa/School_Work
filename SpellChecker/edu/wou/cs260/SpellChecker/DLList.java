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
		//TODO
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
			addHeadEmpty(temp);
			size = 1;
			return true;
		}
		else{
			addTail(temp);
			size++;
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
			addHeadEmpty(temp);
			size = 1;
		}
		else if(arg0 == 0){
			addHead(temp);
			size++;
		}
		else if(arg0 == size){
			addTail(temp);
			size ++;
		}
		else{
			DLLNode current = getNode(arg0);
			addGeneral(temp, current);
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
			if(arg0.equals(temp.data)){
				remove(i);
				return true;
			}
			else{
				temp = temp.next;
				i++;
			}
		}
		return false;
		// TODO Auto-generated method stub
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
	
/*	private void deleteNode(Object arg0) {
		// TODO Auto-generated method stub
		if(arg0.equals(null)){
			throw new NullPointerException();
		}
		// o==null ? get(i)==null : o.equals(get(i))
		DLLNode temp = new DLLNode();
		if(temp == null){
			
		}
		
	}*/
/*	private DLLNode getNode(Object arg0) {
		
		DLLNode temp = new DLLNode();
		for(int i = 0; i <= size(); i++){
			if(getNode(i).equals(temp)){
				return temp;
			}
			else if(i == size()){
				return null;
			}
			else{
				return null;
			}
		}
		return temp;
		
	}*/
	
 	private DLLNode deleteNode(int arg0){
		DLLNode temp = getNode(arg0);
		if(temp == null){
			throw new NullPointerException();
		}
		else if(temp.prev == null){
			if(size == 1){
				clear();
				size++;
			}
			else{
				deleteHead(temp);
			}			
			return null;
		}
		else if(temp.next == null){
			deleteTail(temp);
			return null;
		}
		else{
			deleteGeneral(temp);
			return null;
		}
	}
 	
 	// new add methods
 	
 	private void addHeadEmpty(DLLNode temp){
 		head = temp;
 		tail = temp;
 	}
 	
 	private void addHead(DLLNode temp){
 		temp.next = head;
 		head.prev = temp;
 		head = temp;
 	}
 	
 	private void addTail(DLLNode temp){
 		temp.prev = tail;
 		tail.next = temp;
 		tail = temp;
 	}
 	
 	private void addGeneral(DLLNode temp, DLLNode current){
 		temp.next = current;
 		temp.prev = current.prev;
 		temp.prev.next = temp;
 		temp.next.prev = temp;
 		
 	}
 	
 	// new delete methods
 	
 	private void deleteHead(DLLNode temp){
 		head = temp.next;
 		head.prev = null;
 	}
 	
 	private void deleteTail(DLLNode temp){
 		tail = temp.prev;
		tail.next = null;
 	}
 	
 	private void deleteGeneral(DLLNode temp){
 		temp.prev.next = temp.next;
 		temp.next.prev = temp.prev;
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
 		int size = 0;

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
