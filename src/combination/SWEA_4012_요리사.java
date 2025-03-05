package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {

			N = Integer.parseInt(br.readLine());

			StringTokenizer st;

			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int min = Integer.MAX_VALUE;
			int[] a = new int[N];
			int[] b = new int[N];
			comb(0, 0, a);

			System.out.println("#" + tc + " " + min);
		}
	}

	public static void comb(int idx, int sidx, int[] arr) {
		if (sidx == N) {
			System.out.println(Arrays.toString(arr));
			return;
		}
		if (idx == N) {
			return;
		}
		arr[sidx] = idx;
		comb(idx + 1, sidx + 1, arr);
		comb(idx + 1, sidx, arr);
	}
}
