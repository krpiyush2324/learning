package functionalinterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {

	public static void main(String[] args) {
		int[] l = { 5, 10, 15, 38, 34, 23, 55 };

		// predicate is used to check any condition where we need boolean response

		Predicate<Integer> p = (i) -> i % 2 == 0;
		// it returns always boolean value
		System.out.println(p.test(10));
		System.out.println(p.test(115));
		Predicate<Integer> q = (i) -> i > 50;

		for (int i = 0; i < l.length; i++) {

			if (p.test(l[i])) {
				System.out.println(l[i]);
			}

			if (q.test(l[i])) {
				System.out.println(l[i]);
			}
			// joining predicate with and()
			if (p.and(q).test(l[i])) {
				System.out.println(l[i]);
			}

			// joining predicate with or()
			if (p.or(q).test(l[i])) {
				System.out.println(l[i]);
			}

			// negate the predicate

			if (p.negate().test(l[i])) {
				System.out.println(l[i]);
			}

		}

		System.out.println("***************************************");

		List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");
		List<String> result = names.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		System.out.println(result);

		List<Predicate<String>> allPredicates = new ArrayList<Predicate<String>>();
		allPredicates.add(str -> str.startsWith("A"));
		allPredicates.add(str -> str.contains("d"));
		allPredicates.add(str -> str.length() > 4);

		List<String> results = names.stream()
				.filter(allPredicates.stream().reduce(x -> true, Predicate::and))
				.collect(Collectors.toList());

		System.out.println("results is " + results);
	}

}
