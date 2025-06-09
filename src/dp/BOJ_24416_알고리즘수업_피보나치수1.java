package dp;

import java.util.Scanner;

public class BOJ_24416_알고리즘수업_피보나치수1 {
	static int recur = 1, dp = 1;
	static int[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		memo = new int[N + 1];

		recur(N);
		dp(N);

		System.out.println(recur + " " + dp);
		sc.close();
	}

	static int recur(int n) {

		if (n == 1 || n == 2) {
			return 1;
		}

		recur++;
		return recur(n - 1) + recur(n - 2);
	}

	static int dp(int n) {
		memo[1] = memo[2] = 1;

		for (int i = 3; i < memo.length - 1; i++) {
			dp++;
			memo[i] = memo[i - 1] + memo[i - 2];
		}

		return memo[n];
	}
}
