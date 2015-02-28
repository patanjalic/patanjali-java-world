
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		LongestPalindromeSubstring substr = new LongestPalindromeSubstring();
		long startTime = System.nanoTime();
		//System.out.println("longest palindrome subsequence in abcdabbadcxyzpqr is "+substr.findPalindromeSubstring("abcdabbadcxyzpqr"));
		System.out.println("longest palindrome subsequence in abcdabbadcxyzpqr is "+substr.findPalindromeSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		long endTime = System.nanoTime();
		double duration = (endTime - startTime);
		System.out.println("execution time of program is "+duration);
	}

	private String findPalindromeSubstring(String seq) {
		int maxlength = 0;
		if(isPalindrome(seq) == true)
			return seq;
		String str = preprocess(seq);
		if(isPalindrome(str) == true)
			return str;
		int strlen = str.length();
		for(int i = 0; i < strlen; i++){
			int end = strlen - 1;
			while(end != i){
				if(str.charAt(end) == str.charAt(i))
					if(isPalindrome(str.substring(i, end+1)))
						if((end - i + 1) > maxlength){
							maxlength = end - i + 1;
							seq = str.substring(i, end+1);
						}
				end--;
			}
		}
		if(maxlength > 0)
			return seq;
		return null;
	}

	private String preprocess(String str) {
		StringBuilder pre = new StringBuilder();
		int strlen = str.length();
		pre.append(str.charAt(0));
		int k = 0;
		for(int i = 1 ; i < strlen ; i++){
			if(str.charAt(i) != pre.charAt(k)){
				pre.append(str.charAt(i));
				k++;
			}
		}
		return pre.toString();
	}

	private boolean isPalindrome(String charSequence) {
		int k = 0;
		int j = charSequence.length() - 1;
		while(k < j){
			if(charSequence.charAt(k) != charSequence.charAt(j))
				return false;
			k++;
			j--;
		}
		return true;
	}

}
