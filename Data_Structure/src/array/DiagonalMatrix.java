package array;

import java.util.Scanner;

public class DiagonalMatrix {

	public static void main(String[] args) {

		int i, j, n, x;
		Scanner sc = new Scanner(System.in);
		System.out.println(" enter the dimension");
		n = sc.nextInt();
		int[] arr = new int[n];
		System.out.println(" enter the element in matrix");

		for (i = 1; i <= n; i++) {

			for (j = 1; j <= n; j++) {
				x = sc.nextInt();
				if (i == j)
					arr[i - 1] = x;

			}
		}

		
		
		for (i = 1; i <=n; i++) {

			for (j= 1; j <=n; j++) {
				
				if (i == j)
					System.out.print(arr[i-1] +" ");
				else
					System.out.print("0" + " ");

			}
			System.out.println();
		}
	}

}
