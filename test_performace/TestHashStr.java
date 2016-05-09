import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class TestHashStr {
	static int count=0;
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static HashMap<String,Integer> BuildMapFromFile(HashMap<String,Integer> map,String filename) throws FileNotFoundException{
		count=0;
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.put(temp, count++);
		}
		if(sc!=null) sc.close();
		return map;
	}
	
	public static HashMapStr BuildMapFromFile(HashMapStr map,String filename) throws FileNotFoundException{
		count=0;
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
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
	public static void TestContainsKey(HashMap<String,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.containsKey(temp);
		}
		if(sc!=null) sc.close();
	}
	/**
	 * test containskey method
	 * @param map
	 * @param filename
	 * @throws FileNotFoundException
	 */
	public static void TestContainsKey(HashMapStr map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.containsKey(temp);
		}
		if(sc!=null) sc.close();
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(HashMap<String,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.get(temp);
		}
		if(sc!=null) sc.close();
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(HashMapStr map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.get(temp);
		}
		if(sc!=null) sc.close();
	}
	
	/**
	 * test remove method 
	 * @param arr
	 * @throws FileNotFoundException 
	 */
	public static void TestRemove(HashMap<String,Integer> map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
            map.remove(temp);
		}
		if(sc!=null) sc.close();
	}
	/**
	 * test remove method 
	 * @param arr
	 * @throws FileNotFoundException 
	 */
	public static void TestRemove(HashMapStr map,String filename) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextLine()){
			String temp=sc.nextLine();
            while(temp.trim().isEmpty()){
                temp=sc.nextLine();
            }
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
		
		System.out.println("******Test System HashMap******");
		//test add function
		start = System.currentTimeMillis();
		HashMap<String,Integer> sysmap = BuildMapFromFile(new HashMap<String,Integer>(), pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("size "+sysmap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();
		TestContainsKey(sysmap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(sysmap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(sysmap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove "+time);
		System.out.println("size "+sysmap.size());
		
		
		System.out.println("******Test MyHashMap******");
		//test add function
		start = System.currentTimeMillis();
		HashMapStr mymap = BuildMapFromFile(new HashMapStr(),pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("size "+mymap.size());
		
		//test containsKey method
		start = System.currentTimeMillis();
		TestContainsKey(sysmap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("contaisKey method time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(mymap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(mymap,pth10);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove time "+time);
		System.out.println("size "+mymap.size());
		
	}
}
