package unsorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1974_스도쿠검증 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			int[][] arr = new int[9][9];
			for (int i = 0; i < 9; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 9; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean hasSame = false;
			for (int i = 0; i < 9; i++) {
				int[] horTmp = new int[9];
				int[] verTmp = new int[9];
				for (int j = 0; j < 9; j++) {
					// 가로 loop
					if (horTmp[arr[i][j] - 1] == 1) {
						hasSame = true;
					} else {
						horTmp[arr[i][j] - 1] = 1;
					}
					// 세로 loop
					if (verTmp[arr[j][i] - 1] == 1) {
						hasSame = true;
					} else {
						verTmp[arr[j][i] - 1] = 1;
					}
					if (hasSame) {
						break;
					}
				}
			}

			if (!hasSame) {
				for (int i = 0; i < 3; i++) {
					int[] tmp = new int[9];
					for (int j = 0; j < 9; j++) {
						int r = j / 3;
						int c = j % 3;
						if (tmp[arr[r][c] - 1] == 1) {
							hasSame = true;
						} else {
							tmp[arr[r][c] - 1] = 1;
						}
						if (hasSame)
							break;
					}
				}
			}

			System.out.println("#" + tc + " " + (hasSame ? 0 : 1));
		}
	}
}
