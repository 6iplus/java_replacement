import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TestHashDouble {
	static int count=0;
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static MyHashMap<Double,Integer> BuildMap(MyHashMap<Double,Integer> map,HashMap<Double,Integer> memorymap){
		count=0;
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.put(key, count++);
		}
		return map;
	}public static HashMap<Double,Integer> BuildMap(HashMap<Double,Integer> map,HashMap<Double,Integer> memorymap){
		count=0;
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.put(key, count++);
		}
		return map;
	}
	
	public static HashMapDouble BuildMap(HashMapDouble map,HashMap<Double,Integer> memorymap){
		count=0;
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
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
	public static void TestContainsKey(HashMap<Double,Integer> map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.containsKey(key);
		}
		
	}
	public static void TestContainsKey(HashMapDouble map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.containsKey(key);
		}
	}
	public static void TestContainsKey(MyHashMap map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.containsKey(key);
		}
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(HashMap<Double,Integer> map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.get(key);
		}
	}
	public static void TestGet(HashMapDouble map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.get(key);
		}
	}
	public static void TestGet(MyHashMap map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.get(key);
		}
	}
	
	/**
	 * test remove method 
	 * @param arr
	 * @throws FileNotFoundException 
	 */
	public static void TestRemove(HashMap<Double,Integer> map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.get(key);
		}
	}
	public static void TestRemove(HashMapDouble map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
			map.remove(key);
		}
	}
	public static void TestRemove(MyHashMap map,HashMap<Double,Integer> memorymap){
		Set<Double> set= memorymap.keySet();
		for(Double key:set){
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
		
		HashMap<Double,Integer> map= new HashMap<>();
		
		Scanner sc=new Scanner(new FileReader(pth2));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
			map.put(temp,0);
		}
		if(sc!=null) sc.close();
		
		double start, end, time;
		System.out.println("-------Test HashMap for double-------");
		System.out.println("******Test System HashMap******");
		//test add function
		start = System.currentTimeMillis();
		HashMap<Double,Integer> sysmap = BuildMap(new HashMap<Double,Integer>(), map);
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
