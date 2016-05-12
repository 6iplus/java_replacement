import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestHashStr {
	static int count=0;
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static MyHashMap<String,Integer> BuildMap(MyHashMap<String,Integer> map,HashMap<String,Integer> memorymap){
		count=0;
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.put(key, count++);
		}
		return map;
	}public static HashMap<String,Integer> BuildMap(HashMap<String,Integer> map,HashMap<String,Integer> memorymap){
		count=0;
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.put(key, count++);
		}
		return map;
	}
	
	public static HashMapStr BuildMap(HashMapStr map,HashMap<String,Integer> memorymap){
		count=0;
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.put(key, count++);
		}
		return map;
	}
	/**
	 * test containskey method
	 * @param map
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public static void TestContainsKey(HashMap<String,Integer> map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.containsKey(key);
		}
		
	}
	public static void TestContainsKey(HashMapStr map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.containsKey(key);
		}
	}
	public static void TestContainsKey(MyHashMap map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.containsKey(key);
		}
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(HashMap<String,Integer> map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.get(key);
		}
	}
	public static void TestGet(HashMapStr map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.get(key);
		}
	}
	public static void TestGet(MyHashMap map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.get(key);
		}
	}
	
	/**
	 * test remove method 
	 * @param arr
	 * @throws FileNotFoundException 
	 */
	public static void TestRemove(HashMap<String,Integer> map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.get(key);
		}
	}
	public static void TestRemove(HashMapStr map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.remove(key);
		}
	}
	public static void TestRemove(MyHashMap map,HashMap<String,Integer> memorymap){
		Set<String> set= memorymap.keySet();
		for(String key:set){
			map.remove(key);
		}
	}
	
	public static void main(String [] args) throws FileNotFoundException{
		String pth0 = "5k_Integer.txt";
		String pth1 = "50k_Integer.txt";
		String pth2 = "500k_Integer.txt";
		String pth3 = "5million_Integer.txt";
		String pth4 = "5k_Double.txt";
		String pth5 = "50k_Doubletxt";
		String pth6 = "500k_Double.txt";
		String pth7 = "5million_Double.txt";
		
		String pth8 = "words_50k.txt";
		String pth9 = "words_100k.txt";
		String pth10= "words_230k.txt";
		
		HashMap<String,Integer> map=new HashMap<>();
		count=0;
		Scanner sc=new Scanner(new FileReader(pth10));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.put(temp, count++);
		}
		if(sc!=null) sc.close();
		
		double start, end, time;
		System.out.println("-------Test HashMap for double-------");
		System.out.println("******Test System HashMap******");
		//test add function
		start = System.currentTimeMillis();
		HashMap<String,Integer> sysmap = BuildMap(new HashMap<String,Integer>(), map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("map size: "+sysmap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();      
		TestContainsKey(sysmap,map);          
		end = System.currentTimeMillis();         
		time = end - start;
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(sysmap,map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("get method time "+time);
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(sysmap,map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove "+time);
		System.out.println("map size: "+sysmap.size());
		
		
		
		System.out.println("******Test MyHashMap******");
		//test add function
		start = System.currentTimeMillis();
		MyHashMap mymap = BuildMap(new MyHashMap(),map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("map size: "+mymap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();
		TestContainsKey(mymap,map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(mymap,map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("get method time "+time);
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(mymap,map);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove time "+time);
		System.out.println("map size: "+mymap.size());
		
		
	}
}
