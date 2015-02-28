class BinaryDivide{

	public static void main(String... args){
		BinaryDivide b = new BinaryDivide();
		System.out.println("div is "+b.divide(13,232));
	}
	private int divide(int divisor, int dividend) {
		int denom=divisor;
	    int current = 1;
	    int answer=0;

	    if ( denom > dividend) 
	        return 0;

	    if ( denom == dividend)
	        return 1;

	    while (denom <= dividend) {
	        denom <<= 1;
	        current <<= 1;
	    }

	    denom >>= 1;
	    current >>= 1;

	    while (current!=0) {
	        if ( dividend >= denom) {
	            dividend -= denom;
	            answer |= current;
	        }
	        current >>= 1;
	        denom >>= 1;
	    }    
	    return answer;
	}
}