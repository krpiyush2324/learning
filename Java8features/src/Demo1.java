import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Demo1 {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(5);
		l.add(15);
		l.add(50);

		Comparator<Integer> c = (I1, I2) -> (I1 < I2) ? 1 : (I1 > I2) ? -1 : 0;
		Comparator<Integer> d = (I1, I2) -> I2.compareTo(I1);
		Collections.sort(l, d);
		l.stream().forEach(System.out::println);

		List<Integer> l2 = l.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
		System.out.println(l2);

		List<String> s = new ArrayList<String>();
		s.add("Piysush");
		s.add("Anjali");
		s.add("raju");
		Comparator<String> cs = (S1, S2) -> S1.toUpperCase().compareTo(S2.toUpperCase());
		Collections.sort(s, cs);
		System.out.println(s);

	}
}
