package unsorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
				int[] tmp = new int[9];
				for (int j = 1; j <= 9; j++) {
					if (tmp[j - 1] == 1) {
						hasSame = true;
						break;
					} else {
						tmp[j - 1] = 1;
					}
				}
				if (hasSame)
					break;
			}
			System.out.print("#" + tc + " ");
		}
	}
}
