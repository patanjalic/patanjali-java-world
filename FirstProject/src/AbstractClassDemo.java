interface food{
	String brand = null;
	void bringFood();
}
abstract class Animal implements food{
	private final String name;
	public Animal(String n){
		name = n;
	}
	abstract boolean isHerbivore();
	public String getName(){
		return this.name;
	}
	private boolean isExtinctHelper(){
		return false;	
	}
}
class Dog extends Animal{

	public Dog(String n) {
		super(n);
	}

	@Override
	boolean isHerbivore() {
		return false;
	}

	@Override
	public void bringFood() {
		System.out.println("yum");
	}
	
}

public class AbstractClassDemo{
	public static void main(String[] args) {
		Animal dog = new Dog("stella");
		System.out.println(dog.getName()+" is a "+dog.isHerbivore());
		dog.bringFood();
	}
}