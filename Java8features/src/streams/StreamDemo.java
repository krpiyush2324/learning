package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {

		ArrayList<Integer> l = new ArrayList<>();
		l.add(10);
		l.add(20);
		l.add(23);
		l.add(45);
		l.add(80);
		System.out.println(l);

		// filter method to filter
		System.out.println("=============" + "filter()" + "==============");
		List<Integer> s = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(s);

		// mapToInt in stream
		System.out.println("=============" + "mapInt()" + "==============");
		List<String> list = Arrays.asList("3", "6", "8", "14", "15");
		list.stream().mapToInt(num -> Integer.parseInt(num)).filter(f -> f % 2 == 0).forEach(System.out::println);

		// map in stream
		System.out.println("=============" + "map()" + "==============");
		List<Integer> updatedList = l.stream().map(i -> i + 5).collect(Collectors.toList());
		System.out.println(updatedList);

		// count method in stream
		System.out.println("=============" + "count()" + "==============");
		int count = (int) l.stream().filter(i -> i < 40).count();
		System.out.println(count);

		// sorted method in stream
		// in natural sorting order (ascending order_
		System.out.println("=============" + "sorted()" + "==============");
		List<Integer> sortedList = l.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedList);

		// using comparator
		// opposite to natural sorting order (descending order_
		List<Integer> sortList = l.stream().sorted((i1, i2) -> (i1 < i2) ? 1 : (i1 > i2) ? -1 : 0)
				.collect(Collectors.toList());
		System.out.println(sortList);

		// list of names
		ArrayList<String> names = new ArrayList<String>();
		names.add("Piyush");
		names.add("Kumar");
		names.add("Siddharth");
		names.add("Pradhan");
		names.add("Arushi");
		System.out.println(names);
		// natural sorting order
		List sortedNames = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sortedNames);

		// in descending order
		List sortedNamesInDesc = names.stream().sorted((n1, n2) -> n2.compareTo(n1)).collect(Collectors.toList());
		System.out.println(sortedNamesInDesc);

		// sort based on string length using comparator

		Comparator<String> c = (s1, s2) -> {
			int l1 = s1.length();
			int l2 = s2.length();
			if (l1 < l2)
				return -1;
			else if (l1 > l2)
				return 1;
			else
				return 0;
		};

		List namesSortedonLength = names.stream().sorted(c).collect(Collectors.toList());
		System.out.println(namesSortedonLength);

		// min() and max method in stream
		System.out.println("=============" + "min() && max()" + "==============");
		List<Integer> number = new ArrayList<>();
		number.add(10);
		number.add(5);
		number.add(8);
		number.add(20);
		number.add(37);
		int minnumber = number.stream().min((i1, i2) -> -i1.compareTo(i2)).get();
		System.out.println(minnumber);
		int maxnumber = number.stream().max((i1, i2) -> i1.compareTo(i2)).get();
		System.out.println(maxnumber);

		// forEach() method in stream
		System.out.println("=============" + "forEach()" + "==============");
		Consumer<Integer> co = i -> System.out.println(i);
		number.stream().forEach(co);

		// ToArray() in stream
		// ToArray() = convert stream object into array
		System.out.println("=============" + "ToArray()" + "==============");

		Integer[] arr = number.stream().toArray(Integer[]::new);
		System.out.println(arr.length);
		Stream.of(arr).forEach(System.out::println);
		
		// Stream.of() method in stream
		System.out.println("=============" + "Stream.of()" + "==============");
		Stream<Integer> stream = Stream.of(9, 99, 999, 9999);
		stream.forEach(System.out::println);

	}

}
