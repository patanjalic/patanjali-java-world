package blockingQueue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

public class SearchKeyword implements Runnable{
	private LinkedBlockingQueue<File> lbq;
	private String keyword;
	public SearchKeyword(LinkedBlockingQueue<File> lbq, String keyword) {
		this.lbq = lbq;
		this.keyword = keyword;
	}
	@Override
	public void run() {
		boolean done = false;
		
		try {
			while(!done){
				File file = lbq.take();
				if(file == FileListTask.DUMMY){
					lbq.put(file);
					done = true;
				}
				search(file);
			} 
		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	private void search(File file) throws FileNotFoundException {
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
