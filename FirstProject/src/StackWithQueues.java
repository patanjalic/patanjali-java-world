import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


class StackQ{
	private Queue<Integer> q1;
	private Queue<Integer> q2;
	StackQ(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	boolean push(int data){
		try{
			if(q1.isEmpty() && q2.isEmpty())
				return q1.add(data);
			if(q1.isEmpty())
				q2.add(data);
			else
				return q1.add(data);
		}
		catch(IllegalStateException e){
			
		}
		return false;	
	}
	int pop(){
		if(q1.isEmpty() && q2.isEmpty())
			throw new IllegalStateException("stack is empty");
		Queue<Integer> nonEmpty = q1;
		Queue<Integer> empty = q2;
		if(q1.isEmpty()){
			nonEmpty = q2;
			empty = q1;
		}
		while(nonEmpty.size() != 1)
			empty.add(nonEmpty.poll());
		return nonEmpty.poll(); 
	}
}
public class StackWithQueues {

	@Test
	public void main_test() {
		StackQ s = new StackQ();
		s.push(1);
		s.push(2);
		s.push(3);
		System.out.println("top of stack is "+s.pop());
	}

}
