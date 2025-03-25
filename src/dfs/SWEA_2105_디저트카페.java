package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	static int[][] arr;
	static boolean[] visited;
	static int max = -1;
	static int[][] delta = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			max = -1;

			int N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; i <= N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb);
		}
	}

	static void dfs(int curr) {

	}
}
