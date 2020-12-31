package array;

import java.util.Scanner;

public class ArrayDemo {

	static int size = 0;
	static int index = 0;

	public static void main(String[] args) {

		int[] arr = new int[25];
		int[] arr1 = { 5, 10, 15, 20, 25, 30 };
		int[] arr2 = { 5, 10, 45, 50 };
		int[] arr4 = { 5, 10, 40, 23, 70, 4, 1 };
		int[] arr3 = new int[20];

		System.out.println(arr1.length);
		int ch;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out
					.println("1. Display " + "2. Insert " + "3.Delete " + "4.Linear " + "5. Swap " + "6. Binary Search "
							+ "7. Get " + "8.Set " + "9. Max " + "10. Min " + "11. Reserse " + "12. Merging"
							+ " 13. Union " + "14. Intersection " + "15. difference " + "16 .Rearrange" + "17. Sort");

			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("Array elements are");
				Display(arr4);
				break;

			case 2:
				System.out.println("enter the number");
				int ele = sc.nextInt();
				System.out.println("enter the index");
				int indx = sc.nextInt();
				Insert(arr, indx, ele);
				break;
			case 3:
				System.out.println("enter the index");
				int index = sc.nextInt();
				int deletedElement = Delete(arr1, index);
				System.out.println("DeletedElement " + deletedElement);
			case 4:
				System.out.println("enter the number");
				int key = sc.nextInt();
				System.out.println(" found at index " + LinearSearch(arr1, key));
				break;
			case 5:
				System.out.println("enter index1");
				int index1 = sc.nextInt();
				System.out.println("enter index2");
				int index2 = sc.nextInt();
				swap(arr1, index1, index2);
				break;
			case 6:
				System.out.println("element fount at " + BinarySearch(arr1, 90));
				break;
			case 7:
				System.out.println("enter element");
				int gele = sc.nextInt();
				System.out.println("element is " + Get(arr1, gele));
				break;
			case 8:
				System.out.println("enter the element to be set");
				int setele = sc.nextInt();
				System.out.println("enter the index where to set element");
				int inx = sc.nextInt();
				set(arr1, inx, setele);
				break;
			case 9:
				System.out.println("max element is " + Max(arr1));
				break;
			case 10:
				System.out.println("min element is " + Min(arr1));
				break;
			case 11:
				ReverseInPlace(arr1);
				break;
			case 12:
				Merging(arr1, arr2, arr3);
				break;
			case 13:
				Union(arr1, arr2, arr3);
				break;
			case 14:
				Intersection(arr1, arr2, arr3);
				break;
			case 15:
				Difference(arr1, arr2, arr3);
				break;
			case 16:
				Rearrange(arr4);
				break;
			case 17:
				sort(arr4);
				break;
			case 18:
				System.out.println(checkArraySort(arr4));
				break;
			}
		}

	}

	// function to display array element

	static void Display(int[] arr) {
		int i = 0;
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Insert element into an array
	static void Insert(int[] arr, int index, int element) {

		int i = 0;
		if (index >= 0 && index <= arr.length) {

			for (i = size; i > index; i--) {

				arr[i] = arr[i - 1];
			}

			arr[index] = element;
			size++;

		}
	}

	// Delete an element from an array

	static int Delete(int arr1[], int index) {
		if (index >= 0 && index < arr1.length) {
			int deletedElement;
			deletedElement = arr1[index];
			for (int i = index; i < arr1.length - 1; i++) {
				arr1[i] = arr1[i + 1];
			}
			return deletedElement;
		}
		return -1;
	}

	// Searching a element in an array

	static int LinearSearch(int[] arr1, int key) {
		for (int i = 0; i < arr1.length - 1; i++) {
			if (key == arr1[i]) {
				// swap(arr1[i],arr1[i-1]);
				return i;
			}
		}
		return -1;
	}

	// swapping two element
	static void swap(int[] arr, int index1, int index2) {

		int temp;
		temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;

	}

	// Binary Search in an Array

	static int BinarySearch(int arr1[], int ele) {
		int l = 0;
		int h = arr1.length - 1;
		int mid = 0;
		mid = (l + h) / 2;

		if (ele == arr1[mid])
			return mid;
		else if (ele < arr1[mid]) {
			h = mid - 1;
		} else {
			l = mid + 1;
		}
		return -1;
	}

	// Get a element from array
	static int Get(int[] arr1, int index) {
		if (index >= 0 && index < arr1.length - 1) {
			return arr1[index];
		}
		return -1;
	}

	static void set(int[] arr1, int index, int element) {

		if (index >= 0 && index < arr1.length - 1) {
			arr1[index] = element;
		}
	}

	// Maximum element in an array

	static int Max(int[] arr1) {

		int max = arr1[0];

		for (int i = 0; i <= arr1.length - 1; i++) {
			if (arr1[i] > max) {
				max = arr1[i];
			}
		}
		return max;
	}

	// Minimum element in an array

	static int Min(int[] arr1) {

		int min = arr1[0];

		for (int i = 0; i <= arr1.length - 1; i++) {
			if (arr1[i] < min) {
				min = arr1[i];
			}
		}
		return min;
	}

	// Reverse an array taking another array
	static int[] Reverse(int[] arr1) {
		int[] rev = new int[20];
		int i = 0;
		int j = 0;
		for (i = arr1.length - 1; i >= 0; i--) {
			rev[j] = arr1[i];
			j++;
		}
		for (i = 0; i <= arr1.length - 1; i++) {
			arr1[i] = rev[i];
		}
		return arr1;
	}

	// Reversing an array in place

	static int[] ReverseInPlace(int[] arr1) {

		int i = 0;
		int j = 0;
		int temp = 0;

		for (i = 0, j = arr1.length - 1; i < j; i++, j--) {

			temp = arr1[i];
			arr1[i] = arr1[j];
			arr1[j] = temp;
		}
		return arr1;
	}

	// merging two array

	static int[] Merging(int[] arr1, int[] arr2, int[] arr3) {

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				k++;
				i++;
			} else {
				arr3[k] = arr2[j];
				k++;
				j++;
			}
		}

		for (; i <= arr1.length - 1; i++) {
			arr3[k] = arr1[i];
			k++;
		}

		for (; j <= arr2.length - 1; j++) {
			arr3[k] = arr2[j];
			k++;
		}
		return arr3;

	}

	// union of two sorted array
	static int[] Union(int[] arr1, int[] arr2, int arr3[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				k++;
				i++;
			} else if (arr2[j] < arr1[i]) {
				arr3[k] = arr2[j];
				k++;
				j++;
			} else {
				arr3[k] = arr2[i];
				k++;
				j++;
				i++;
			}
		}

		for (; i <= arr1.length - 1; i++) {
			arr3[k] = arr1[i];
			k++;
		}

		for (; j <= arr2.length - 1; j++) {
			arr3[k] = arr2[j];
			k++;
		}
		return arr3;
	}

	static int[] Intersection(int[] arr1, int[] arr2, int arr3[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {

				k++;
				i++;
			} else if (arr2[j] < arr1[i]) {

				k++;
				j++;
			} else {
				arr3[k] = arr2[i];
				k++;
				j++;
				i++;
			}
		}
		return arr3;
	}

	// difference of two set
	static int[] Difference(int[] arr1, int[] arr2, int arr3[]) {
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length) {
			if (arr1[i] < arr2[j]) {
				arr3[k] = arr1[i];
				k++;
				i++;
			} else if (arr2[j] < arr1[i]) {
				j++;
			} else {
				j++;
				i++;
			}
		}
		return arr3;
	}

	// Rearrange the array based positive and negative numbers

	static int[] Rearrange(int[] arr4) {
		int i = 0;
		int j = arr4.length - 1;
		while (i <= j) {
			while (arr4[i] < 0) {
				i++;
			}
			while (arr4[j] >= 0) {
				j--;
			}

			if (i < j) {
//				int temp;
//				temp = arr4[i];
//				arr4[i] = arr4[j];
//				arr4[j] = temp;
				swap(arr4, i, j);

			}

		}
		return arr4;
	}

	// sort the array
	static int[] sort(int[] arr) {

		for (int i = 0; i <= arr.length; i++) {

			for (int j = i + 1; j <= arr.length - 1; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		return arr;

	}

	// to check array is sorted

	static int checkArraySort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return 0;
			}
		}
		return 1;
	}
}
