import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


public class FutureDemo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a directory");
		String dir = input.nextLine();
		System.out.println("enter keyword");
		String keyword = input.nextLine();
		MatchCounter match = new MatchCounter(dir,keyword);
		FutureTask<Integer> task = new FutureTask<Integer>(match);
		task.run();
		try {
			System.out.println("Number of mathes found is "+task.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		input.close();
	}

}

class MatchCounter implements Callable<Integer>{
	private String directory;
	private String keyword;
	private int count;
	private File fileRef;
	@Override
	public Integer call() throws Exception {
		try{
			File[] files = fileRef.listFiles();
			for(File temp:files)
				if(temp.isDirectory()){
					MatchCounter counter = new MatchCounter(temp.getAbsolutePath(),keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					task.run();
					count += task.get();
				}
				else
					if(search(temp))
						count += 1;
		}
		catch(Exception exp){
			System.out.println("exception caught");
		}
		finally{
			//System.out.println("exception caught");
		}
		return count;
	}
	private boolean search(File file) {
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine())
				if(reader.nextLine().contains(keyword))
					return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public MatchCounter(String directory, String keyword) {
		this.directory = directory;
		this.keyword = keyword;
		this.count = 0;
		this.fileRef = new File(directory);
	}
	
}
