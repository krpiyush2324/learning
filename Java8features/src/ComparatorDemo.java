import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
	int eno;
	String name;

	public Employee(int eno, String name) {
		this.eno = eno;
		this.name = name;
	}

	public String toString() {
		return eno + ":" + name;
	}
}

public class ComparatorDemo {

	public static void main(String[] args) {

		List<Employee> l = new ArrayList<Employee>();
		l.add(new Employee(10, "Piyush"));
		l.add(new Employee(15, "kumar"));
		l.add(new Employee(5, "Siddharth"));
		l.add(new Employee(25, "Jack"));
		System.out.println(l);

		// sort based on eno
		l.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.eno < o2.eno ? -1 : o1.eno > o2.eno ? 1 : 0;
			}
		});
		
		System.out.println(l);

		// before java 8
		l.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				// TODO Auto-generated method stub
				return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
			}
		});

		// another way of using compararor
		l.sort((o1, o2) -> {
			return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
		});

		// another way of using comparaor interface using lambda expression
		Collections.sort(l, (o1, o2) -> {
			return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
		});

		System.out.println(l);
	}
}
