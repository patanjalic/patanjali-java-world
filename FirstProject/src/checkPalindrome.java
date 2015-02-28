class checkPalindrome{
	public static void main(String... args){
		checkPalindrome c = new checkPalindrome();
		System.out.println("is 1221 palindrome "+c.isPalindrome(121));
	}

	private boolean isPalindrome(int i) {
		String str = Integer.toString(i);
		int k = 0;
		int j = str.length() - 1;
		while(k != j){
			if(str.charAt(k) != str.charAt(j))
				return false;
			k++;
			j--;
		}
		return true;
	}
}