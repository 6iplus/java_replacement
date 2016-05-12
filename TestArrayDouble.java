import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TestArrayDouble {
	
	/**
	 * test add function performance
	 * @param arr array to be test
	 * @param filename the filename of test date 
	 * @return array
	 * @throws FileNotFoundException
	 */
	public static ArrayListDouble BuildArrayFromFile(ArrayListDouble arr, ArrayList<Double> list){
		
		for(Double i:list){
			arr.add(i);
		}
		return arr;
	}
	
	public static ArrayList<Double> BuildArrayFromFile(ArrayList<Double> arr, ArrayList<Double> list) {
		
		for(Double i:list){
			arr.add(i);
		}
		return arr;
	}
	
	/*
	 * test get function performace
	 */
	public static void TestGet(ArrayList<Double> arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(len));
		}
	}
	public static void TestGet(ArrayListDouble arr){
		int len=arr.size();
		Random rb=new Random(1);//use same seed
		for(int i=0;i<len;i++){
			arr.get(rb.nextInt(len));
		}
	}
	/**
	 * test removie method 
	 * @param arr
	 */
	public static void TestRemove(ArrayList<Double> arr){
		int len=arr.size();
		for(int i=0;i<len;i++){
			arr.remove(arr.size()-1);
		}
		//System.out.println("list size: "+arr.size());
	}
	public static void TestRemove(ArrayListDouble arr){
		int len=arr.size();
		for(int i=0;i<len;i++){
			arr.remove(arr.size()-1);
		}
		//System.out.println("list size: "+arr.size());
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
		
		pth2 = "500k_Double.txt";
		
		ArrayList<Double> listDouble= new ArrayList<Double>();
		
		Scanner sc=new Scanner(new FileReader(pth2));
		while(sc.hasNextDouble()){
			double temp=sc.nextDouble();
			listDouble.add(temp);
		}
		if(sc!=null) sc.close();
		
		double start, end, time;
		System.out.println("-------Test ArryList for double------");
		System.out.println("******Test System ArryList******");
		//test add function
		start = System.currentTimeMillis();
		ArrayList<Double> arrlst = BuildArrayFromFile(new ArrayList<Double>(), listDouble);
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
		ArrayListDouble marlst = BuildArrayFromFile(new ArrayListDouble(),listDouble);
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
