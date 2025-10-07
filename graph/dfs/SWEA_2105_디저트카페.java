package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2105_디저트카페 {
	static int N;
	static int[][] arr;
	static boolean[] visited;
	static int max = -1;
	static int[][] delta = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };
	static int[] ds = { 0, 0, 0, 0 };

	static int start;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			max = -1;
			visited = new boolean[101];

			// 4~20
			N = Integer.parseInt(br.readLine());
			arr = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					// 1~100
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			arr[1][1] = 0;
			arr[1][N] = 0;
			arr[N][1] = 0;
			arr[N][N] = 0;

//			for (int i = 0; i <= N; i++) {
//				for (int j = 0; j <= N; j++) {
//					System.out.print(arr[i][j] + " ");
//				}
//				System.out.println();
//			}

			for (int i = 1; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (visited[arr[i][j]] || arr[i][j] == 0 || (i == N - 1 && j == N - 1))
						continue;

					ds = new int[4];

					start = arr[i][j];

					int nr = i + 1;
					int nc = j + 1;
					if (start != arr[nr][nc]) {
						ds[0]++;
						dfs(nr, nc, 0);
					}
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb);
		}
	}

	static void dfs(int row, int col, int prevDelta) {
		if (arr[row][col] == start) {
			if (ds[0] == ds[2] && ds[1] == ds[3] && ds[0] > 0 && ds[1] > 0) {
				int sum = ds[0] + ds[1] + ds[2] + ds[3];
				if (sum > max) {
					max = sum;
				}
			}
			return;
		}

		int num = arr[row][col];
		visited[num] = true;
		for (int i = prevDelta; i < delta.length; i++) {
			int nr = row + delta[i][0];
			int nc = col + delta[i][1];

			if (nr > 0 && nr <= N && nc > 0 && nc <= N) {
				if (!visited[arr[nr][nc]] && arr[nr][nc] != 0) {
					ds[i]++;
					dfs(nr, nc, i);
					ds[i]--;
				}
			}
		}
		visited[num] = false;
	}
}
