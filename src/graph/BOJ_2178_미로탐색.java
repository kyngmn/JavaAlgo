package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	private static int N;
	private static int M;
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static int min = Integer.MAX_VALUE;
	private static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 2 ~ 100
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) == '1' ? 1 : 0;
			}
		}

		bfs(0, 0, 1);
		System.out.println(min);
	}

	private static void bfs(int currRow, int currCol, int acc) {
		if (currRow == N - 1 && currCol == M - 1 || acc > min) {
			if (min > acc) {
				min = acc;
			}
			return;
		}

		arr[currRow][currCol] = 0;

		for (int i = 0; i < delta.length; i++) {
			int dr = currRow + delta[i][0];
			int dc = currCol + delta[i][1];

			if (dr >= 0 && dr < N && dc >= 0 && dc < M && arr[dr][dc] == 1) {
				bfs(dr, dc, acc + 1);
				
				// 원복
				arr[dr][dc] = 1;
			}
		}
	}
}
