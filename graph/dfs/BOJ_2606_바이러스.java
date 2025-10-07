package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스 {
	static int[][] arr;
	static boolean[] visited;

	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 컴퓨터수 ~100
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());

		StringTokenizer st;

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a][b] = arr[b][a] = 1;
		}

		visited[1] = true;
		dfs(1);

		System.out.println(cnt);
	}

	static void dfs(int curr) {
		for (int i = 1; i < arr[curr].length; i++) {
			if (!visited[i] && arr[curr][i] == 1) {
				visited[i] = true;
				cnt++;
				dfs(i);
			}
		}
	}
}
