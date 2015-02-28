class removeChar{
	
	
	public static void main(String... args){
		removeChar c = new removeChar();
		System.out.println(c.remove("junkestnation",'n'));
		System.out.println(c.removeIter("junkestnation",'n'));
	}

	private String remove(String s, char c) {
		if (s == null)
			return null;
		if(s.length() == 0)
			return null;
		int i = s.indexOf(c);
		if(i == -1)
		{
			return s;
		}
		if(i == s.length() - 1)
			return s.substring(0, i);
		return remove(s.substring(0, i),c) + remove(s.substring(i+1, s.length()),c);
	}
	private String removeIter(String s,char c){
		String ret = new String(s);
		int i = 0;
		while((i = ret.lastIndexOf(c)) != -1 ){
			ret = ret.substring(0, i) + ret.substring(i+1, ret.length());
		}
		return ret;
	}
}