package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656_벽돌깨기 {
	// 1~4
	static int N;
	// 2~12
	static int W;
	// 2~15
	static int H;
	static int[][] map;
	static int[][] dp;
	static boolean[][] temp;

	static int[] ans;
	static int max = Integer.MIN_VALUE;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			dp = new int[H][W];

			int sum = 0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dp[i][j] = (map[i][j] == 1) ? 1 : Integer.MAX_VALUE;
					if (map[i][j] > 0)
						sum++;
				}
			}

			ans = new int[W];
			boolean[][] broken = new boolean[H][W];
			for (int j = 0; j < W; j++) {
				for (int i = 0; i < H; i++) {
					if (map[i][j] > 0) {
						boolean[][] temp = breakBricks(i, j);
//						ans[j] = res;
						break;
					}
				}
			}

			System.out.println(Arrays.toString(ans));

			max = Integer.MIN_VALUE;
			comb(new boolean[W], new int[N], 0, 0, 0);

//			System.out.println(sum - max);

//			for (int i = 0; i < H; i++) {
//				System.out.println(Arrays.toString(dp[i]));
//			}

			System.out.println("#" + tc + " ");
		}

	}

	static void comb(boolean[] used, int[] arr, int startIdx, int currentIdx, int selected) {
		if (selected == N) {
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			if (max < sum) {
				max = sum;
			}
			return;
		}

		for (int i = startIdx; i < ans.length; i++) {
			if (used[i])
				continue;

			used[i] = true;
			arr[currentIdx] = ans[i];
			comb(used, arr, i, currentIdx + 1, selected + 1);
			used[i] = false;
		}
	}

	static boolean[][] breakBricks(int startRow, int startCol) {
		boolean[][] temp = new boolean[H][W];
		Queue<int[]> q = new LinkedList<>();

		int cnt = 0;

		q.offer(new int[] { startRow, startCol });
		temp[startRow][startCol] = true;
		cnt++;

		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int row = curr[0];
			int col = curr[1];
			int power = map[row][col];

			for (int p = 1; p < power; p++) {
				for (int d = 0; d < delta.length; d++) {
					int nr = row + delta[d][0] * p;
					int nc = col + delta[d][1] * p;

					if (nr >= 0 && nr < H && nc >= 0 && nc < W && map[nr][nc] > 0 && !temp[nr][nc]) {
						q.offer(new int[] { nr, nc });
						temp[nr][nc] = true;
						cnt++;
					}
				}
			}
		}

		for (int i = 0; i < temp.length; i++) {
			System.out.println(Arrays.toString(temp[i]));
		}
		System.out.println();

		return temp;
	}

}
