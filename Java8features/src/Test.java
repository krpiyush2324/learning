
interface left {
	public void m();

	default void m1() {
		System.out.println("left interface");
	};

}

interface right {
	default void m1() {
		System.out.println("right interface");
	};

}

interface demo {
	public static int add(int a, int b) {
		return a + b;
	};
}

public class Test implements demo {

	public static void main(String[] args) {

		System.out.println(demo.add(10, 20));
	
		Test obj = new Test();
		
	}

}
