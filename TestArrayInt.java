import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestArrayInt {
	public TestArrayInt(){
		
	}
	
	
	public static ArrayListInt getMarlst(String path){
		ArrayListInt marlst = new ArrayListInt();
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 
            /* 读入TXT文件 */  
            File filename = new File(path); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                marlst.add(Integer.parseInt(line));
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return marlst;
		
	}
	public static ArrayList getArrlst(String path){
		ArrayList arrlst = new ArrayList();
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw  
			 
            /* 读入TXT文件 */  
            File filename = new File(path); // 要读取以上路径的input。txt文件  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            String line = "";  
            while (line != null) {  
                line = br.readLine(); // 一次读入一行数据
                arrlst.add(Integer.parseInt(line));
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return arrlst;
	}
	public static void main(String [] args){
		String pth0 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/dict.txt";
		String pth1 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_500k.txt";
		String pth2 = "/Users/xuxiaochen/Downloads/java_replacement-master/CS593/src/text_case/output_5k_1million.txt";
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
		ArrayList arrlst = getArrlst(pth2);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Set up time "+time);
		//test get function
		start = System.nanoTime();
		arrlst.get(100);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Search time "+time);
		//test remove function
		start = System.nanoTime();
		arrlst.remove(100);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Remove "+time);
		
		System.out.println("******Test MyArryList******");
		//test add function
		start = System.nanoTime();
		ArrayListInt marlst = getMarlst(pth2);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Set up time "+time);
		//test get function
		start = System.nanoTime();
		marlst.get(100);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Search time "+time);
		//test get function
		start = System.nanoTime();
		marlst.remove(100);
		end = System.nanoTime();
		time = end - start;
		System.out.println("Remove time "+time);
		
		
	}
}
