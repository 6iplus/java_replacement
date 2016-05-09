package project593;

import java.util.Scanner; 

public class ArrayListInt implements Iterable<Integer> {
	private static final int DEFAULT_CAPACITY=8;
	private int theSize;
	private int[] theItems;
	/**
	 * constructor
	 */
	public ArrayListInt(){
		clear();
	}
	/**
	 * Removes all of the elements from this list. The list will be empty after this call returns.
	 */
	public void clear(){
		theSize =0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	/**
	 * 
	 * @return the number of elements it contains.
	 */
	public int size(){
		return theSize;
	}
	/**
	 * 
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty(){
		return size()==0;
	}
	/**
	 * Trims the capacity of this ArrayList instance to be the list's current size. 
	 * An application can use this operation to minimize the storage of an ArrayList instance.
	 */
	public void trimToSize()
	{
		ensureCapacity(size());
	}
	/**
	 * 
	 * @param idx the index of given element in array
	 * @return	the value for given index
	 */
	public int get(int idx){
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		return theItems[idx];
	}
	/**
	 * 
	 * @param idx the index of given element in array
	 * @param newVal the reset value
	 * @return the old value
	 */
	public int set(int idx, int newVal)
	{
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		int old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	/**
	 * 
	 * @param newCapacity minCapacity the desired minimum capacity
	 */
	public void ensureCapacity(int newCapacity){
		if(newCapacity<size())//if it less than size(),it will loss date
			return;
		int []old =theItems;
		theItems=new int[newCapacity];
		for(int i=0;i<size();i++)
			theItems[i]=old[i];
	}
	/**
	 * 
	 * @param x element to be appended to this list
	 * @return	true if add successfully
	 */
	public boolean add(int x){
		add(size(),x);
		return true;
	}
	/**
	 * 
	 * @param idx index at which the specified element is to be inserted
	 * @param x element to be inserted
	 */
	public void add(int idx,int x){
		if(theItems.length==size())
			ensureCapacity(size()*2+1);
		for(int i=theSize;i>idx;i--)
			theItems[i]=theItems[i-1];
		theItems[idx]=x;
		
		theSize++;
	}
	/**
	 * 
	 * @param idx the index of the element to be removed
	 * @return	the element that was removed from the list
	 */
	public int remove(int idx){
		int removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			theItems[i]=theItems[i+1];
		
		theSize--;
		return removedItem;
	} 
	/**
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public java.util.Iterator<Integer> iterator(){
		return new ArrayListIterator();
	}
	
	//An iterator for MyArrayList
	private class ArrayListIterator implements java.util.Iterator<Integer>{
		
		private int current =0;
		
		@Override
		public boolean hasNext() {
			
			return current<size();
		}
		
		@Override
		public Integer next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			return theItems[current++];
		}
		
		public void remove(){
			ArrayListInt.this.remove(--current);
		}
	}
	
	public static void main(String[] args) {
	
	}
}


