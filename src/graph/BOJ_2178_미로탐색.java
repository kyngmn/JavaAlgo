package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
	private static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 2 ~ 100
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) == '1' ? 1 : 0;
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		int[] start = new int[] { 0, 0, 1 };
		queue.offer(start);
		arr[0][0] = 0;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();

			for (int i = 0; i < delta.length; i++) {
				int dr = curr[0] + delta[i][0];
				int dc = curr[1] + delta[i][1];

				if (dr >= 0 && dr < N && dc >= 0 && dc < M && arr[dr][dc] == 1) {

					if (dr == N - 1 && dc == M - 1) {
						System.out.println(curr[2] + 1);
						queue.clear();
						break;
					}

					queue.offer(new int[] { dr, dc, curr[2] + 1 });
					arr[dr][dc] = 0;
				}
			}
		}
	}

}
