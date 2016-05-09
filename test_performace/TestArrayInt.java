import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestArrayInt {
	
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static ArrayListInt BuildArrayFromFile(ArrayListInt arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		//System.out.println("list size: "+arr.size());
		if(sc!=null) sc.close();
		return arr;
		
	}
	
	public static ArrayList<Integer> BuildArrayFromFile(ArrayList<Integer> arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		//System.out.println("list size: "+arr.size());
		if(sc!=null) sc.close();
		return arr;
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(ArrayList<Integer> arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(len));
		}
	}
	/*
	 * test get function performace
	 */
	public static void TestGet(ArrayListInt arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(len));
		}
	}
	/**
	 * test removie method 
	 * @param arr the arraylist to be test
	 */
	public static void TestRemove(ArrayList<Integer> arr){
		int len=arr.size();
		for(int i=0;i<len;i++){
			arr.remove(arr.size()-1);
		}
		
	}
	/**
	 * test removie method 
	 * @param arr the arraylist to be test
	 */
	public static void TestRemove(ArrayListInt arr){
		int len=arr.size();
		for(int i=0;i<len;i++){
			arr.remove(arr.size()-1);
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
		
		System.out.println("******Test System ArryList******");
		//test add function
		start = System.currentTimeMillis();
		ArrayList<Integer> arrlst = BuildArrayFromFile(new ArrayList<Integer>(), pth2);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("list size: "+arrlst.size());
		
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
		System.out.println("list size: "+arrlst.size());
		
		System.out.println("******Test MyArryList******");
		//test add function
		start = System.currentTimeMillis();
		ArrayListInt marlst = BuildArrayFromFile(new ArrayListInt(),pth2);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		System.out.println("list size: "+marlst.size());
		
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
		System.out.println("list size: "+marlst.size());
		
		
	}
}
