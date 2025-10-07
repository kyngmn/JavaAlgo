package dp;

import java.util.Scanner;

public class BOJ_2749_피보나치수3 {
	static int m = 1_000_000;
	static long[][] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();

		memo = new long[N + 1][N + 1];

		System.out.println(dp(N));

		sc.close();
	}

	static long dp(int n) {
		if (n == 0) {
			memo[0] = 0;
			return memo[0];
		}

		memo[1] = memo[2] = 1;
		// 작은 것 부터 올라가므로 '바텀업'
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
			memo[i] %= m;
		}
		return memo[n];
	}
}
