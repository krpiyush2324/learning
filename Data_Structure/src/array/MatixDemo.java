package array;

import java.util.Scanner;

public class MatixDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int ch, n, i = 0, j = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter the dimension");
		n = sc.nextInt();
		int[] arr = new int[n];

		while (true) {

			System.out.println("1. Diagonal " + "2. Display");

			System.out.println("============ enter the choice ============");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println(" Enter the element in the matrix");
				System.out.println(" index i");
				i = sc.nextInt();
				System.out.println(" index j");
				j = sc.nextInt();
				System.out.println(" enter element");
				n = sc.nextInt();
				set(arr, i, j, n);
				break;
			case 2:
				display(arr);

			}

		}
	}

	static void set(int[] arr, int i, int j, int x) {

		if (i == j) {
			arr[i - 1] = x;
		}
	}

	static void display(int[] arr) {

		int i, j;
		for (i = 0; i < arr.length; i++) {
			for (j = 0; j < arr.length; j++) {
				if (i == j) {

					System.out.println(arr[i - 1] + " ");
				}
				System.out.println();
			}
		}
	}
}
