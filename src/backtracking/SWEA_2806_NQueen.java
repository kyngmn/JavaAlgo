package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SWEA_2806_NQueen {
	static int N;
	static int cases;
	static boolean[] col;
	static boolean[] diagonalR;
	static boolean[] diagonalL;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringBuilder sb = new StringBuilder();
		while (tc++ < T) {
			sb = new StringBuilder();
			// 1~10
			N = Integer.parseInt(br.readLine());
			cases = 0;

			col = new boolean[N];
			diagonalR = new boolean[2 * N - 1];
			diagonalL = new boolean[2 * N - 1];
			// 하나의 행에 하나는 꼭 놓여야 한다. N개의 퀸이므로.
			backtracking(0);

			sb.append("#").append(tc).append(" ").append(cases);
			System.out.println(sb.toString());
		}
	}

	public static void backtracking(int row) {
		// row가 배열을 전부 돌았다면 게임 승
		if (row == N) {
			cases++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (col[c] || diagonalR[row + c] || diagonalL[row - c + N - 1])
				continue;

			col[c] = diagonalR[row + c] = diagonalL[row - c + N - 1] = true;
			backtracking(row + 1);
			col[c] = diagonalR[row + c] = diagonalL[row - c + N - 1] = false;
		}
	}
}
