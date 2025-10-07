package array.onedimensional;

import java.util.Scanner;

public class SWEA_1926_간단한369게임 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			// 숫자를 String으로
			String toStr = Integer.toString(i);

			// 3, 6, 9가 들어간 횟수를 셈
			int cnt = 0;
			for (char c : toStr.toCharArray()) {
				switch (c) {
				case '3':
					cnt++;
					break;
				case '6':
					cnt++;
					break;
				case '9':
					cnt++;
					break;
				default:
					break;
				}
			}

			// 출력할 -를 만듦
			String s = "";
			for (int j = 1; j <= cnt; j++) {
				s += "-";
			}

			System.out.print((cnt > 0 ? s : i) + (i == N ? "" : " "));
		}
	}
}
