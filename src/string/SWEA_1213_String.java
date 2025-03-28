package string;

import java.util.Scanner;

public class SWEA_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextLine();
			String keyword = sc.nextLine();
			String s = sc.nextLine();
//			int num = bruteForce(s, keyword);
			int num = boyerMoore(s, keyword);
			System.out.println("#" + tc + " " + num);
		}
		sc.close();
	}

//	27,776 kb
//	메모리
//	117 ms
//	실행시간
//	2,271
//	코드길이
	static int bruteForce(String s, String keyword) {
		int N = s.length();
		int M = keyword.length();

		int cnt = 0;

		for (int i = 0; i < N - M + 1; i++) {
			// 문자열 비교할 때 꼭 equals사용하기!
			if (s.substring(i, i + M).equals(keyword))
				cnt++;
		}
		return cnt;
	}

//	28,032 kb
//	메모리
//	111 ms
//	실행시간
//	2,309
//	코드길이
	static int boyerMoore(String s, String keyword) {
		int N = s.length();
		int M = keyword.length();

		int cnt = 0;

		for (int i = M - 1; i < N; i++) {
			for (int j = M - 1; j >= 0; j--) {
				if (keyword.charAt(j) != s.charAt(i - (M - 1 - j)))
					break;

				if (j == 0)
					cnt++;
			}
		}

		return cnt;
	}
}
