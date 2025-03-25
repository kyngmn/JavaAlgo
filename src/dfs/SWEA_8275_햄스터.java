package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8275_햄스터 {
	static int N;
	static int[] cage;

	static int X;
	static int M;
	static int[][] arr;

	static final int max_ham = 60;

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

			// 1~X,M~10
			// X : 우리에 존재할 수 있는 최대 햄스터
			// 각 우리에 X마리 이하 햄스터
			// 햄스터 개체는 독립된 개체가 아님
			X = Integer.parseInt(st.nextToken());
			// M : 기록
			// "l번 우리에서 r번 우리까지의 햄스터 수를 세었더니 s마리였다."
			M = Integer.parseInt(st.nextToken());

			arr = new int[M][3];
			int amount = Integer.MAX_VALUE;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 1~l,r~N
				int l = arr[i][0] = Integer.parseInt(st.nextToken());
				int r = arr[i][1] = Integer.parseInt(st.nextToken());

				// 0~60
				int s = arr[i][2] = Integer.parseInt(st.nextToken());
				int otherHamsterAmount = (N - (r - l + 1)) * X + s;
				if (amount > otherHamsterAmount) {
					amount = otherHamsterAmount;
				}
			}

			dfs(amount, 1);

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			System.out.println(sb);
		}
	}

	static void dfs(int amount, int currCageIndex) {
		for (int i = 0; i < arr.length; i++) {
			int l = arr[i][0];
			int r = arr[i][1];
			int s = arr[i][2];

			int temp = 0;
			for (int j = l; j < r; j++) {
				temp += cage[j];
			}
		}
	}
}
