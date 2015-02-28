import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class FindDifference{
	public static void main(String... args){
		String A = "abcdef";
		String B = "cdf";
		FindDifference f = new FindDifference();
		System.out.println("difference of two sets is "+f.AMinusB(A,B));
	}

	private String AMinusB(String a, String b) {
		StringBuilder s = new StringBuilder();
		Set<Character> set = new HashSet<Character>();
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		for(char temp:B)
			set.add(temp);
		for(char temp:A)
			if(!set.contains(temp))
				s.append(temp);
		return s.toString();
	}
}