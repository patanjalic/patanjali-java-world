import java.io.FileNotFoundException;
import java.io.PrintStream;

class fileOutput{
	public static void main(String... args){
		try {
			System.setOut(new PrintStream("output.txt"));
			System.out.println("kelly brook");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}