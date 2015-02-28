import java.util.ArrayList;
import java.util.Comparator;

class Employee implements Comparable<Employee>
{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int compareTo(Employee other)
	{
		return Double.compare(salary, other.salary);
	}
	
	public static void test()
	{
		ArrayList<Employee> e = new ArrayList<Employee>();
        Employee e1 = new Employee();
        e1.setSalary(1000);
        e.add(e1);
        e1 = new Employee();
        e1.setSalary(2000);
        e.add(e1);
        e1 = new Employee();
        e1.setSalary(1234);
        e.add(e1);
        for(Employee temp: e)
        {
        	System.out.println("  "+temp.getSalary());
        }
        Comparator<? super Employee> e2 = null;
		e.sort(e2);
        for(Employee temp: e)
        {
        	System.out.println("  "+temp.getSalary());
        }
	}
}
