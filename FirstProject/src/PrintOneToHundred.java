import org.junit.Test;

class Dummy{
	private static int i;
	Dummy(){
		System.out.print(" "+ ++i);
		
	}
}
public class PrintOneToHundred {
	@Test
	public void main_test() {
		print(1);
		Dummy[] objs = new Dummy[100];
		objs[0] = new Dummy();
 	}

	private void print(int i) {
		if(i > 100)
			return;
		System.out.print(" "+i);
		print(i+1);
	}

}
