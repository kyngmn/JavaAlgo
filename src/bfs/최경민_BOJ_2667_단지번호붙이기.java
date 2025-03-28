package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 최경민_BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 5~25
		N = Integer.parseInt(br.readLine());
		// 배열 초기화
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		String str;
		for (int r = 1; r <= N; r++) {
			str = br.readLine();
			for (int c = 1; c <= N; c++) {
				map[r][c] = str.charAt(c - 1) == '1' ? 1 : 0;
			}
		}

//		for (int i = 1; i < map.length; i++) {
//			for (int j = 1; j < map[i].length; j++) {
//				System.out.print(map[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}

		List<Integer> list = new ArrayList<>();
		Queue<int[]> q = new LinkedList<>();
		int cnt = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!isValid(i, j))
					continue;

				cnt++;

				int sum = 1;
				q.add(new int[] { i, j });
				visited[i][j] = true;

				while (!q.isEmpty()) {
					int[] curr = q.poll();

					for (int di = 0; di < delta.length; di++) {
						int nr = curr[0] + delta[di][0];
						int nc = curr[1] + delta[di][1];
						if (isValid(nr, nc)) {

							q.add(new int[] { nr, nc });
							visited[nr][nc] = true;
							sum++;
						}
					}
				}

				list.add(sum);
			}
		}

		System.out.println(cnt);
		list.sort(null);
		for (Integer x : list) {
			System.out.println(x);
		}
	}

	static boolean isValid(int row, int col) {
		return row > 0 && row <= N && col > 0 && col <= N && !visited[row][col] && map[row][col] == 1;
	}
}
