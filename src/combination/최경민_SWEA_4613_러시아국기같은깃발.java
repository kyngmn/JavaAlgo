package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최경민_SWEA_4613_러시아국기같은깃발 {
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			min = Integer.MAX_VALUE;

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			String[] strs = new String[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				strs[i] = st.nextToken();
			}

			int[][] memo = new int[N][3];
			for (int i = 0; i < N; i++) {
				for (char c : strs[i].toCharArray()) {
					if (c != 'W')
						memo[i][0]++;
					if (c != 'B')
						memo[i][1]++;
					if (c != 'R')
						memo[i][2]++;
				}
			}

			int cnt = memo[0][0] + memo[N - 1][2];

			recur(strs, memo, 1, 0, cnt);

			System.out.println("#" + tc + " " + min);
		}
	}

	public static void recur(String[] strs, int[][] memo, int idx, int prev, int cnt) {
		// min보다 커져버린 경우는 탐색하지 않겠음
		if (cnt > min)
			return;

		// 마지막줄은 검사하지 않음
		if (idx == strs.length - 1) {
			min = Math.min(cnt, min);
			return;
		}

		switch (prev) {
		case 0:
			// white, blue
			if (idx < strs.length - 2) {
				recur(strs, memo, idx + 1, 0, cnt + memo[idx][0]);
			}
			recur(strs, memo, idx + 1, 1, cnt + memo[idx][1]);
			break;
		case 1:
			// blue, red
			recur(strs, memo, idx + 1, 1, cnt + memo[idx][1]);
			recur(strs, memo, idx + 1, 2, cnt + memo[idx][2]);
			break;
		case 2:
			// red
			recur(strs, memo, idx + 1, 2, cnt + memo[idx][2]);
			break;
		}
	}
}
