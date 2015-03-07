
public class OverFlowDemo {

	public static void main(String[] args) {
		int i = Integer.MAX_VALUE;
		int j = Integer.MAX_VALUE;
		int k = 0x7FFFFFFF;
		int l = 0x7FFFFFFF;
		System.out.println("result is "+(l+k));
	}

}
