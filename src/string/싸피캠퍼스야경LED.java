package string;

import java.util.Scanner;

public class 싸피캠퍼스야경LED {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[] toBe = new int[N];
			for (int n = 0; n < N; n++) {
				toBe[n] = sc.nextInt();
			}
			int[] asIs = new int[N];

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (toBe[i] != asIs[i]) {
					cnt++;
					// 1 -> 5
					// 2 -> 2
					//
					for (int j = 1; j <= N / (i + 1); j++) {
						// 2 * 4 -1
						asIs[(i + 1) * j - 1] = asIs[(i + 1) * j - 1] == 1 ? 0 : 1;
					}
//					System.out.println("toBe >> " + i + " " + Arrays.toString(toBe));
//					System.out.println("asIs >> " + Arrays.toString(asIs));
				}
				if (toBe.toString().equals(asIs.toString()))
					break;
			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
