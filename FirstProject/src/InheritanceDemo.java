class base{
	private void fun1(){
	}
	protected void fun2(){
		System.out.println("in base fun2 ");
	}
	public void fun3() throws derexception, myexception{
		System.out.println("in base fun3");
	}
}

class myexception extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2002393842133001529L;
	
}

class derexception extends myexception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3494222175598844614L;
	
}

class derived extends base{
	private void fun1(){
		
	}
	public void fun3() throws myexception{
		System.out.println("in derived fun3");
	}
}

public class InheritanceDemo {
	
	public static void main(String[] args) {
		try{
			base der = new derived();
			der.fun2();
			der.fun3();
			return;
		}
		catch(Exception exp){
			
		}
		finally{
			System.out.println("in finally");
		}
	}
}
