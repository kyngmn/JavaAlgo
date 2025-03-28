package string;

import java.util.Scanner;


public class 경비원 {
	// 상, 하, 좌, 우
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int R = sc.nextInt();
			int[][] arr = new int[R][R];

			int startRow = 0;
			int startCol = 0;
			for (int r = 0; r < R; r++) {
				for (int c = 0; c < R; c++) {
					// 0, 1, 2 중 하나
					arr[r][c] = sc.nextInt();

					// 경비원의 위치 따기
					if (arr[r][c] == 2) {
						startRow = r;
						startCol = c;
					}
				}
			}

			// 경비원이 움직이는게 아니라, 앉은 자리에서 감시하는 것
			for (int d = 0; d < 4; d++) {
				int t = 1;
				while (true) {
					int nr = startRow + delta[d][0] * t;
					int nc = startCol + delta[d][1] * t;
					if (nr >= R || nr < 0 || nc >= R || nc < 0 || arr[nr][nc] == 1)
						break;

					if (arr[nr][nc] == 0) {
						arr[nr][nc] = 3;
						t++;
					} else
						break;
				}
			}

			int cnt = 0;
			for (int r = 0; r < arr.length; r++) {
				for (int c = 0; c < arr.length; c++) {
					if (arr[r][c] == 0)
						cnt++;
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
