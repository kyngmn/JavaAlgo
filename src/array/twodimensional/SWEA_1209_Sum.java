package array.twodimensional;

import java.util.Scanner;

public class SWEA_1209_Sum {
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

			int max = 0;
			// 행의 합 => 100개
			// 열의 합 => 100개
			// 대각선의 합 => 2개 (좌상 -> 우하, 우상 -> 좌하)
			int rightDiagonalSum = 0;
			int leftDiagonalSum = 0;
			for (int i = 0; i < 100; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += arr[i][j];
					colSum += arr[j][i];
				}
				rightDiagonalSum += arr[i][i];
				leftDiagonalSum += arr[i][arr.length - 1 - i];

				max = Math.max(max, Math.max(rowSum, colSum));
			}
			max = Math.max(max, Math.max(rightDiagonalSum, leftDiagonalSum));

			System.out.println("#" + num + " " + max);
		}
		sc.close();
	}
}