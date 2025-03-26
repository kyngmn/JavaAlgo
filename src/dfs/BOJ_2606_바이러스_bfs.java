package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2606_바이러스_bfs {
	static int[][] arr;
	static boolean[] visited;

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

		int cnt = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[curr][i] == 1) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
}
