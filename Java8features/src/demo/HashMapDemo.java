package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<Integer, String> h = new HashMap<Integer, String>();
		h.put(1, "piyush");
		h.put(2, "piku");
		h.put(3, "priyoshi");
		h.put(4, "aarushi");
		System.out.println(h);
		System.out.println(h.keySet());
		System.out.println(h.values());
		System.out.println(h.containsValue("piku"));
		System.out.println(h.containsKey(1));

		List<String> l = new ArrayList<>();
		l.addAll(h.values());
		System.out.println(l);
	}
}
