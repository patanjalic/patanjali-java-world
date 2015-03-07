import org.junit.Test;

class Student{
	protected String firstName;
	protected boolean isBoy;
	protected int age;
	
	
	public Student(String first, boolean gender, int a) {
		firstName = first;
		isBoy = gender;
		age = a;
	}
	public Student(){
		
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student){
			if(firstName.equalsIgnoreCase(((Student) obj).getFirstName()) 
					&& isBoy==((Student) obj).isBoy() 
					&& age == ((Student) obj).getAge())
					return true;
		}
		return false;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public boolean isBoy() {
		return isBoy;
	}
	public void setBoy(boolean isBoy) {
		this.isBoy = isBoy;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Student1 extends Student{
	protected String LastName;

	public Student1(String firstName, String lastName, boolean gender, int age) {
		super(firstName, gender, age);
		LastName = lastName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
	
}
public class EqualsDemo {

	@Test
	public void EqualsDemoTest() {
		Student s1 = new Student("Kelly",false,30);
		Student1 s2 = new Student1("Kelly","Brook",false,30);
		System.out.println("s1 == s2"+s1.equals(s2));
	}

}
