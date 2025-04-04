package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1952_수영장 {
	static int[] prices;
	static int[] plans;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			// 1일, 1달, 3달, 1년
			prices = new int[4];
			for (int i = 0; i < 4; i++) {
				prices[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());

			// 12월 계획
			plans = new int[12];
			visited = new boolean[12];
			for (int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			if (min > prices[3]) {
				min = prices[3];
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(min);
			System.out.println(sb);
		}
	}

	static void dfs(int curr, int acc) {
		if (acc >= prices[3] || acc >= min)
			return;

		if (curr >= 12) {
			if (acc < min) {
				min = acc;
			}
			return;
		}

		// 1일
		dfs(curr + 1, acc + plans[curr] * prices[0]);
		// 1달
		dfs(curr + 1, acc + prices[1]);
		// 3달
		dfs(curr + 3, acc + prices[2]);
	}
}
