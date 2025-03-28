package array.twodimensional;

import java.util.Scanner;

public class 최경민_SWEA_2001_파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			// 격자
			int N = sc.nextInt();
			// 파리채 격자
			int M = sc.nextInt();

			// 격자 채우기
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			// 맨 좌우측을 정점으로 잡아서 합을 계산할 것
			int max = 0;
			for (int r = 0; r < N - M + 1; r++) {
				for (int c = 0; c < N - M + 1; c++) {
					int sum = 0;

					// [r][c] [r+1][c] ...[r+M-1][c]
					// ...
					// [r+M-1][c] ... [r+M-1][c+M-1]
					for (int dr = 0; dr < M; dr++) {
						for (int dc = 0; dc < M; dc++) {
							sum += arr[r + dr][c + dc];
						}
					}
					
					if (max < sum)
						max = sum;
				}
			}
			System.out.println("#" + (tc + 1) + " " + max);
		}
		sc.close();
	}
}
