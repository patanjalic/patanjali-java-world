import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

import org.junit.Test;

class SetComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}
	
}
class SetComparatorDesc implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
	
}
public class FindMedian {
	@Test
	public void main_junk() {
		SetComparator sc = new SetComparator();
		TreeSet<Integer> tm = new TreeSet<Integer>(sc);
		tm.add(1);
		tm.add(10);
		tm.add(20);
		tm.add(7);
		tm.add(9);
		tm.add(30);
		tm.add(6);
		tm.add(12);
		Iterator<Integer> it = tm.iterator();
		while(it.hasNext())
			System.out.print(it.next()+" ");
		it = tm.iterator();
		if((tm.size() & 1) == 1){
			for(int i = 0; i < tm.size()/2; i++)
				it.next();
			System.out.println("median is "+it.next());
		}
		else{
			for(int i = 0; i < tm.size()/2-1; i++)
				it.next();
			System.out.println("median is "+(it.next()+it.next())/2);
		}
		//using priority queue
		int[] arr = {1,10,20,7,9,30,6};
		SetComparatorDesc sc1 = new SetComparatorDesc();
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>(sc1);
		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(sc);
		for(int temp:arr)
			insertIntoHeaps(temp,pq1,pq2);
		if((((pq1.size() + pq2.size())&1) == 1))
			System.out.println("median is "+pq1.peek());
		else
			System.out.println("median is "+(pq1.peek() + pq2.peek())/2);
	}
	
	private static void insertIntoHeaps(int temp, PriorityQueue<Integer> pq1,
			PriorityQueue<Integer> pq2) {
		if(pq1.size() == 0 && pq2.size() == 0){
			pq1.offer(temp);
			return;
		}
		if(pq2.size() == 0){
			pq2.offer(temp);
			return;
		}
		if(((pq1.size() + pq2.size())&1) == 0){
			if(pq2.peek() < temp){
				int rem = pq2.poll();
				pq1.offer(rem);
				pq2.offer(temp);
			}
			else
				pq1.offer(temp);
		}
		else{
			if(temp < pq1.peek()){
				int rem = pq1.poll();
				pq2.offer(rem);
				pq1.offer(temp);
			}
			else
				pq2.offer(temp);
		}
	}
}
