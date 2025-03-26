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

	static int L;
	static int R;

	static int[] cage;
	static int max;

	static int currentNoteIndex;
	static int currentL;
	static int currentR;

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
			currentL = 0;
			currentR = 0;

			// 1~X,M~10
			// X : 우리에 존재할 수 있는 최대 햄스터
			// 각 우리에 X마리 이하 햄스터
			// 햄스터 개체는 독립된 개체가 아님
			X = Integer.parseInt(st.nextToken());
			// M : 기록
			// "l번 우리에서 r번 우리까지의 햄스터 수를 세었더니 s마리였다."
			M = Integer.parseInt(st.nextToken());

			note = new int[M][3];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 1~l,r~N
				int l = note[i][0] = Integer.parseInt(st.nextToken());
				int r = note[i][1] = Integer.parseInt(st.nextToken());

				// 0~60
				int s = note[i][2] = Integer.parseInt(st.nextToken());

				if (l < L) {
					L = l;
				}
				if (r > R) {
					R = r;
				}
			}

			currentL = note[0][0];
			currentR = note[0][1];
			dfs(0, cage);
			System.out.println("잉" + Arrays.toString(cage));

			for (int i = 1; i <= N; i++) {
				if (i < L || i > R) {
					cage[i] = X;
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			System.out.println(sb);
		}
	}

	static void dfs(int depth, int[] currentCage) {
		int s = note[currentNoteIndex][2];
		System.out.println(
				"currentNoteIndex: " + currentNoteIndex + " , depth: " + depth + ": " + Arrays.toString(currentCage));

		if (depth == s) {
			if (currentNoteIndex >= M - 1) {
				if (depth > max) {
					max = depth;
					cage = Arrays.copyOf(currentCage, currentCage.length);
				} else if (depth == max) {
					if (Arrays.toString(cage).compareTo(Arrays.toString(currentCage)) > 0) {
						cage = Arrays.copyOf(currentCage, currentCage.length);
					}
				}
			} else {
				currentNoteIndex++;
				int nextDepth = 0;
				for (int i = note[currentNoteIndex][0]; i <= note[currentNoteIndex][1]; i++) {
					nextDepth += currentCage[i];
				}
				dfs(nextDepth, currentCage);
			}
			return;
		}

		int l = note[currentNoteIndex][0];
		int r = note[currentNoteIndex][1];
		for (int i = r; i >= l; i--) {
			// 최대값이면 cage 키우지 않아
			if (currentCage[i] >= X)
				continue;
			currentCage[i]++;
//			System.out.println(depth + 1 + ": " + Arrays.toString(currentCage));
			dfs(depth + 1, currentCage);
			currentCage[i]--;
		}
	}
}
