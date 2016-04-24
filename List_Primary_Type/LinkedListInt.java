package project593;


public class LinkedListInt implements Iterable<Integer> {
	private int theSize;
	private int modCount=0;
	private Node beginMarker;
	private Node endMarker;
	
	private static class Node{
		public int data;
		public Node prev;
		public Node next;
		
		public Node(int d, Node p, Node n){
			data=d; prev=p; next=n;
		}
	}
	public LinkedListInt(){
		clear();
	}
	
	// Change the size of this collection to zero
	public void clear(){
		beginMarker=new Node(0,null,null);
		endMarker=new Node(0,beginMarker,null);
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
	
	public boolean add(int x){
		add(size(),x);
		return true;
	}
	public void add(int idx,int x){
		addBefore(getNode(idx),x);
	}
	public int get(int idx){
		return getNode(idx).data;
	}
	public int set(int idx, int newVal){
		Node p=getNode(idx);
		int oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	public int remove(int idx){
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
	private void addBefore(Node p, int x){
		Node newNode = new Node (x,p.prev,p);
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
	private int remove(Node p){
		p.next.prev = p.prev;
		p.prev.next=p.next;
		theSize--;
		modCount++;
		
		return p.data;
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
	
	public java.util.Iterator<Integer> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<Integer>{
		private Node current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current !=endMarker;
		}
		
		public Integer next(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			int nextItem = current.data;
			current = current.next;
			okToRemove=true;
			return nextItem;
		}
		
		public void remove(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			LinkedListInt.this.remove(current.prev);
			okToRemove=false;
			expectedModCount++;
		}
	}
	
	public static void main(String [] args){
		LinkedListInt list =new LinkedListInt();
		
	}

}