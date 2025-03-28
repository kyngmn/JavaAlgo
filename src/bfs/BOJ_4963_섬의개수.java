package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4963_섬의개수 {
	static int col;
	static int row;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine());

			// c -> w
			// h -> h
			col = Integer.parseInt(st.nextToken());
			row = Integer.parseInt(st.nextToken());

			if (col == 0 || row == 0)
				break;

			map = new int[row + 1][col + 1];
			visited = new boolean[row + 1][col + 1];

			for (int r = 1; r <= row; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 1; c <= col; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

//			for (int i = 1; i < map.length; i++) {
//				for (int j = 1; j < map[i].length; j++) {
//					System.out.print(map[i][j]);
//					System.out.print(" ");
//				}
//				System.out.println();
//			}

			Queue<int[]> q = new LinkedList<>();

			int cnt = 0;
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					if (visited[i][j] || map[i][j] == 0)
						continue;

					cnt++;
					visited[i][j] = true;

					q.add(new int[] { i, j });
					while (!q.isEmpty()) {
						int[] curr = q.poll();

						for (int di = 0; di < delta.length; di++) {
							int nr = curr[0] + delta[di][0];
							int nc = curr[1] + delta[di][1];
							if (nr > 0 && nr <= row && nc > 0 && nc <= col && !visited[nr][nc] && map[nr][nc] == 1) {
								q.add(new int[] { nr, nc });
								visited[nr][nc] = true;
							}
						}
					}
				}
			}

			System.out.println(cnt);
		}
	}
}
