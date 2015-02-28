import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//program to check the unmodifiableCollection from collections framework
//it will return us a dynamic view of the underlying collection, which cannot me modified
//even through iterator. you can modify underlying collection directly and it will get reflected in dynamic view

class UnModifiableCollection{
	private List<String> names = new ArrayList<>();
	public void testConcurrency(){
		names.add("1");
		names.add("2");
		names.add("3");
		names.add("4");
		Collection<String> dynamicView = Collections.unmodifiableCollection(names);
		names.add("5");
		Iterator<String> it = dynamicView.iterator();
		while(it.hasNext()){
			System.out.println("s = " + it.next());
			//it.remove();
		}
		names.remove(0);
		it = dynamicView.iterator();
		System.out.println("junk");
		while(it.hasNext()){
			System.out.println("s = " + it.next());
			//it.remove();
		}
	}
	public static void main(String[] args) {
		UnModifiableCollection test = new UnModifiableCollection();
		test.testConcurrency();
	}
}