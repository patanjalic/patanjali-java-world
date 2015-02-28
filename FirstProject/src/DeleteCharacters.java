import java.util.HashMap;

class DeleteCharacters{
	public static void main(String... args){
		System.out.println("new string is "+DeleteCharactersString("We are students","aeiou"));
	}

	private static String DeleteCharactersString(String s1, String s2) {
		if(s1 == null || s2 == null)
			return null;
		if(s1.length() == 0)
			return null;
		if(s2.length() == 0)
			return s1;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0;i<s2.length();i++)
			map.put(s2.charAt(i), 1);
		StringBuilder newString = new StringBuilder();
		for(int i = 0;i<s1.length();i++){
			if(!map.containsKey(s1.charAt(i)))
				newString.append(s1.charAt(i));
		}
		return newString.toString();
	}
}