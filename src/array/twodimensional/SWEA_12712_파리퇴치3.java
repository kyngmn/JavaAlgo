package array.twodimensional;

import java.util.Scanner;

public class SWEA_12712_파리퇴치3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			// 격자
			int N = sc.nextInt();
			// 파리채 세기
			int M = sc.nextInt();

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int max = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int center = arr[r][c];
					// + 로 잡기
					int cross = center;
					// x 로 잡기
					int x = center;
					for (int i = 1; i < M; i++) {
						// 행열 인덱스의 경계값 처리..
						if (r + i < N) {
							// 아래
							cross += arr[r + i][c];
							if (c + i < N) {
								// 5시 방향
								x += arr[r + i][c + i];
							}
							if (c - i >= 0) {
								// 1시방향
								x += arr[r + i][c - i];
							}
						}
						if (r - i >= 0) {
							// 위
							cross += arr[r - i][c];
							if (c + i < N) {
								// 7시 방향
								x += arr[r - i][c + i];
							}
							if (c - i >= 0) {
								// 11시 방향
								x += arr[r - i][c - i];
							}
						}

						if (c + i < N) {
							// 우
							cross += arr[r][c + i];
						}
						if (c - i >= 0) {
							// 좌
							cross += arr[r][c - i];
						}
					}
					max = Math.max(Math.max(cross, x), max);
				}
			}
			System.out.println("#" + (tc + 1) + " " + max);
		}
		sc.close();
	}
}
