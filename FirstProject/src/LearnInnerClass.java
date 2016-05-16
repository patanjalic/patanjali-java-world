
public class LearnInnerClass {
	private int a = 11;
	//if ctor is protected classes in same package can create instaneces of LearnInnerClass
	//if ctor is private then no one can instantiate the class
	protected LearnInnerClass() {
		
	}
	public void accessB() {
		//you cannot access inner class variable
//		System.out.println("b is "+b);
	}
	private class InnerClass {
		private int b;
		private static final int c=10;
		private InnerClass(){
			
		}
		public void accessA() {
			//you can access outerclass private variable
			System.out.println("a is "+a);
		}
//		static methods cannot be defined in inner classes
//		public static void aStaticMethod() {
//			
//		}
	}
	public static void main(String... args) {
		LearnInnerClass cls = new LearnInnerClass();
		//cannot access non static fields in static context
//		System.out.println("a is "+a);
		LearnInnerClass.InnerClass inner = cls.new InnerClass();
		inner.accessA();
	}
}

class AccessLearnInnerClass {
	public static void main(String... args) {
		LearnInnerClass cls = new LearnInnerClass();
	}
}
