package functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<Integer, Integer> p = i -> i * i;
		System.out.println(p.apply(5));
		Function<String, Integer> q = i -> i.length();
		System.out.println(q.apply("sainikschooltilaiya"));
		Function<String, String> r = i -> i.toUpperCase();
		System.out.println(r.apply("sainikschooltilaiya"));
		
		
		System.out.println("==============function chaining===============");
		
		List<Integer> arr = Arrays.asList(1, 2, 4, 5, 7, 6, 7);

		Function<Integer, Integer> even = n -> {return n * n;};
		Function<Integer, Integer> num = n -> {return n * n * n;};

		for (Integer n : arr) {	
			//first even then num function is applied
			System.out.println(even.andThen(num).apply(n));
			// first num then even
			System.out.println(even.compose(num).apply(n));
		}

	}
}
