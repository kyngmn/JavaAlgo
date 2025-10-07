package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2112_보호필름 {
	static int D, W, K, ans;
	static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			ans = 0;

			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			arr = new int[D][W];

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[] isOK = new boolean[W];

			for (int j = 0; j < W; j++) {
				int prev = arr[0][j];
				int acc = 1;

				for (int i = 1; i < D; i++) {
					if (arr[i][j] == prev) {
						acc++;
					} else {
						prev = arr[0][j];
						acc = 1;
					}

					if (acc >= K) {
//						심사 통과
					}
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb);
		}
	}

	static void makeFile(int idx, int cnt) {
		if (idx == D) {
			return;
		}
	}
}
