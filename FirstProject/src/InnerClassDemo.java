import org.junit.Test;


public class InnerClassDemo {
	private int data;
	@Test
	public void main_test() {
		final int x = 10;
		class Inner{
			void printOuter(){
				System.out.println("outer data is "+data);
				System.out.println("x is "+x); // cannot use unless it is final
			}
		}
		Inner my = new Inner();
		my.printOuter();
	}

}
