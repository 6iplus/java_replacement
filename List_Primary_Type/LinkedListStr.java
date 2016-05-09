//hehe testing
public class LinkedListStr implements Iterable<String> {
	private int theSize;
	private int modCount=0;
	private Node beginMarker;
	private Node endMarker;
	
	private static class Node{
		public String key;
		public int value;
		public Node prev;
		public Node next;
		
		public Node(String d,int val,Node p, Node n){
			key=d; value=val;prev=p; next=n;
		}
		
	}
	public LinkedListStr(){
		clear();
	}
	
	// Change the size of this collection to zero
	public void clear(){
		beginMarker=new Node("",0,null,null);
		endMarker=new Node("",0,beginMarker,null);
		beginMarker.next=endMarker;
		theSize=0;
		modCount++;
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size()==0;
	}
	
	public boolean add(String x){
		add(size(),x);
		return true;
	}
	public void add(int idx,String x){
		addBefore(getNode(idx),x);
	}
	public String getKey(int idx){
		return getNode(idx).key;
	}
	public int getValue(int idx){
		return getNode(idx).value;
	}
	public String set(int idx, String newVal){
		Node p=getNode(idx);
		String oldVal=p.key;
		p.key=newVal;
		return oldVal;
	}
	public String remove(int idx){
		return remove(getNode(idx));
	}
	
	/**
	 * Adds an item to this collection, at specified position p.
	 * Items at or after that position are slid one position higher.
	 * 
	 * @param p Node to add before
	 * @param x any object
	 * @throws IndexOutOfBoundsException if idx is not between 0 and size().
	 */
	private void addBefore(Node p, String x){
		Node newNode = new Node (x,0,p.prev,p);
		newNode.prev.next= newNode;
		p.prev=newNode; 
		theSize++;
		modCount++;
		
	}
	
	/*
	 * Removes the object contained in Node p.
	 * @param p the Node containing the object.
	 * @return the item was removed from the collection.
	 */
	private String remove(Node p){
		p.next.prev = p.prev;
		p.prev.next=p.next;
		theSize--;
		modCount++;
		
		return p.key;
	}
	
	/*
	 * Gets the Node at position idx, which must range from 0 to size().
	 * @param idx index of node being obtained.
	 * @return internal node corresponding to idx.
	 * @throws IndexOutOfBoundsException if idx is not between 0 and size().
	 */
	private Node getNode(int idx){
		Node p;
		
		if(idx<0||idx>size())
			throw new IndexOutOfBoundsException();
		if(idx<size()/2){
			p=beginMarker.next;
			for(int i=0;i<idx;i++)
				p=p.next;
		}
		else// !!!!
		{
			p=endMarker;
			for(int i=size();i>idx;i--)
				p=p.prev;
		}
		
		return p;
	}
	
	public java.util.Iterator<String> iterator(){
		return new LinkedListStrIterator();
	}
	private class LinkedListStrIterator implements java.util.Iterator<String>{
		private Node current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current !=endMarker;
		}
		
		public String next(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			String nextItem = current.key;
			current = current.next;
			okToRemove=true;
			return nextItem;   
		}
		
		public void remove(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			LinkedListStr.this.remove(current.prev);
			okToRemove=false;
			expectedModCount++;
		}
	}
	
	public static void main(String [] args){
		LinkedListStr list =new LinkedListStr();
		
	}


}
