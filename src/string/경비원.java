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

			int uncheckableRoom = untitled(arr, startRow, startCol);
			System.out.println(uncheckableRoom);
		}
		sc.close();
	}

	static int untitled(int[][] arr, int startRow, int startCol) {
		int cnt = 0;

		int currentRow = startRow;
		int currentCol = startCol;

		int i = 0;
		while (i++ < 5) {
			boolean up = false;
			boolean down = false;
			boolean left = false;
			boolean right = false;
			for (int d = 0; d < 4; d++) {
				int nr = startRow + delta[d][0];
				int nc = startCol + delta[d][1];

				// 물리적으로 갈 수 없는 경우
				if (nr >= arr.length || nr < 0 || nc >= arr.length || nc < 0)
					break;

				System.out.println(d + ", " + nr + "  " + nc + " : " + arr[currentRow][currentCol]);
				switch (d) {
				case 0:
					if (arr[nr][nc] == 0) {
						up = true;
						arr[nr][nc] = 3;
					}
					break;
				case 1:
					if (arr[nr][nc] == 0) {
						down = true;
						arr[nr][nc] = 3;
					}
					break;
				case 2:
					if (arr[nr][nc] == 0) {
						left = true;
						arr[nr][nc] = 3;
					}
					break;
				case 3:
					if (arr[nr][nc] == 0) {
						right = true;
						arr[nr][nc] = 3;
					}
					break;
				}

			}
//			System.out.println(arr[currentRow][currentCol]+ " "+up + " " + down + " " + left + " " + right + " ");
			if (!up && !down && !left && !right)
				break;
		}

		for (int r = 0; r < arr.length; r++) {
			for (int c = 0; c < arr.length; c++) {
				System.out.print(arr[r][c] + " ");
				if (arr[r][c] == 0)
					cnt++;
			}
			System.out.println();
		}

		return cnt;
	}
}
