package blockingQueue;

import java.io.File;
import java.util.concurrent.BlockingQueue;

public class FileListTask implements Runnable{
	public static final File DUMMY = new File("");
	private File file;
	private BlockingQueue<File> lbq;
	
	public FileListTask(BlockingQueue<File> lbq, File file) {
		this.file = file;
		this.lbq = lbq;
	}

	@Override
	public void run() {
		try{
			enumerate(file);
			lbq.put(DUMMY);
		}
		catch(InterruptedException exp){
			
		}
	}
	private void enumerate(File file) throws InterruptedException{
		File[] files = file.listFiles();
		for(File temp:files)
			if(temp.isDirectory())
				enumerate(temp);
			else
				lbq.put(temp);
				//lbq.add(temp);
	}
}
