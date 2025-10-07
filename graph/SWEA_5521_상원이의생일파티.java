package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5521_상원이의생일파티 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 2~500
			// 반친구
			int N = Integer.parseInt(st.nextToken());
			// 1~10^4
			// 친한친구 관계의 수 = 간선수
			int M = Integer.parseInt(st.nextToken());
			
			// 관계 설정
			int[][] edges = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				edges[a][b] = 1;
				edges[b][a] = 1;
			}

			int[] visited = new int[N + 1];
			for (int i = 2; i <= N; i++) {
				if (edges[1][i] == 0)
					continue;
				
				visited[i] = 1;
				for (int j = 2; j <= N; j++) {
					if (edges[i][j] == 1) {
						visited[j] = 1;
					}
				}
			}

			int cnt = 0;
			for (int i = 2; i <= N; i++) {
				if (visited[i] == 1)
					cnt++;
			}

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}
	}

}
