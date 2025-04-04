package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1949_등산로조성 {
	static int N, K, top, ans;
	static int[][] mountain;
	static List<int[]> topCoors;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			ans = 0;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			visited = new boolean[N][N];

			top = 0;
			List<int[]> topCoors = new ArrayList<>();
			mountain = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mountain[i][j] = Integer.parseInt(st.nextToken());
					if (top < mountain[i][j]) {
						top = mountain[i][j];
						int[] temp = new int[] { i, j };
						topCoors.clear();
						topCoors.add(temp);
					} else if (top == mountain[i][j]) {
						int[] temp = new int[] { i, j };
						topCoors.add(temp);
					}
				}
			}

			for (int[] coor : topCoors) {
				dfs(coor[0], coor[1], 1, false, mountain[0][1]);
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(ans);
			System.out.println(sb);
		}
	}

	static void dfs(int r, int c, int dist, boolean isConstructed, int h) {
		if (dist > ans)
			ans = dist;

		visited[r][c] = true;

		for (int d = 0; d < delta.length; d++) {
			int nr = r + delta[d][0];
			int nc = c + delta[d][1];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				// 공사를 하지 않고 진행했을때
				if (mountain[r][c] > mountain[nr][nc]) {
					dfs(nr, nc, dist + 1, isConstructed, mountain[nr][nc]);
				}
				// 공사를 할 수 있고, 공사를 하고 진행했을 때
				else if (!isConstructed && mountain[r][c] > (mountain[nr][nc] - K)) {
					dfs(nr, nc, dist + 1, true, h - 1);
				}
				// 딱 1만 깎으면 갈 수 있는데.. 할때

			}
		}

		visited[r][c] = false;
	}
}
