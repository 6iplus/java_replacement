import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class HashMapStr{
    private static final int DEFAULT_TABLE_SIZE=16;
    private static final float LIMIT_FACTOR=0.75f;
    private List<Entry> [] bucket;
    private int currentSize;
    public HashMapStr()
    {
        this(DEFAULT_TABLE_SIZE);
    }
    /**
     * Construct the hash table.
     * @param size approximate table size.
     */
    @SuppressWarnings("unchecked")
    public HashMapStr(int size){
        int capacity = 1;
        while (capacity < size)
             capacity <<= 1;
        bucket=new LinkedList[capacity];
        for(int i=0;i<bucket.length;i++)
            bucket[i]=new LinkedList<Entry>();
    }
     
    /**
     * Insert into the hash table. if the item is
     * already present, then do nothing.
     * @param x the item to insert.
     */
    public void put(String key, int val){
        List<Entry> EntryList = bucket[myhash(key)];
        
        Entry temp=new Entry(key,val);
        if(!EntryList.contains(temp)){
            EntryList.add(0,temp);
            //Rehash; 
            if(++currentSize>bucket.length*LIMIT_FACTOR)
                rehash();
        }
    }
    /**
     * Remove from the hash table.
     * @param key the item to remove.
     */
    public void remove(String key){
        List<Entry> EntryList=bucket[myhash(key)];
        Entry temp=new Entry(key,0);
        if(EntryList.contains(temp)){
            EntryList.remove(temp);
            currentSize--;
        }
    }
    /**
     * Find an item in the hash table.
     * @param key the item to search for.
     * @return true if key is found. 
     */
    public boolean containsKey(String key){
        List<Entry> whichList=bucket[myhash(key)];
        Entry temp=new Entry(key,0);
        return whichList.contains(temp);
    }
    public int get(String key){
    	List<Entry> whichList=bucket[myhash(key)];
        Entry temp=new Entry(key,0);
        for(Entry item:whichList){
        	if(temp.equals(item))
        		return temp.getValue();
        }
		return -1;
    }
    
    /**
     * Find an item value in the hash table
     * @param val whose presence in this map is to be tested
     * @return true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(String val){
    	for(int i=0;i<bucket.length;i++){
    		List<Entry> whichlist=bucket[i];
    		for(int j=0;j<whichlist.size();j++){
    			if(val.equals(whichlist.get(j).getValue())){
    				return true;
    			}
    		}
    	}
		return false;
    }
    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty(){
        for(int i=0;i<bucket.length;i++)
            bucket[i].clear();
        currentSize=0;
    }
    /**
     * return the words numbers in this map
     * @return the words numbers in this map
     */
    public int size(){
        return this.currentSize;
    }
    /**
     * return a array view of the values contained in this map
     * @return a array view of the values contained in this map
     */
    public int[] values(){
        int[] res=new int[this.currentSize];
        for(int i=0,j=0;i<bucket.length;i++){
            if(bucket[i].size()!=0){
                for(Entry item:bucket[i]){
                    res[j++]=item.getValue();
                }
            }
        }
        return res;
    }
    /**
     * return a array view of the mappings contained in this map.
     * @return a array view of the mappings contained in this map. 
     */
    public Entry[] entries(){
    	Entry[] res=new Entry[this.currentSize];
        for(int i=0,j=0;i<bucket.length;i++){
            if(bucket[i].size()!=0){
                for(Entry item:bucket[i]){
                    res[j++]=item;
                }
            }
        }
        return res;
    }
    /**
     * Doubles the size of the hash table and rehashes all the entries.
     */
    @SuppressWarnings("unchecked")
    private void rehash(){
        List<Entry>[] oldBucket=bucket;
        //Create new double-sized, empty table
        bucket =new LinkedList[2*bucket.length];
        for(int i=0;i<bucket.length;i++)
            bucket[i]=new LinkedList<Entry>();
        //Copy table over
        currentSize=0;
        for(int i=0;i<oldBucket.length;i++)
            for(Entry item:oldBucket[i])
                this.put(item.getKey(),item.getValue());
         
    }
    private int myhash(String key){
        int hashVal = hashCode(key);
        return hashVal&(bucket.length-1);
    }
    private static int hashCode(String value) {
        int hash = 0;
        if (hash == 0 && value.length() > 0) {
            char val[] = value.toCharArray();
            for (int i = 0; i < value.length(); i++) {
                hash = 31 * hash + val[i];
            }
        }
        return hash;
    }
    
    private static class Entry{
    	private String key;
        private int value;
        public Entry(String key,int value){this.key=key;this.value=value;}
        public boolean equals(Object rhs){
            return (rhs instanceof HashMapStr.Entry) && (key.equals(((Entry)rhs).key)); 
        }
        public int hashCode(){
            return HashMapStr.hashCode(key);
        }
        public int getValue()  {return value;}
        public String getKey() {return key;}
    }
    
    public static void main(String[] args) throws FileNotFoundException{
           
    	
    }
}