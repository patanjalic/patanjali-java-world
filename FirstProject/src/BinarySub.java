
public class BinarySub {

	public static void main(String[] args) {
		BinarySub sub = new BinarySub();
		System.out.printf("sub of 17 9 is %d",sub.sub(17,9));
	}

	private int sub(int num1, int num2) {
		BinaryAdd add = new BinaryAdd();
		num2 = add.add(~num2,1);
		return add.add(num1, num2);
	}

}
