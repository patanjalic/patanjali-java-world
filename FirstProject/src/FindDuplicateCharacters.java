import java.util.HashMap;
import java.util.Map;

class FindDuplicateCharacters{
	public void findAndPrintDuplicates(String str){
		System.out.println("entered string is "+str);
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < str.length(); i++)
		{
			if(map.containsKey(str.charAt(i))){
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			}
			else
				map.put(str.charAt(i), 1);
		}
		for(Map.Entry<Character, Integer> m:map.entrySet()){
			if(m.getValue() > 1)
				System.out.println("duplicate found and value "+m.getValue()+" "+m.getKey());
		}
	}
	public static void main(String... args){
		FindDuplicateCharacters fd = new FindDuplicateCharacters();
		fd.findAndPrintDuplicates("Programming");
	}
}