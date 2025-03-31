package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 최경민_BOJ_2667_단지번호붙이기 {
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int cnt;
	static List<Integer> list = new ArrayList<>();
	static int currentBlockIndex = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 5~25
		N = Integer.parseInt(br.readLine());

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

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!isValid(i, j))
					continue;

				cnt++;
				visited[i][j] = true;
				currentBlockIndex++;
				list.add(1);
				dfs(i, j);
			}
		}

		System.out.println(cnt);

		list.sort(null);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	static void dfs(int currRow, int currCol) {
		for (int i = 0; i < delta.length; i++) {
			int nr = currRow + delta[i][0];
			int nc = currCol + delta[i][1];
			if (nr >= 0 && nr <= N && nc >= 0 && nc <= N && isValid(nr, nc)) {
				visited[nr][nc] = true;
				list.set(currentBlockIndex, list.get(currentBlockIndex) + 1);
				dfs(nr, nc);
			}
		}
	}

	static boolean isValid(int row, int col) {
		return !visited[row][col] && map[row][col] == 1;
	}
}
