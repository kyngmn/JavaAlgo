package dp;

import java.util.Scanner;

public class BOJ_10870_피보나치수5 {
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n + 1];

		System.out.println(dp(n));
		sc.close();
	}

	static int dp(int n) {
		if (n == 0) {
			return 0;
		}
		if (n < 2) {
			return 1;
		}

		// 작은 것 부터 올라가므로 '바텀업'
		memo[1] = memo[2] = 1;
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}
}
