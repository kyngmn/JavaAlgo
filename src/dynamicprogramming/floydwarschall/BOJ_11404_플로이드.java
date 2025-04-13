package dynamicprogramming.floydwarschall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11404_플로이드 {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				
		// 도시 개수
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());


		int[][] adj = new int[N][N];
		int[][] dist = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());

				if (i != j) {
					if (adj[i][j] == 0) {
						dist[i][j] = INF;
					} else {
						dist[i][j] = 1;
					}
				}
			}
		}

		for (int k = 0; k < adj.length; k++) {
			for (int i = 0; i < adj.length; i++) {
				for (int j = 0; j < adj.length; j++) {
					if (i == j || dist[i][k] == INF || dist[k][j] == INF)
						continue;

					if (dist[i][k] + dist[k][j] < dist[i][j]) {
						dist[i][j] = dist[i][k] + dist[k][j];
					}
				}
			}
		}

		int res = INF;
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += dist[i][j];
			}

			res = Math.min(res, sum);
		}
	}
}
