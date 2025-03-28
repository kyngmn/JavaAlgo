package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {
	static int N;
	static int M;

	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int cnt;

	static int[] parent;
	
	static Queue<Integer> outlines = new LinkedList<>();
	
	static int[][] weights;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		

		// 지도 받기
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 개수 세기
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= M; c++) {
				if (!visited[r][c] && map[r][c] == 1) {
					visited[r][c] = true;
					cnt++;
					countIslands(r, c);
				}
			}
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		weights = new int[N + 1][M + 1];

		for (int i = 1; i <= cnt; i++) {
			parent[i] = i;
		}
	}

	static void countIslands(int r, int c) {
		Queue<int[]> q = new LinkedList<>();

		q.add(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] coor = q.poll();
			for (int i = 0; i < delta.length; i++) {
				int nr = coor[0] + delta[i][0];
				int nc = coor[1] + delta[i][1];
				if (nr > 0 && nr <= N & nc > 0 && nc <= M && !visited[nr][nc]) {
					if (map[nr][nc] == 1) {
						visited[nr][nc] = true;
						q.add(new int[] { nr, nc });
					}else {
						
					}
				}
			}
		}
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		parent[rootB] = rootA;
	}

	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}

}
