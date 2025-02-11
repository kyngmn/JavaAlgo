package unsorted;

import java.util.Scanner;

public class SWEA_1961_숫자배열회전 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			String[] res = new String[N];

			// rotate
			int[][] r1 = rotate(arr, N);
			for (int i = 0; i < r1.length; i++) {
				// 이거를 빨리 해줘야 한다.!?
				res[i] = "";
				for (int j = 0; j < r1.length; j++) {
					res[i] += r1[i][j];
				}
				res[i] += " ";
			}

			int[][] r2 = rotate(r1, N);
			for (int i = 0; i < r2.length; i++) {
				for (int j = 0; j < r2.length; j++) {
					res[i] += r2[i][j];
				}
				res[i] += " ";
			}

			int[][] r3 = rotate(r2, N);
			for (int i = 0; i < r3.length; i++) {
				for (int j = 0; j < r3.length; j++) {
					res[i] += r3[i][j];
				}
				res[i] += " ";
			}

			System.out.println("#" + (tc + 1));
			for (int i = 0; i < res.length; i++) {
				System.out.println(res[i]);
			}

		}
		sc.close();
	}

	static int[][] rotate(int[][] arr, int N) {
		int[][] res = new int[N][N];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				res[c][arr.length - 1 - r] = arr[r][c];
			}
		}
		return res;
	}
}
