import java.math.BigInteger;

import org.junit.Test;


public class FactorialBigNumber {
	@Test
	public void main_test() {
		int k = 50;
		BigInteger fact = new BigInteger(String.valueOf(k));
		while(k != 1){
			k--;
			fact = fact.multiply(new BigInteger(String.valueOf(k)));
		}
		System.out.println("fact of 50000 is "+fact);
	}

}
