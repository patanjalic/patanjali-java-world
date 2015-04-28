import java.util.Iterator;
import java.util.Stack;

import org.junit.Test;


public class ConvertBase36 {

	@Test
	public void main_test() {
		int x = 100;
		convert(100);
	}

	private void convert(int num) {
		Stack<Integer> s = new Stack<Integer>();
		while(num != 0){
			s.push(num%36);
			num = num/36;
		}
		while(!s.isEmpty()){
			Integer temp = s.pop();
			if(temp < 10)
				System.out.print(temp);
			else{
				Character c = new Character((char) ('A'+temp.intValue()-10));
				System.out.print(c);
			}
		}
	}

}
