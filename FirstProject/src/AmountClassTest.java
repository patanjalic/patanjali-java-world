import java.util.*;
import java.math.*;

class Amount{
	BigDecimal value;
	String crncyCode;
	Amount(String value, String crncy){
		this.value = new BigDecimal(value);
		crncyCode = crncy;
	}
	void display(){
		System.out.println(this.value + " "+crncyCode);
	}
	Amount add(Amount amt){
		BigDecimal temp = null;
		if(this.crncyCode.equalsIgnoreCase("USD"))
			if(amt.crncyCode.equalsIgnoreCase("INR"))
				temp = this.value.add(amt.value.divide(new BigDecimal(String.valueOf(60)),2,BigDecimal.ROUND_FLOOR));
		return new Amount(temp.toString(),this.crncyCode);
	}
}
class AmountClassTest{
	public static void main(String... args){
		System.out.println("hello world");
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		for(Integer temp:ll)
			System.out.print("  "+temp);
		Iterator<Integer> itr = ll.listIterator();
		while(itr.hasNext())
			System.out.println(itr.next());
int i = 22, j = 7;
  BigDecimal a = new BigDecimal(i);
  BigDecimal b = new BigDecimal(j),
  c = new BigDecimal(0);

  c = a.divide(b, 5, BigDecimal.ROUND_FLOOR);
  System.out.println("PI value with scale 5 : " 
  + c);
		Amount amt = new Amount("100.90","USD");
		amt.display();
		Amount amt1 = new Amount("10000.00","INR");
		amt = amt.add(amt1);
		amt.display();
	}
}