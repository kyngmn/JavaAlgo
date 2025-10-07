package array.twodimensional;

import java.util.Scanner;


public class SWEA_1954_달팽이숫자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			
			// 모두 돌아야 하는 거리
			int total = N * N;

			int[][] arr = new int[N][N];
			// 우 -> 하 -> 좌 -> 상 순서대로 달팽이가 돌아야 함
			int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

			int cnt = 0;
			int di = 0;

			int row = 0;
			int col = 0;

			arr[row][col] = 1;
			cnt++;

			// 모두 돌아야 하는 거리 total을 돌면 loop 중리
			while (cnt < total) {
				int tempRow = row + directions[di][0];
				int tempCol = col + directions[di][1];
				// row와 col이 N-1을 넘거나, 0미만이 되거나, 이미 배열이 채워졌다면 방향을 틈
				if (tempRow > N - 1 || tempCol > N - 1 || tempRow < 0 || tempCol < 0 || arr[tempRow][tempCol] != 0)
					di = (++di) % 4;
				row = row + directions[di][0];
				col = col + directions[di][1];

				arr[row][col] = cnt + 1;
				cnt++;
			}
			
			System.out.println("#" + (tc + 1));
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (j == arr.length - 1)
						System.out.println(arr[i][j]);
					else
						System.out.print(arr[i][j] + " ");
				}
			}

		}
		sc.close();
	}
}
