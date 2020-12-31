package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> list = Arrays.asList(new Student(20, "piyush"), new Student(60, "piyush"),
				new Student(75, "piku"), new Student(90, "piyush"), new Student(95, "piyush"));

		Predicate<Student> p = i -> i.mark > 80;

		Function<Student, String> grade = s -> {

			if (p.test(s)) {
				return "Grade A";
			} else {
				return null;
			}
		};

		Consumer<Student> st = s -> {
			System.out.println(s.mark);
			System.out.println(s.name);
			System.out.println(grade.apply(s));
		};

		list.stream().forEach(s -> {
			if (p.test(s)) {
				st.accept(s);
			}
		});
	}

}

class Student {
	int mark;
	String name;

	public Student(int mark, String name) {
		this.mark = mark;
		this.name = name;
	}

	public String toString() {
		return name + ": " + mark;

	}

}