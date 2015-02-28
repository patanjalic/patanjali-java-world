public class BinaryAdd{
	public static void main(String... args){
		BinaryAdd add = new BinaryAdd();
		System.out.println("addition of 17 9 is "+add.add(17,9));
	}

	private int add(int num1, int num2) {
		int sum = 0;
		int carry = 0;
		do{
			sum = num1 ^ num2;
			carry = (num1 & num2)<<1;
			num1 = sum;
			num2 = carry;
		}
		while(num2 != 0);
		return num1;
	}
}