package array.twodimensional;

import java.util.Scanner;

//30,260 kb
//메모리
//127 ms
//시간
//2,876
//코드길이
public class SWEA_12712_파리퇴치3 {
	static int[][] map;
	// 상, 하, 좌, 우 + 상좌, 상우, 하좌, 하우
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			// 격자
			int N = sc.nextInt();
			// 파리채 세기
			int M = sc.nextInt();

			map = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}

			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int cross = 0;
					int x = 0;

					// cross
					cross += calc(r, c, M, 0, 4);
					// x
					x += calc(r, c, M, 4, 8);

					max = Math.max(max, Math.max(cross, x));
				}
			}
			System.out.println("#" + (tc + 1) + " " + max);
		}
		sc.close();
	}

	private static int calc(int r, int c, int M, int start, int end) {
		int sum = map[r][c];
		for (int d = start; d < end; d++) {
			for (int m = 1; m < M; m++) {
				int nr = r + dr[d] * m;
				int nc = c + dc[d] * m;
				if (nr >= map.length || nr < 0 || nc >= map.length || nc < 0)
					continue;
				sum += map[nr][nc];
			}
		}
		return sum;
	}
}
