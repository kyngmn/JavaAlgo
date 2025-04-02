package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 여러 방식으로 풀 수 있어서 좋은
public class BOJ_17070_파이프옮기기1 {
	static int N;
	static int[][] adj;
	static boolean[][] visited;
	// 빈칸이어야 하는 경우
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 1, 1 } };

	// 1-> row, 2-> col, 3-> 방향 가로0, 대각선1, 세로2
	static int[][][] dp;

	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 3~16
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1][N + 1];
		adj = new int[N + 1][N + 1];

		dp = new int[N + 1][N + 1][3];

		StringTokenizer st;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if (adj[1][1] != 1 && adj[1][2] != 1) {
			// 초기화
			visited[1][1] = visited[1][2] = true;
			dp[1][2][0] = 1;

			// N,N으로 이동시키는 방법의 개수.....
			dfs(1, 1, 1, 2);
		}
		System.out.println(cnt);
	}

	static void dfs(int prevR, int prevC, int currR, int currC) {
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(visited[i]));
//		}
//		System.out.println();
		if (currR == N && currC == N) {
			cnt++;
		}

		boolean sameRow = prevR == currR;
		boolean sameCol = prevC == currC;

		for (int d = 0; d < delta.length; d++) {
			if (sameRow && !sameCol && d == 1 || !sameRow && sameCol && d == 0) {
				continue;
			}

			// 갈 수 있는 경로 검사
			int dr = delta[d][0];
			int dc = delta[d][1];
			int nr = currR + dr;
			int nc = currC + dc;

			if (isValid(currR, currC, nr, nc)) {
				if (d != 2 || d == 2 && isValid(currR, currC, nr, nc - 1) && isValid(currR, currC, nr - 1, nc)) {
					visited[nr][nc] = true;

					dfs(currR, currC, nr, nc);

					visited[nr][nc] = false;
				}
			}
		}
	}

	static boolean isValid(int currR, int currC, int nr, int nc) {
		return nr >= currR && nr <= N && nc >= currC && nc <= N && adj[nr][nc] == 0;
	}
}
