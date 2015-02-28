import java.util.Arrays;

class anagram
{
	public boolean isAnagram(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}
	public static void main(String... args){
		anagram a = new anagram();
		if(a.isAnagram("mary","army"))
			System.out.println("anagram");
	}
}