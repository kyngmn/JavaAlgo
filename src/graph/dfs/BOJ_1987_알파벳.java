package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
	static int R; // 세로 -> row
	static int C; // 가로 -> col
	static char[][] arr;
	static boolean[][] visited;
	static Map<Character, Boolean> visitedMap;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1~R,C~20
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R + 1][C + 1];
		visited = new boolean[R + 1][C + 1];

		String str;
		visitedMap = new HashMap<>();
		for (int i = 1; i <= R; i++) {
			str = br.readLine();
			for (int j = 0; j < C; j++) {
				char c = str.charAt(j);
				arr[i][j + 1] = c;
				if (!visitedMap.containsKey(c)) {
					visitedMap.put(c, false);
				}
			}
		}

//		for (int i = 0; i <= R; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}

		// 1은 무조건 통과하니까
		visited[1][1] = true;
		visitedMap.replace(arr[1][1], true);
		dfs(1, 1, 1);

		System.out.println(max);
	}

	static void dfs(int row, int col, int depth) {
		visited[row][col] = true;
		visitedMap.replace(arr[row][col], true);

		if (depth > max) {
			max = depth;
		}

		for (int i = 0; i < delta.length; i++) {
			int nr = row + delta[i][0];
			int nc = col + delta[i][1];
			if (nr > 0 && nr <= R && nc > 0 && nc <= C && !visited[nr][nc] && !visitedMap.get(arr[nr][nc])) {
				dfs(nr, nc, depth + 1);
			}
		}

		// 원복
		visited[row][col] = false;
		visitedMap.replace(arr[row][col], false);
	}
}
