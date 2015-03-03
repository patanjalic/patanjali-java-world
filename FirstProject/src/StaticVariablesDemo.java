import org.junit.Test;


public class StaticVariablesDemo {
	private static int data = 9;
	public static int num = 10;
	@Test
	public void TestStaticVariablesDemo() {
		System.out.println("initial value of data is "+StaticVariablesDemo.data);
		System.out.println("num is "+StaticVariablesDemo.num);
		StaticVariablesDemo svd = new StaticVariablesDemo();
		svd.num = 11;
		System.out.println("now num is "+StaticVariablesDemo.num);
	}

}
