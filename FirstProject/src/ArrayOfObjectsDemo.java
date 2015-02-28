class Phone{
	private int model;
	private String OS;
	Phone(){
		System.out.println("in phone ctor");
	}
}
class ArrayOfObjectsDemo{
	public static void main(String[] args) {
		Phone[] phones = new Phone[10];
		phones[0] = new Phone();
		int[] arr = new int[20];
		
	}
}