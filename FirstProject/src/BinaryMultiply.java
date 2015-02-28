
public class BinaryMultiply {

	public static void main(String[] args) {
		BinaryMultiply multiply = new BinaryMultiply();
		System.out.printf("multiplication of 17 9 is %d",multiply.multiply(-17,9));
	
	}
	public int multiply(int num1, int num2) {
		int mult = 0;
		int shift = 0;
		int temp = 0;
		int temp_shift = 0;
		boolean minus = true;
		BinaryAdd add = new BinaryAdd();
		BinarySub sub = new BinarySub();
		if(num1 < 0)
			num1 = add.add(~num1,1);
		else if(num2 < 0)
			num2 = add.add(~num2,1);
		if(num1 < 0 && num2 < 0)
			minus = false;
		minus = true;
		do{
			temp = ((num2 & 1) == 1)?num1:0;
			temp_shift = shift;
			while(temp_shift != 0 && temp > 0){
				temp = temp<<1;
				temp_shift = sub.sub(temp_shift,1);
			}
			mult = add.add(mult,temp);
			shift = add.add(shift,1);
			num2 = num2>>1;
		}
		while(num2 != 0);
		return minus?(add.add(~mult, 1)):mult;
	}
}
