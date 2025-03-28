package divideandconquer;

import java.util.Scanner;

public class SWEA_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			int T = sc.nextInt();

			int N = sc.nextInt();
			int C = sc.nextInt();

			System.out.println("#" + T + " " + pow(N, C));
		}
		sc.close();
	}

	private static int pow(int N, int C) {
		switch (C) {
		case 0:
			return 1;
		case 1:
			return N;
		default:
			if (C % 2 == 1) {
				int half = pow(N, (C - 1) / 2);
				return N * half * half;
			} else {
				int half = pow(N, C / 2);
				return half * half;
			}
		}
	}
}
