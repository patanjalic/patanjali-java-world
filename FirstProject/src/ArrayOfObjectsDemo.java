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
		int[][] arr1 = new int[2][2];
		arr1[1][1] = 20;
		for(int i = 0 ; i < arr1.length; i++)
			for(int j = 0 ; j < arr1[0].length; j++)
				System.out.print("  "+arr1[i][j]);
	}
}