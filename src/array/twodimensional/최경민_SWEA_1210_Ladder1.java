package array.twodimensional;

import java.util.Scanner;

public class 최경민_SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int num = sc.nextInt();

			int[][] arr = new int[100][100];
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int winner = -1;
			// [0][start] 에서 요소가 1인 경우 출발지점이 됨.
			// 1. 아래로 내려가고, 좌 or 우측의 1을 검사
			// 2. 1이 없다면 아래로 내려가기
			// 3. 1이 있다면 해당 방향으로 전진 & 아래 방향 1을 검사
			// 4. 아래 방향의 1이 있는 부분에서 아래로 내려가기
			// [99][*]이 될때까지 사이클 순회
			for (int startIdx = 0; startIdx < 100; startIdx++) {
				int curr = arr[0][startIdx];
				if (curr == 0)
					continue;

				int row = 0;
				int col = startIdx;
				while (row < 100) {
					if (arr[row][col] == 2) {
						winner = startIdx;
						break;
					}

					if (col - 1 >= 0 && arr[row][col - 1] == 1) {
						// 좌측 검사
						// 좌측 이동
						col--;
						while (true) {
							// 아래에 1발견
							if (row + 1 < arr.length && arr[row + 1][col] == 1) {
								row++;
								break;
							}
							// 아래에 1 없을때 계속 전진
							if (col - 1 >= 0) {
								col--;
							} else
								break;
						}
					} else if (col + 1 < arr.length && arr[row][col + 1] == 1) {
						// 우측 검사
						// 우측 이동
						col++;
						while (true) {
							// 아래에 1발견
							if (row + 1 < arr.length && arr[row + 1][col] == 1) {
								row++;
								break;
							}
							// 아래에 1 없을때 계속 전진
							if (col + 1 < arr.length) {
								col++;
							} else
								break;
						}
					} else {
						row++;
					}
					// 좌우측 1이 없을 때 = 사다리가 없을 때 while문 지속
					// 2를 만나면 도착이므로 while 중단
					// 아래로 내려감

				}
			}

			System.out.println("#" + num + " " + winner);
		}
		sc.close();
	}
}