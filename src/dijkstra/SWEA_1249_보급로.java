package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SWEA_1249_보급로 {
	static final int INF = Integer.MAX_VALUE;

	static int N;
	static int[][] map;
	static int[][] distances;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static List<int[]> paths;

	static class Edge {
		int row;
		int col;
		int cost;

		public Edge(int row, int col, int cost) {
			this.row = row;
			this.col = col;
			this.cost = cost;
		}

		public int getRow() {
			return row;
		}

		public void setRow(int row) {
			this.row = row;
		}

		public int getCol() {
			return col;
		}

		public void setCol(int col) {
			this.col = col;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		String str;
		while (tc++ < T) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 1][N + 1];
			distances = new int[N + 1][N + 1];
			visited = new boolean[N + 1][N + 1];
			paths = new ArrayList<>();

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (!(i == 1 && j == 1 || i == N && j == N)) {
						distances[i][j] = INF;
					}
				}
			}

			for (int i = 1; i <= N; i++) {
				str = br.readLine();
				for (int j = 1; j <= N; j++) {
					map[i][j] = str.charAt(j - 1) - '0';
				}
			}

			int[] start = new int[] { 1, 1 };
			paths.add(start);
			dijkstra(start);

			for (int i = 0; i <= N; i++) {
//				System.out.println(Arrays.toString(map[i]));
				System.out.println(Arrays.toString(distances[i]));
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			System.out.println(sb);
		}
	}

	static void dijkstra(int[] start) {
		if (start[0] == N && start[1] == N)
			return;

		int row = start[0];
		int col = start[1];

		visited[row][col] = true;
		int startD = distances[row][col];

		Queue<Edge> q = new LinkedList<>();

		int min = INF;
		for (int i = 0; i < delta.length; i++) {
			int nr = row + delta[i][0];
			int nc = col + delta[i][1];

			if (nr > 0 && nr <= N && nc > 0 && nc <= N && !visited[nr][nc]) {
//				distances[nr][nc] = startD + map[nr][nc];
				int acc = startD + map[nr][nc];
				if (acc <= min) {
					min = acc;
					q.offer(new Edge(nr, nc, startD + map[nr][nc]));
				}
				if (acc != INF && acc <= min) {

				}
			}
		}

		while (!q.isEmpty()) {
			Edge e = q.poll();

			int r = e.getRow();
			int c = e.getCol();
			int cost = e.getCost();

			for (int i = 0; i < delta.length; i++) {
				int nr = r + delta[i][0];
				int nc = c + delta[i][1];

				if (nr > 0 && nr <= N && nc > 0 && nc <= N && !visited[nr][nc]) {
//					distances[nr][nc] = startD + map[nr][nc];
					q.offer(new Edge(nr, nc, startD + map[nr][nc]));
				}
			}
		}
	}

}
