package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_14916_거스름돈_BottomUp {
	static final int INF = Integer.MAX_VALUE;

	// 동전의 개수가 최소가 되도록!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 1];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		int[] coins = new int[] { 2, 5 };

		for (int i = 1; i <= n; i++) {
			for (int coin : coins) {
				if (i >= coin && dp[i - coin] != INF) {
					dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
				}
			}
		}

		System.out.println(dp[n] == INF ? -1 : dp[n]);
	}

}
