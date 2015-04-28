import java.util.Comparator;
import java.util.TreeMap;


class Node{
	Integer index;
	Integer count;
	
	public void increaseCount(){
		++this.count;
	}
}
class CustomComparator implements Comparator<Node>{

	@Override
	public int compare(Node o1, Node o2) {
		if(o1.count == o2.count)
			return o1.index.compareTo(o2.index);
		else
			return o1.count.compareTo(o2.count);
	}
	
}
public class FirstNonRepeatingCharater {

	public void main_test() {
		String str = "google";
		System.out.println("first non repeating character is "+firstNonRepeating(str.toCharArray()));
	}

	private char firstNonRepeating(char[] charArray) {
		Comparator<Node> cc = new CustomComparator();
		//TreeMap<Character,Node> map = new TreeMap<Character,Node>(cc);
		return 'a';
	}

}
