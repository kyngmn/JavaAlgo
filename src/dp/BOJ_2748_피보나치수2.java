package dp;

import java.util.Scanner;

public class BOJ_2748_피보나치수2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if (n < 2) {
			System.out.println(1);
			return;
		}

		// 숫자가 커질 수 있음에 주의!
		long[] memo = new long[n + 1];
		// 작은 것 부터 올라가므로 '바텀업'
		memo[1] = memo[2] = 1;
		for (int i = 3; i < memo.length; i++) {
			memo[i] = memo[i - 1] + memo[i - 2];
		}
		System.out.println(memo[n]);
		sc.close();
	}
}
