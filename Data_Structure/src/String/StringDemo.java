package String;

import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {

		String[] str1 = { "jhjjhjf" };
		String str = "welcome  to     java";
		int ch;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. length of String " + "2. Changing to case" + "3. Toggle the character"
					+ "4. counting vowels " + "5. counting word " + " 6. validate string " + " 7. reverse String"
					+ "8. Comparing String " + " 9. Palindrome" + " 10. duplicate in String" + "11. Anagram");

			ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("length of String " + stringLength(str));
				break;
			case 2:
				System.out.println("string is " + toUpperCases(str1).toString());
				break;
			case 4:
				int[] Vcount = countVowel(str);
				System.out.println(" vcount is  " + Vcount[0] + " " + Vcount[1]);
				break;
			case 5:
				System.out.println("Number of word " + countWord(str));

			}
		}

	}

	static int stringLength(String str) {

		int length = 0;
		for (char s : str.toCharArray()) {
			length++;
		}

		return length;

	}

	static String[] toUpperCases(String[] str) {

		for (int i = 0; i < str.length; i++) {

			str[i] = str[i] + 32;
		}
		return str;

	}

	static int[] countVowel(String str) {

		int vcount = 0;
		int scount = 0;

		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == 'A' || str.charAt(i) == 'E' || str.charAt(i) == 'I' || str.charAt(i) == 'O'
					|| str.charAt(i) == 'U' || str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i'
					|| str.charAt(i) == 'o' || str.charAt(i) == 'u')
				vcount++;
			else {
				scount++;
			}
		}
		return new int[] { vcount, scount };
	}

	// count the word in string
	
	static int countWord(String str) {
		int wcount = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) == ' ' && str.charAt(i - 1) != ' ') {
				wcount++;
			}
		}
		return wcount + 1;

	}
}
