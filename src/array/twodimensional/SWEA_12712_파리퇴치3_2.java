package array.twodimensional;

import java.util.Scanner;

//30,680 kb
//메모리
//121 ms
//시간
//3,094
//코드길이
// 처음 푼 방식 + 조건부 리팩토링
public class SWEA_12712_파리퇴치3_2 {
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
						cross += validElement(arr, N, r + i, c);
						cross += validElement(arr, N, r - i, c);
						cross += validElement(arr, N, r, c + i);
						cross += validElement(arr, N, r, c - i);

						x += validElement(arr, N, r + i, c + i);
						x += validElement(arr, N, r + i, c - i);
						x += validElement(arr, N, r - i, c + i);
						x += validElement(arr, N, r - i, c - i);

					}
					max = Math.max(Math.max(cross, x), max);
				}
			}
			System.out.println("#" + (tc + 1) + " " + max);
		}
		sc.close();
	}

	static int validElement(int[][] arr, int N, int nextRow, int nextCol) {
		if (nextRow >= N || nextRow < 0 || nextCol >= N || nextCol < 0)
			return 0;
		return arr[nextRow][nextCol];
	}
}
