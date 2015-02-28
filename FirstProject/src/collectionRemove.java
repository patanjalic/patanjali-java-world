import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
public class collectionRemove {
	public void removeFromCollection(List<Integer> marks) {
		for (Integer mark : marks) {
			if (mark < 40)
				marks.remove(mark);
		}
	}
	public void removeFromCollectionSafe(List<Integer> marks) {
		for (Iterator<Integer> iterator = marks.iterator(); iterator.hasNext(); ) {
		Integer mark = iterator.next();
		if (mark < 40)
		iterator.remove();
		}
		}
	public static void main(String[] args) {
		collectionRemove test = new collectionRemove();
		List<Integer> l = new ArrayList<Integer>(asList(10,20,50,60));
		test.removeFromCollectionSafe(l);
		for(Iterator<Integer> it = l.iterator();it.hasNext();){
			System.out.println("element is "+it.next().intValue());
		}
	}
}