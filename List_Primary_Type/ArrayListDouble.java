
import java.util.Scanner; 

public class ArrayListDouble implements Iterable<Double> {
	private static final int DEFAULT_CAPACITY=8;
	private int theSize;
	private double[] theItems;
	/**
	 * constructor
	 */
	public ArrayListDouble(){
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
	public double get(int idx){
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
	public double set(int idx, double newVal)
	{
		if(idx<0||idx>=size())
			throw new ArrayIndexOutOfBoundsException();
		double old=theItems[idx];
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
		double []old =theItems;
		theItems=new double[newCapacity];
		for(int i=0;i<size();i++)
			theItems[i]=old[i];
	}
	/**
	 * 
	 * @param x element to be appended to this list
	 * @return	true if add successfully
	 */
	public boolean add(double x){
		add(size(),x);
		return true;
	}
	/**
	 * 
	 * @param idx index at which the specified element is to be inserted
	 * @param x element to be inserted
	 */
	public void add(int idx,double x){
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
	public double remove(int idx){
		double removedItem=theItems[idx];
		for(int i=idx;i<size()-1;i++)
			theItems[i]=theItems[i+1];
		
		theSize--;
		return removedItem;
	} 
	/**
	 * @return an iterator over the elements in this list in proper sequence
	 */
	public java.util.Iterator<Double> iterator(){
		return new ArrayListIterator();
	}
	
	//An iterator for MyArrayList
	private class ArrayListIterator implements java.util.Iterator<Double>{
		
		private int current =0;
		
		@Override
		public boolean hasNext() {
			
			return current<size();
		}
		@Override
		public Double next() {
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			return theItems[current++];
		}
		public void remove(){
			ArrayListDouble.this.remove(--current);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayListDouble arraylist = new ArrayListDouble();
		System.out.print("enter the numbers and enter any character to exit: ");
		while(sc.hasNextInt()){
			double number=sc.nextDouble();
			arraylist.add(number);
		}
		sc.close();
		System.out.println("---------result---------");
		for(int i=(arraylist.size()-1);i>=0;i--){
			System.out.print(arraylist.get(i)+" ");
		}
	}
}
