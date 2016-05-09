

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Generator_2{
	public static void generateInt() throws IOException{
		FileWriter out = null;
	      try {
	         out = new FileWriter("output_500k_Integer.txt");
	         Random rd =new Random();
	         int nums=500000;
	         int max=5000000;
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
	public static void generateDouble() throws IOException{
		FileWriter out = null;
	      try {
	         out = new FileWriter("output_5million_Double.txt");
	         Random rd =new Random();
	         int nums=5000000;
	         int max=1000000;
	         for(int i=0;i<nums;i++){
	        	 double temp=rd.nextInt(max)*rd.nextDouble();
	        	 String a=Double.valueOf(temp).toString();
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
	      //generateInt();//generate random Integer
	      generateDouble();//generate random Double
	}
}
