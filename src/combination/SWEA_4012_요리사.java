package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4012_요리사 {

	static int N;
	static int[] selected; // 차이가 최소여야 하므로

	static int diff = Integer.MAX_VALUE; //

	static int total;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			N = Integer.parseInt(br.readLine());
			// 초기화
			total = 0;
			diff = Integer.MAX_VALUE;
			selected = new int[N / 2];

			// 점수 대치표 받기
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					// 시너지 점수 개선
					if (i < j) {
						arr[i][j] = Integer.parseInt(st.nextToken());
					} else {
						arr[j][i] += Integer.parseInt(st.nextToken());
					}
				}
			}

			comb(0, 0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(diff);
			System.out.println(sb.toString());
		}
	}

	public static void comb(int idx, int sidx) {
		if (sidx == N / 2) {
			// 누적합
			int aacc = 0;
			int bacc = 0;
			// 매 회 달라지는 케이스마다 boolean 값 체크가 필요함
			boolean[] visited = new boolean[N];
			for (int i = 0; i < selected.length; i++) {
				int idx1 = selected[i];
				visited[idx1] = true;
				for (int j = i + 1; j < selected.length; j++) {
					int idx2 = selected[j];
					visited[idx2] = true;
					aacc += arr[idx1][idx2];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if (visited[i])
					continue;
				for (int j = i + 1; j < arr.length; j++) {
					if (visited[j])
						continue;
					bacc += arr[i][j];
				}
			}
			diff = Math.min(diff, Math.abs(aacc - bacc));
//          System.out.println(Arrays.toString(selected) + " > " + a + "&" + b);
			return;
		}
		if (idx == N)
			return;
		selected[sidx] = idx;
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}
}