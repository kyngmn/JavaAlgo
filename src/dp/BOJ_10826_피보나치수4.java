package dp;

import java.math.BigInteger;
import java.util.Scanner;

public class BOJ_10826_피보나치수4 {
	static BigInteger[] memo;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new BigInteger[n + 1];

		System.out.println(dp(n));
		sc.close();
	}

	static BigInteger dp(int n) {
		if (n == 0) {
			memo[0] = new BigInteger("0");
			return memo[0];
		}
		if (n == 1) {
			memo[1] = new BigInteger("1");
			return memo[1];
		}

		// 작은 것 부터 올라가므로 '바텀업'
		memo[1] = memo[2] = BigInteger.valueOf(1);
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i - 1].add(memo[i - 2]);
		}
		return memo[n];
	}
}
