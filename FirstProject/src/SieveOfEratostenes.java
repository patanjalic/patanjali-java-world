import org.junit.Test;


public class SieveOfEratostenes {

	public int [] getPrimes(int upperlimit){
		int upperbound = (int) Math.sqrt(upperlimit);
		int[] primes = new int[upperlimit+1];
		for(int i = 2; i <= upperbound; i++ ){
			if(primes[i] == 0){
				for(int j = i*i; j <=upperlimit ; j+=i){
					primes[j] = 1;
				}
			}
		}
		return primes;
	}
	public void display(int[] primes){
		for(int i = 2; i < primes.length; i++)
			if(primes[i] == 0)
				System.out.print(" "+i);
	}
	@Test
	public void main_test() {
		display(getPrimes(500));
	}

}
