public class staticInitializer{
	public static final int A = 5;
	public static final int B; //note that it is not public static final int B = null;
	//note that since B is final, it can be initialized only once.
	//Static initializer block, which is executed only once when the class is loaded.
	static {
//	if(A == 5)
//	B = 10;
//	else
	B = 5;
	System.out.println("in static initializer block");
	}
	public staticInitializer(){
		System.out.println("in ctor");
	} //constructor is called only after static initializer block
	public static void main(String[] args)
	{
		staticInitializer s = new staticInitializer();
	}
}
