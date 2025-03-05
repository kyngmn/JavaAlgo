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
	static int[] selected;
	static int diff;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			N = Integer.parseInt(br.readLine());
			selected = new int[N / 2];

			StringTokenizer st;

			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int min = Integer.MAX_VALUE;
			comb(0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	public static void comb(int idx, int sidx) {
		if (sidx == N / 2) {
			int a=0;
			int b=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < selected.length; j++) {
					if(i==j)
				}
			}
			System.out.println(Arrays.toString(selected));
			return;
		}
		if (idx == N) {
			return;
		}
		selected[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}
