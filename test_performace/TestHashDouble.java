import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class TestHashDouble {
	static int count=0;
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static HashMap<Double,Integer> BuildMapFromFile(HashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		count=0;
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
        
            map.put(temp, count++);
		}
		if(sc!=null) sc.close();
		return map;
	}
	
	public static HashMapDouble BuildMapFromFile(HashMapDouble map,String filename) throws FileNotFoundException{
		count=0;
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.put(temp, count++);
		}
		if(sc!=null) sc.close();
		return map;
	}
	public static MyHashMap<Double,Integer> BuildMapFromFile(MyHashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		count=0;
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.put(temp, count++);
		}
		if(sc!=null) sc.close();
		return map;
	}
	/**
	 * test containskey method
	 * @param map
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public static void TestContainsKey(HashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.put(temp, count++);
            map.containsKey(temp);
		}
		if(sc!=null) sc.close();
	}
	public static void TestContainsKey(HashMapDouble map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.containsKey(temp);
		}
		if(sc!=null) sc.close();
	}
	public static void TestContainsKey(MyHashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.containsKey(temp);
		}
		if(sc!=null) sc.close();
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(HashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.get(temp);
		}
		if(sc!=null) sc.close();
	}
	
	public static void TestGet(HashMapDouble map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.get(temp);
		}
		if(sc!=null) sc.close();
	}
	public static void TestGet(MyHashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.get(temp);
		}
		if(sc!=null) sc.close();
	}
	
	/**
	 * test remove method 
	 * @param arr
	 * @throws FileNotFoundException 
	 */
	public static void TestRemove(HashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.remove(temp);
		}
		if(sc!=null) sc.close();
	}
	public static void TestRemove(HashMapDouble map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.remove(temp);
		}
		if(sc!=null) sc.close();
	}
	public static void TestRemove(MyHashMap<Double,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
            map.remove(temp);
		}
		if(sc!=null) sc.close();
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
		
		double start, end, time;
		System.out.println("-------Test HashMap for double-------");
		System.out.println("******Test System HashMap******");
		//test add function
		start = System.currentTimeMillis();
		HashMap<Double,Integer> sysmap = BuildMapFromFile(new HashMap<Double,Integer>(), pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("map size: "+sysmap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();      
		TestContainsKey(sysmap,pth6);          
		end = System.currentTimeMillis();         
		time = end - start;    
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(sysmap,pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("get method time "+time);
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(sysmap,pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove "+time);
		System.out.println("map size: "+sysmap.size());
		
		
		
		System.out.println("******Test MyHashMap******");
		//test add function
		start = System.currentTimeMillis();
		MyHashMap mymap = BuildMapFromFile(new MyHashMap(),pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("map size: "+mymap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();
		TestContainsKey(mymap,pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(mymap,pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("get method time "+time);
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(mymap,pth6);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove time "+time);
		System.out.println("map size: "+mymap.size());
		
	}
}

