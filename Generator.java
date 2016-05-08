package text_case;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator {
	public static void generateInt() throws IOException{
		FileWriter out = null;
	      try {
	         out = new FileWriter("output_5k.txt");
	         Random rd =new Random();
	         int nums=5000;
	         int max=1000000;
	         for(int i=0;i<nums;i++){
	        	 String a=Integer.valueOf(rd.nextInt(max)).toString();
	        	 out.write(a+" \r\n");
	         }
	      }finally {
	         if (out != null) {
	            out.close();
	         }
	         System.out.print("done");
	      }
	}
	public static void generateString() throws IOException{
		FileWriter out = null;
	      try {
	         out = new FileWriter("output_5k.txt");
	         Random rd =new Random();
	         int nums=5000;
	         int max=1000000;
	         for(int i=0;i<nums;i++){
	        	 String a=Integer.valueOf(rd.nextInt(max)).toString();
	        	 out.write(a+" \r\n");
	         }
	      }finally {
	         if (out != null) {
	            out.close();
	         }
	         System.out.print("done");
	      }
	}
	public static void main(String[] args) throws IOException{
	      generateInt();
	}
}
