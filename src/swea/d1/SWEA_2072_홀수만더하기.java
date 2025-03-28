package swea.d1;

import java.util.Scanner;

public class SWEA_2072_홀수만더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int N = 10;
			int res = 0;
			for (int i = 0; i < N; i++) {
				int num = sc.nextInt();
				if (num % 2 == 1)
					res += num;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
