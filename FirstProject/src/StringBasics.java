public class StringBasics {
	public static void main(String[] args) {
		String s1 = new String("A"); //not recommended, use String s1 = "A"
		String s2 = new String("A"); //not recommended, use String s2 = "A"
		//standard: follows the == and equals() rule like plain java objects.
		if (s1 == s2) { //shallow comparison
			System.out.println("references/identities are equal"); //never reaches here
		}
		if (s1.equals(s2)) { //deep comparison
			System.out.println("values are equal"); // this line is printed
		}
		//variation: does not follow the == and equals rule
		String s3 = "A"; //goes into a String pool.
		String s4 = "A"; //refers to String already in the pool.
		if (s3 == s4) { //shallow comparison
			System.out.println("references/identities are equal"); //this line is printed
		}
		if (s3.equals(s4)) { //deep comparison
			System.out.println("values are equal"); //this line is also printed
		}
		
		//Inefficient version using immutable String
		String output = "Some text";
		int count = 100;
		for(int i =0; i<count; i++) {
			output += i;
		}
		System.out.println(output);	
		
		//More efficient version using mutable StringBuffer
		StringBuffer output1 = new StringBuffer(110);// set an initial size of 110
		output1.append("Some text");
		for(int i =0; i<count; i++) {
		output1.append(i);
		}
		System.out.println(output1.toString());
	}
}