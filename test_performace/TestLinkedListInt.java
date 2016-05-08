import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class TestLinkedListInt {
	
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static LinkedList<Integer> BuildArrayFromFile(LinkedList<Integer> arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		if(sc!=null) sc.close();
		return arr;
		
	}
	
	public static LinkedListInt BuildArrayFromFile(LinkedListInt arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		if(sc!=null) sc.close();
		return arr;
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(LinkedList<Integer> arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(1000));//test get on the front
			int idx=len-1000+rb.nextInt(1000);
			arr.get(idx); //test get on the end
		}
	}
	public static void TestGet(LinkedListInt arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(1000));//test get on the front
			int idx=len-1000+rb.nextInt(1000);
			arr.get(idx); //test get on the end
		}
	}
	/**
	 * test removie method 
	 * @param arr
	 */
	public static void TestRemove(LinkedList<Integer> arr){
		int len=arr.size();
		for(int i=0;i<len/2;i++){
			arr.remove(arr.size()-1);//remove from end
			arr.remove(0);//remove from front
		}
	}
	public static void TestRemove(LinkedListInt arr){
		int len=arr.size();
		for(int i=0;i<len/2;i++){
			arr.remove(arr.size()-1);//remove from end
			arr.remove(0);//remove from front
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
		double start, end, time;
		
		System.out.println("******Test System LinkedList******”);
		//test add function
		start = System.currentTimeMillis();
		LinkedList<Integer> arrlst = BuildArrayFromFile(new LinkedList<Integer>(), pth2);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(arrlst);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(arrlst);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove "+time);
		
		
		
		System.out.println("******Test MyLinkedList******”);
		//test add function
		start = System.currentTimeMillis();
		LinkedListInt marlst = BuildArrayFromFile(new LinkedListInt(),pth2);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		
		//test get function
		start = System.currentTimeMillis();
		TestGet(marlst);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		
		//test remove function
		start = System.currentTimeMillis();
		TestRemove(marlst);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove time "+time);
		
		
		
	}
}
