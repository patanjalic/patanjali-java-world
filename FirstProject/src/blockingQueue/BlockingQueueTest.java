package blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

class BlockingQueueTest{
	public static void main(String... args) throws FileNotFoundException{
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the directory");
		String directory = input.nextLine();
		System.out.println("Enter the keyword");
		String keyword = input.nextLine();
		final int queueSize = 10;
		final int NO_THREADS = 100;
		LinkedBlockingQueue<File> lbq = new LinkedBlockingQueue<File>(queueSize);
		long startTime = System.nanoTime();
		FileListTask fe = new FileListTask(lbq,new File(directory));
		Thread filesPutter = new Thread(fe);
		filesPutter.start();
		for(int i = 0 ;i < NO_THREADS; i++)
			new Thread(new SearchKeyword(lbq,keyword)).start();
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);
		System.out.println("execution time of program is "+duration);
		startTime = System.nanoTime();
		BruteSearch(new File(directory),keyword);
		endTime = System.nanoTime();
		duration = endTime - startTime;
		System.out.println("brute execution time is "+duration);
		input.close();
	}

	private static void BruteSearch(File directory, String keyword) throws FileNotFoundException {
		File[] files = directory.listFiles();
		for(File temp:files){
			if(temp.isDirectory())
				BruteSearch(temp,keyword);
			else
				search(temp,keyword);
		}
	}
	private static void search(File file,String keyword) throws FileNotFoundException {
		Scanner fs = new Scanner(file);
		long linenumber = 0;
		while(fs.hasNextLine()){
			linenumber++;
			if(fs.nextLine().contains(keyword)){
				System.out.println(file.getAbsolutePath() + " "+linenumber);
				break;
			}
		}
		fs.close();
	}
}