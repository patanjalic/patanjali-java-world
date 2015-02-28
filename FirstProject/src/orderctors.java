class A {
	A() {
		greeting();
		prints();
	}
	void greeting() {
		System.out.println("instance method from A");
	}
	static void prints() {
		System.out.println("Static method from A");
	}
}
class orderctors extends A {
	orderctors() {
		greeting();
		prints();
	}
	void greeting() {
		System.out.println("instance method from B");
	}
	static void prints() {
		System.out.println("Static method from B");
	}
	public static void main(String[] args) {
		new orderctors();
	}
}
