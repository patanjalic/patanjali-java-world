
public class LearnStatic {
	public static int trytoaccessme=100;
	{
		System.out.println("initializer block called");
	}
	LearnStatic() {
		System.out.println("default ctor called");
	}
	static {
		System.out.println("static block called");
		trytoaccessme = 1000;
	}
}

class TestLearnStatic {
	public static void main(String... args) {
		System.out.println(LearnStatic.trytoaccessme);
		new LearnStatic();
	}
}
