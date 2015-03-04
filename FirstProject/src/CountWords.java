import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;


public class CountWords {

	@Test
	public void main_test() throws IOException {
		long starttime = System.nanoTime();
		FileInputStream fis = new FileInputStream("F:\\javaworld\\patanjali-java-world\\FirstProject\\input.txt");
		try(InputStreamReader is = new InputStreamReader(fis)){
			int ch;
			int count = 0;
			while((ch = is.read()) != -1){
				if(ch == ' ' || ch == '\n')
					count++;
			}
			long endtime = System.nanoTime();
			System.out.println("count is "+(count+1)+"exec time is "+(endtime-starttime));
		}
	}
	
	@Test
	public void main_test1() throws FileNotFoundException{
		long starttime = System.nanoTime();
		try(Scanner fr = new Scanner(new File("F:\\javaworld\\patanjali-java-world\\FirstProject\\input.txt"))){
			int count = 0;
			while(fr.hasNextLine()){
				count += fr.nextLine().split(" ").length;
			}
			long endtime = System.nanoTime();
			System.out.println("count is "+count+"exec time is "+(endtime-starttime));
		}
		
	}

	@Test
	public void main_test2(){
		ExecutorService es = Executors.newCachedThreadPool();
		//ExecutorService es = Executors.newFixedThreadPool(10);
		CountWordsTask cwt = new CountWordsTask("countwords",es);
		Future<Integer> result = es.submit(cwt);
		try {
			System.out.println("word count multiple threads "+result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void main_test3() throws FileNotFoundException{
		int count = getWordsCount(new File("countwords"));
		System.out.println("word count single thread "+count);
	}
	
	public int getWordsCount(File directory) throws FileNotFoundException{
		int count = 0;
		File[] files = directory.listFiles();
		for(File temp: files)
			if(temp.isDirectory()){
				count += getWordsCount(temp);
			}
			else
				count += getCount(temp);
		return count;
	}
	private int getCount(File file) {
		int count = 0;
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine())
				count += in.nextLine().split(" ").length;
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
	
}
class CountWordsTask implements Callable<Integer>{
	private File fileRef;
	private int count;
	private ExecutorService exec;
	public CountWordsTask(String directory,ExecutorService exec) {
		this.fileRef = new File(directory);
		this.count = 0;
		this.exec = exec;
	}
	@Override
	public Integer call() throws Exception {
		File[] files = fileRef.listFiles();
		for(File temp: files)
			if(temp.isDirectory()){
				CountWordsTask match = new CountWordsTask(temp.getAbsolutePath(),exec);
				Future<Integer> fut = exec.submit(match);
				count += fut.get();
			}
			else
				count += getWordCount(temp);
		return count;
	}
	private int getWordCount(File file) {
		int count = 0;
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine())
				count += in.nextLine().split(" ").length;
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return count;
	}
}
