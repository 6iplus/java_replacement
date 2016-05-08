import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class TestArrayInt {
	
	
	public static ArrayListInt BuildArrayFromFile(ArrayListInt arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		if(sc!=null) sc.close();
		return arr;
		
	}
	
	public static ArrayList<Integer> BuildArrayFromFile(ArrayList<Integer> arr,String filename) throws FileNotFoundException{
		
		Scanner sc=new Scanner(new FileReader(filename));
		while(sc.hasNextInt()){
			int temp=sc.nextInt();
			arr.add(temp);
		}
		if(sc!=null) sc.close();
		return arr;
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
		
		//test get function
		start = System.currentTimeMillis();
		arrlst.get(100);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		//test remove function
		start = System.currentTimeMillis();
		arrlst.remove(100);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove "+time);
		
		System.out.println("******Test MyArryList******");
		//test add function
		start = System.currentTimeMillis();
		ArrayListInt marlst = BuildArrayFromFile(new ArrayListInt(),pth2);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Set up time "+time+" milliseconds");
		
		//test get function
		start = System.currentTimeMillis();
		marlst.get(100);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Search time "+time);
		
		//test get function
		start = System.currentTimeMillis();
		marlst.remove(100);
		end = System.currentTimeMillis();
		time = end - start;
		System.out.println("Remove time "+time);
		
		
	}
}
