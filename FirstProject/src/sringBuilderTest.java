class sringBuilderTest
{
	public static void main(String... args){
		sringBuilderTest abc = new sringBuilderTest();
		abc.test();
	}

	private void test() {
		int count = 77777777;
		long t = System.currentTimeMillis();
		StringBuilder s = new StringBuilder("junk");
		for(int i =0 ;i<count;i++){
			s.append("");
		}
		System.out.println("time for stringbuilder is "+(System.currentTimeMillis() - t));
		StringBuffer s1 = new StringBuffer("junk");
		t = System.currentTimeMillis();
		for(int i = 0;i<count;i++){
			s1.append("");
		}
		System.out.println("time for stringbuffer is "+(System.currentTimeMillis() - t));
		
	}
}