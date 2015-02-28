import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class highestCharString{
	
	public static void main(String... args){
		highestCharString h = new highestCharString();
		h.findHighest("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbccccccccccccccccccdddd");
	}

	private void findHighest(String s) {
		//HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		
		TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();
		for(int i = 0; i<s.length();i++){
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else
				map.put(s.charAt(i), 1);
		}
		//TreeMap<Character,Integer> tr = new TreeMap<Character,Integer>(map);
		//Set<Entry<Character, Integer>> s1 = tr.entrySet();
		ValueComparator bvc =  new ValueComparator(map);
		TreeMap<Character,Integer> map1 = new TreeMap<Character,Integer>(bvc);
		map1.putAll(map);
		Set<Entry<Character, Integer>> s1 = map1.entrySet();
		Iterator<Entry<Character, Integer>> it = s1.iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> ent = it.next();
			System.out.print(ent.getValue());
			System.out.println(ent.getKey());
		}
	}
	
}