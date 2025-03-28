package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_8275_햄스터 {
	static int N;
	static int X;
	static int M;
	static int[][] note;

	static int[] cage;

	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;

		StringTokenizer st;

		while (tc++ < T) {
			st = new StringTokenizer(br.readLine());
			// 1~6
			// 햄스터 우리
			N = Integer.parseInt(st.nextToken());
			cage = new int[N + 1];
			max = 0;

			// 1~X,M~10
			// X : 우리에 존재할 수 있는 최대 햄스터
			// 각 우리에 X마리 이하 햄스터
			// 햄스터 개체는 독립된 개체가 아님
			X = Integer.parseInt(st.nextToken());
			// M : 기록
			// "l번 우리에서 r번 우리까지의 햄스터 수를 세었더니 s마리였다."
			M = Integer.parseInt(st.nextToken());

//			if ("9 10 10".compareTo("10 9 10") > 0) {
//				System.out.println("1".compareTo("2") > 0);
//			}

			note = new int[M][3];
			int minL = Integer.MAX_VALUE;
			int maxR = Integer.MIN_VALUE;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 1~l,r~N
				int l = note[i][0] = Integer.parseInt(st.nextToken());
				int r = note[i][1] = Integer.parseInt(st.nextToken());

				// 0~60
				int s = note[i][2] = Integer.parseInt(st.nextToken());

				if (l < minL) {
					minL = l;
				}
				if (r > maxR) {
					maxR = r;
				}
			}

			boolean[] visited = new boolean[N + 1];
			dfs(0, 0, cage, note[0][1], visited);

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");

			if (max < 0) {
				sb.append("-1");
			} else {

				for (int i = 1; i <= N; i++) {
					if (i < minL || i > maxR) {
						sb.append(X);
					} else {
						sb.append(cage[i]);
					}
					if (i < N) {
						sb.append(" ");
					}
				}
			}
			System.out.println(sb);
		}
	}

	static void dfs(int cidx, int depth, int[] currentCage, int startR, boolean[] visited) {
//		System.out.println("cidx: " + cidx + ", target depth: " + note[cidx][2] + " , current depth: " + depth + ": "
//				+ Arrays.toString(currentCage));

		if (depth == note[cidx][2]) {
			if (cidx >= M - 1) {
				int sum = 0;
				for (int i = 1; i <= N; i++) {
					sum += currentCage[i];
				}
				if (sum > max || (sum == max && isLexSmaller(currentCage))) {
					max = sum;
					cage = Arrays.copyOf(currentCage, N + 1);
				}
			} else {
				int nextDepth = 0;
				for (int i = note[cidx + 1][1]; i >= note[cidx + 1][0]; i--) {
					nextDepth += currentCage[i];
				}

				if (note[cidx + 1][2] < nextDepth) {
					max = -1;
					return;
				}

				for (int i = note[cidx][0]; i <= note[cidx][1]; i++) {
					visited[i] = true;
				}
				dfs(cidx + 1, nextDepth, currentCage, note[cidx + 1][1], visited);
				for (int i = note[cidx][0]; i <= note[cidx][1]; i++) {
					visited[i] = false;
				}
			}
			return;
		}

		for (int i = startR; i >= note[cidx][0]; i--) {
			if (currentCage[i] >= X || visited[i])
				continue;

			currentCage[i]++;
			dfs(cidx, depth + 1, currentCage, i, visited);
			currentCage[i]--;
		}

	}

	static boolean isLexSmaller(int[] candidate) {
		for (int i = 1; i <= N; i++) {
			if (candidate[i] < cage[i])
				return true;
			else if (candidate[i] > cage[i])
				return false;
		}
		return false;
	}

}
