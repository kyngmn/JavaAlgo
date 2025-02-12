package string;

import java.util.Scanner;

public class 최경민_SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= T; tc++) {
			String s = sc.nextLine();
//			boolean isPalindrome = checkIsPalindrome(s);
			boolean isPalindrome = checkIsPalindromeStringBuilder(s);
			System.out.println("#" + tc + " " + (isPalindrome ? 1 : 0));
		}

		sc.close();
	}

//	26,368 kb
//	메모리
//	101 ms
//	실행시간
//	2,251
//	코드길이
	static boolean checkIsPalindrome(String s) {
		boolean isPalindrome = true;
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

//	26,368 kb
//	메모리
//	97 ms
//	실행시간
//	2,165
//	코드길이
	static boolean checkIsPalindromeStringBuilder(String s) {
		StringBuilder sb = new StringBuilder(s);
		return s.equals(sb.reverse().toString());
	}
}
