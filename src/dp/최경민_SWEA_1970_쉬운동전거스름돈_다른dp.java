package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 돈의 최소 개수로 거슬러 주기.
public class 최경민_SWEA_1970_쉬운동전거스름돈_다른dp {
	static int[] changes = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	static int[][] dp;
	static boolean[] dpChecker;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			int cost = Integer.parseInt(br.readLine());

			// 초기화
			dp = new int[cost + 1][8];
			dpChecker = new boolean[cost + 1];

			getChanges(cost);

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append("\n");
			for (int i = 0; i < 8; i++) {
				sb.append(dp[cost][i]);
				if (i < 7) {
					sb.append(" ");
				}
			}
			System.out.println(sb);
		}
	}

	static void getChanges(int cost) {
		if (dpChecker[cost])
			return;

		int remainder = cost;
		for (int i = 0; i < changes.length; i++) {
			if (changes[i] > remainder)
				continue;
			else if (changes[i] == remainder) {
				if (!dpChecker[remainder]) {
					dpChecker[remainder] = true;
					dp[remainder][i]++;
				}
				dp[cost][i] = dp[remainder][i];
			} else {
				int cnt = remainder / changes[i];
				int cleanCost = cnt * changes[i];

				if (!dpChecker[cleanCost]) {
					dpChecker[cleanCost] = true;
					if (remainder == cleanCost) {
						dp[remainder][i] = cnt;
					} else {
						dp[cleanCost][i] = cnt;
					}
				}

				dp[cost][i] = dp[cleanCost][i];
				remainder -= cleanCost;
			}
		}
	}
}
