import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TestHashStr {
	public TestHashStr(){
		
	}
	
	
	public static HashMapStr getHmstr(String path){
		HashMapStr hmstr = new HashMapStr();
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			
            /* 读入TXT文件 */  
            File filename = new File(path); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                hmstr.put(line, 0);
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return hmstr;
		
	}
	public static HashMap getHm(String path){
		HashMap hm = new HashMap();
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 
            /* 读入TXT文件 */  
            File filename = new File(path); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                hm.put(line, 0);
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return hm;
	}
	public static void main(String [] args){
		String pth0 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/dict.txt";
		String pth1 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_500k.txt";
		String pth2 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_50k_1million.txt";
		String pth3 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_5k_1million.txt";
		String pth4 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_5million_5million.txt";
		String pth5 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_5million.txt";
		String pth6 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/words_100k.txt";
		String pth7 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/words_230k.txt";
		String pth8 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/words_50k.txt";
		String pth9 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/words.txt";
		double start, end, time;
		
		System.out.println("******Test System ArryList******");
		//test add function
		start = System.nanoTime();
		HashMapStr hmSys = getHmstr(pth0);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Set up time "+time);
		//test get function
		start = System.nanoTime();
		hmSys.containsKey("eee");
		end = System.nanoTime();
		time = end - start;
		System.out.println("containsKey time "+time);
		//test get function
		start = System.nanoTime();
		hmSys.remove("aaaa");
		end = System.nanoTime();
		time = end - start;
		System.out.println("Remove time "+time);
		
		System.out.println("******Test MyHashMap******");
		//test add function
		start = System.nanoTime();
		HashMapStr hmstr = getHmstr(pth0);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Set up time "+time);
		//test get function
		start = System.nanoTime();
		hmstr.containsKey("eee");
		end = System.nanoTime();
		time = end - start;
		System.out.println("containsKey time "+time);
		//test get function
		start = System.nanoTime();
		hmstr.remove("aaaa");
		end = System.nanoTime();
		time = end - start;
		System.out.println("Remove time "+time);
		
		
	}
}
