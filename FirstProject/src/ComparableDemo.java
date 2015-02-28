import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import static java.util.Collections.sort;

// program to understand difference between comparable and comparator
//when a class implements a comparable interface it basically provides compareTo method to 
//compare it with another object of the same class

class Person  implements Comparable<Person>{
	private int age;
	private String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int compareTo(Person o) {
		if(this.age < o.age)
			return -1;
		else if(this.age == o.age){
			return this.name.compareToIgnoreCase(o.name);				
		}
		return 1;
	}
}
class ListValueComparator implements Comparator<Person>{

	@Override
	public int compare(Person o1, Person o2) {
		if((o1.getAge() == o2.getAge()) && (o1.getName().equalsIgnoreCase(o2.getName())))
			return 0;
		else if(o1.getName().equalsIgnoreCase(o2.getName())){
			if(o1.getAge() < o2.getAge())
				return -1;
		}
		return 1;
	}
	
}
public class ComparableDemo{
	public static void main(String[] args) {
		Person a = new Person(30,"Kelly Brook");
		Person b = new Person(31,"Kelly Brook");
		Person c = new Person(28,"Kelly Brook");
		ArrayList<Person> l = new ArrayList<Person>();
		l.add(a);
		l.add(b);
		l.add(c);
		System.out.println("is a same as b " + a.compareTo(b));
		sort(l,new ListValueComparator());
		Iterator<Person> it = l.iterator();
		while(it.hasNext()){
			Person temp = it.next();
			System.out.println(temp.getAge()+" "+temp.getName());
		}
	}
}