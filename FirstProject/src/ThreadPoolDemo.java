import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadPoolDemo {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter directory");
		String directory = in.nextLine();
		System.out.println("enter keyword");
		String keyword = in.nextLine();
		ExecutorService exec = Executors.newCachedThreadPool();
		MatchCounters match = new MatchCounters(directory,keyword,exec);
		Future<Integer> result = exec.submit(match);
		try {
			System.out.println("no of keywords found "+result.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class MatchCounters implements Callable<Integer>{
	private String directory;
	private String keyword;
	private File fileRef;
	private int count;
	private ExecutorService exec;
	public MatchCounters(String directory, String keyword,ExecutorService exec) {
		this.directory = directory;
		this.keyword = keyword;
		this.fileRef = new File(directory);
		this.count = 0;
		this.exec = exec;
	}
	@Override
	public Integer call() throws Exception {
		File[] files = fileRef.listFiles();
		for(File temp: files)
			if(temp.isDirectory()){
				MatchCounters match = new MatchCounters(temp.getAbsolutePath(),keyword,exec);
				Future<Integer> fut = exec.submit(match);
				return fut.get();
			}
			else
				count += search(temp);
		return count;
	}
	private int search(File file) {
		try {
			Scanner in = new Scanner(file);
			while(in.hasNextLine())
				if(in.nextLine().contains(keyword))
					return 1;
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}