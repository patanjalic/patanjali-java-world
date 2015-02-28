import java.util.Comparator;
import java.util.Map;


public class ValueComparator implements Comparator<Character>{

	Map<Character,Integer> m;
	public ValueComparator(Map<Character,Integer> val){
		this.m = val;
	}
	@Override
	public int compare(Character o1, Character o2) {
//		if(m.get(o1) >= m.get(o2))
//			return -1;
//		else
//			return 1;
		return m.get(o2).compareTo(m.get(o1));
	}

}
