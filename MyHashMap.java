import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
public class MyHashMap<K, V> {

	static final int DEFAULT_INITIAL_CAPACITY = 16;
	//The maximum capacity, used if a higher value is implicitly specified by either of the constructors with arguments. MUST be a power of two <= 1<<30.
	static final int MAXIMUM_CAPACITY = 1 << 30;
	//The load factor used when none specified in constructor.
	static final float DEFAULT_LOAD_FACTOR = 0.75f;
	//The table, resized as necessary. Length MUST Always be a power of two.
	transient Entry[] table;
	//The number of key-value mappings contained in this map.
	transient int size;
	//The next size value at which to resize (capacity * load factor).
	int threshold;

	final float loadFactor;
	transient volatile int modCount;


	//hook for subclasses, check it out in official implementation
	void init(){

	}


	 public MyHashMap(int initialCapacity) {
		 this(initialCapacity, DEFAULT_LOAD_FACTOR);
	 }
	 public MyHashMap(int initialCapacity, float loadFactor) {
		 if (initialCapacity < 0)
			 throw new IllegalArgumentException("Illegal initial capacity: " +
					 initialCapacity);
		 if (initialCapacity > MAXIMUM_CAPACITY)
			 initialCapacity = MAXIMUM_CAPACITY;
		 if (loadFactor <= 0 || Float.isNaN(loadFactor))
			 throw new IllegalArgumentException("Illegal load factor: " +
					 loadFactor);
		// Find a power of 2 >= initialCapacity
		 int capacity = 1;
		 while (capacity < initialCapacity)
			  capacity <<= 1;

		 this.loadFactor = loadFactor;
		 threshold = (int)(capacity * loadFactor);
		 table = new Entry[capacity];
		 init();
	 }

	public MyHashMap(){
		this.loadFactor = DEFAULT_LOAD_FACTOR;
		this.threshold = (int)(DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
		table = new Entry[DEFAULT_INITIAL_CAPACITY];
		init();
	}

	//I don't know this func, find is at official implementation
	static int indexFor(int h, int length) {
		return h & (length-1);
	}

	public V get(Object key){
		if(key == null)
			return getForNullKey();
		int hash = hash(key.hashCode());
		for(Entry<K, V> e= table[indexFor(hash, table.length)];
				e != null;
				e=e.next){
					if(e.hash == hash && ( e.key == key  || key.equals(e.key)) )
						return e.value;
				}
		return null;
	}


	private V getForNullKey(){
		for(Entry<K, V> e = table[0]; e!= null; e = e.next){
			if(e.key == null)
				return e.value;
		}
		return null;
	}

	public boolean containsKey(Object key){
		return getEntry(key) != null;
	}

	final  Entry<K, V> getEntry(Object key){
		int hash = (key ==null) ? 0 : hash(key.hashCode());
		for(Entry<K, V> e= table[indexFor(hash, table.length)];
				e != null;
				e=e.next){
					if(e.hash == hash && ( e.key == key  || key.equals(e.key)) )
						return e;
				}
		return null;
	}

	public V put(K key, V value){
		if(key == null)
			putForNullKey(value);
		int hash = hash(key.hashCode());
		int i = indexFor(hash, table.length);
		for(Entry<K, V> e = table[i]; e!=null; e=e.next){
			if(e.hash == hash && (e.key == key || key.equals(e.key))){
				V oldValue = e.value;
				e.value = value;
				e.recordAccess(this);
				return oldValue;
			}
		}

		modCount++;
		addEntry(hash, key, value, i);
		return null;
	}

	private V putForNullKey(V value){
		for(Entry<K, V> e=table[0]; e!=null; e=e.next){
			if(e.key == null){
				V oldValue = e.value;
				e.value = value;
				e.recordAccess(this);
				return oldValue;
			}
		}
		return null;
	}

	void addEntry(int hash, K key, V value, int bucketIndex){
		Entry<K, V> e = table[bucketIndex];
		table[bucketIndex] = new Entry<K, V>(hash, key, value, e);
		if(size++>= threshold){
			resize(2*table.length);
		}
	}

	void resize(int newCapacity){
		Entry[] oldTable = table;
		int oldCapacity = oldTable.length;
		if(oldCapacity == MAXIMUM_CAPACITY){
			threshold = Integer.MAX_VALUE;
			return ;
		}
		Entry[] newTable = new Entry[newCapacity];
		transfer(newTable);
		table = newTable;
		threshold = (int)(newCapacity * loadFactor);
	}

	void transfer(Entry[] newTable){
		Entry[] src = table;
		int newCapacity = newTable.length;
		for(int j =0; j<src.length; j++){
			Entry<K, V> e = src[j];
			if(e != null){
				src[j] = null;
				do{
					Entry<K, V> next = e.next;
					int i = indexFor(e.hash, newCapacity);
					e.next = newTable[i];
					newTable[i] = e;
					e = next;
				}while(e!=null);
			}
		}
	}
//putForCreate readObject
//	void createEntry(int hash, K key, V value, int bucketIndex){
//		Entry<K, V> e = table[bucketIndex];
//		table[bucketIndex] =  new Entry<K, V>(hash, key, value, e);
//		size++;
//	}

	static int  hash(int h) {
		 h ^= (h >>> 20) ^ (h >>> 12);
		        return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public int size(){
		return size;
	}

	public boolean isEmpty(){
		return size == 0;
	}
	public static int[] histogram = new int[12];
	static class Entry<K,V> implements Map.Entry<K,V> {

		final K key;
		V value;
		Entry<K, V> next;
		final int hash;

		Entry(int h , K k, V v, Entry<K, V> n){
			value = v;
			next = n;
			key = k;
			hash = h;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}

		public final boolean equals(Object o){
			if( !(o instanceof Map.Entry))
				return false;
			Map.Entry e = (Map.Entry)o;
			Object k1 = getKey();
			Object k2 = e.getKey();
			if(k1 == k2 || (k1!=null && k1.equals(k2))){
				Object v1 = getValue();
				Object v2 = e.getValue();
				if( v1 == v2 || (v1 != null && v1.equals(v2)) ){
					return true;
				}
			}
			return false;
		}

		public final int hashCode(){
			return (key ==null ? 0 : key.hashCode()) ^
					(value ==null ? 0: value.hashCode());
		}

		public final String toString(){
			return getKey() + "=" + getValue();
		}
		//This method is invoked whenever the value in an entry is overwritten by an invocation of put(k,v) for a key k that's already in the HashMap.
		void recordAccess(MyHashMap<K, V> m){

		}

		//This method is invoked whenever the entry is removed from the table.
		void recordRemoval(HashMap<K, V> m){

		}

	}

	 public static void main(String[] args) throws FileNotFoundException{
	    	FileInputStream fis = new FileInputStream("dict.txt");

	    	FileInputStream fis2 = new FileInputStream("dict.dat");
	    	Scanner scanner = new Scanner(fis);
	    	Scanner scanner2 = new Scanner(fis2);
	    	MyHashMap<String, Integer> map= new MyHashMap<>();
	    	while(scanner.hasNext()){
	    		String word = scanner.next().trim();
	    		map.put(word, 1);
	    	}

	    	while(scanner2.hasNext()){
	    		String word = scanner2.next().trim();
	    		System.out.println(word + "\t" + map.containsKey(word));
	    	}
	    	System.out.println();
	    	System.out.println("========histogram==========");
	    	int[] histogram = new int[12];
	    	for(MyHashMap.Entry entry :map.table){
	    		if(entry != null){
	    			int count = 0;
	    			for( ; entry != null ; entry = entry.next){
	    				count++;
	    			}
	    			if(count>=11)  count =11;
	    			histogram[count]++;
	    		}
	    	}
	    	for(int i=1 ; i<histogram.length ; i++){
	    		System.out.println(i +"\t"+ histogram[i]);
	    	}

	    	System.out.println(map.size());
	    	scanner.close();
	    	scanner2.close();
	    }
}
