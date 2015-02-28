import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class synchBlock{
	public static void main(String... args){
		synchBlock c = new synchBlock();
		c.testSynchBlock();
	}

	private void testSynchBlock() {
		List<String> c = Collections.synchronizedList(new ArrayList<String>());
		c.add("one");
		c.add("two");
		c.add("three");
		
		synchronized(c){
			Iterator<String> it = c.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}
}