package string;

import java.util.Scanner;

public class SWEA_1216_회문2 {
	static int K = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();
			sc.nextLine();

			String[] seroArr = new String[K];
			String[] garoArr = new String[K];
			for (int i = 0; i < K; i++) {
				String str = sc.nextLine();

				// 가로 체크
				garoArr[i] = str;

				// 세로 배열
				for (int j = 0; j < K; j++) {
					if (seroArr[j] == null)
						seroArr[j] = "";
					seroArr[j] += str.charAt(j);
				}
			}

			int garoMax = getMaxPalindrome(garoArr);
			int seroMax = getMaxPalindrome(seroArr);

			System.out.println("#" + N + " " + (garoMax > seroMax ? garoMax : seroMax));
		}
	}

	static int getMaxPalindrome(String[] arr) {
		int max = 0;

		// string이 담겨 있는 배열 하나씩 체크할것임
		for (int idx = 0; idx < K; idx++) {
			String str = arr[idx];
			// string 한줄에서 회문 체크할것임
			for (int i = 0; i < K; i++) {
				for (int j = K; j > i; j--) {
					int length = j - i;
					for (int x = i; x < length / 2; x++) {
						if (str.charAt(x) != str.charAt(length - 1 - x))
							break;
						if (x == length / 2 - 1 && max < length)
							max = length;
					}

//					StringBuilder sb = new StringBuilder(s);
//					if (s.equals(sb.reverse().toString()) &&max < s.length()) {
//							max = s.length();
//					}

//					String s = str.substring(i, j);
					// s가 회문인지 검사
//					max = Math.max(getPalindromeLength(s), max);
				}
			}
		}

		return max;
	}

	static int getPalindromeLength(String s) {
		for (int x = 0; x < s.length() / 2; x++) {
			if (s.charAt(x) != s.charAt(s.length() - x - 1))
				break;

			if (x == (s.length() / 2 - 1)) {
				return s.length();
			}
		}
		return 0;
	}
}
