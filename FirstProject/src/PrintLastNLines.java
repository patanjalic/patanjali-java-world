import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

class PrintLastNLines{
	public static void main(String[] args) throws IOException {
		PrintLastNLines p = new PrintLastNLines();
		//p.printLastN("F:/eclipse/workspace/FirstProject/input.txt",10);
		try {
			p.printLastN("input.txt",10);
		} catch (IOException e) {
			System.out.println("exception occured");
		}
	}

	private void printLastN(String str, int N) throws IOException {
		//Not working for some reason
		//LineNumberReader  lnr = new LineNumberReader(new FileReader(new File(str)));
		//long wc = lnr.skip(Long.MAX_VALUE);
		//lnr.close();
		long wc = lineCount(str);
		BufferedReader br = new BufferedReader(new FileReader(new File(str)));
		long count = 0;
		String line;
		while((line = br.readLine()) != null){
			count++;
			if(count + N > wc)
				System.out.print(" "+line);
		}
		br.close();
	}

	private long lineCount(String str) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(str)));
		long count = 0;
		while(br.readLine() != null)
			count++;
		br.close();
		return count;
	}
}