package CPE593;

public class MyArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY=10;
	private int theSize;
	private AnyType[] theItems;
	/**
	 * constructor
	 */
	public MyArrayList(){
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
	public AnyType get(int idx){
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
	public AnyType set(int idx, AnyType newVal)
	{
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		AnyType old=theItems[idx];
		theItems[idx]=newVal;
		return old;
	}
	/**
	 * 
	 * @param newCapacity minCapacity the desired minimum capacity
	 */
	public void ensureCapacity(int newCapacity){
		if(newCapacity<size())
			return;
		AnyType []old =theItems;
		theItems=(AnyType [])new Object[newCapacity];
		for(int i=0;i<size();i++)
			theItems[i]=old[i];
	}
	/**
	 * 
	 * @param x element to be appended to this list
	 * @return	true if add successfully
	 */
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	/**
	 * 
	 * @param idx index at which the specified element is to be inserted
	 * @param x element to be inserted
	 */
	public void add(int idx,AnyType x){
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
	public AnyType remove(int idx){
		AnyType removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			theItems[i]=theItems[i+1];
		
		theSize--;
		return removedItem;
	} 
	/**
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public java.util.Iterator<AnyType> iterator(){
		return new ArrayListIterator();
	}
	
	//An iterator for MyArrayList
	private class ArrayListIterator implements java.util.Iterator<AnyType>{
		
		private int current =0;
		
		@Override
		public boolean hasNext() {
			
			return current<size();
		}
		
		@Override
		public AnyType next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			return theItems[current++];
		}
		
		public void remove(){
			MyArrayList.this.remove(--current);
		}
	}
	
	public static void main(String[] args) {
		
	}
}//end outer Class

