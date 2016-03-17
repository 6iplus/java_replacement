
package CPE593;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
	private int theSize;
	private int modCount=0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
	private static class Node<AnyType>{
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
		
		public Node(AnyType d, Node<AnyType> p, Node<AnyType>n){
			data=d; prev=p; next=n;
		}
	}
	public MyLinkedList(){
		clear();
	}
	
	// Change the size of this collection to zero
	public void clear(){
		beginMarker=new Node<AnyType>(null,null,null);
		endMarker=new Node<AnyType>(null,beginMarker,null);
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
	
	public boolean add(AnyType x){
		add(size(),x);
		return true;
	}
	public void add(int idx,AnyType x){
		addBefore(getNode(idx),x);
	}
	public AnyType get(int idx){
		return getNode(idx).data;
	}
	public AnyType set(int idx, AnyType newVal){
		Node<AnyType> p=getNode(idx);
		AnyType oldVal=p.data;
		p.data=newVal;
		return oldVal;
	}
	public AnyType remove(int idx){
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
	private void addBefore(Node<AnyType> p, AnyType x){
		Node<AnyType> newNode = new Node<AnyType> (x,p.prev,p);
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
	private AnyType remove(Node<AnyType> p){
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
	private Node<AnyType> getNode(int idx){
		Node<AnyType> p;
		
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
	
	public java.util.Iterator<AnyType> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{
		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		public boolean hasNext(){
			return current !=endMarker;
		}
		
		public AnyType next(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!hasNext())
				throw new java.util.NoSuchElementException();
			
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove=true;
			return nextItem;
		}
		
		public void remove(){
			if(modCount!=expectedModCount)
				throw new java.util.ConcurrentModificationException();
			if(!okToRemove)
				throw new IllegalStateException();
			MyLinkedList.this.remove(current.prev);
			okToRemove=false;
			expectedModCount++;
		}
	}
	
	public static void main(String [] args){
		MyLinkedList<String> list =new MyLinkedList<String>();
		for(int i=0;i<25;i++){
			list.add("a");
		}
		list.add("zzzzz");
		
		System.out.println(list.size());
		System.out.println(list.get(26));
	}

}
