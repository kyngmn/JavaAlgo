package stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_15706_일회용2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();

			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}

			int ans = 987654321;

			//
			for (int t1 = 1; t1 < 100; t1++) {
				for (int t2 = t1 + 1; t2 <= 100; t2++) {
					int A = 0;
					int B = 0;
					int C = 0;

					// 실제로 배열 순회
					for (int i = 0; i < N; i++) {
						if (arr[i] >= t2)
							A++;
						else if (arr[i] >= t1) {
							B++;

						} else
							C++;
					}
					
					// A, B, C 분반 인원들이 전부 결정됨
				}
			}

//			System.out.println("#" + tc + " " + (isOk ? T2 - T1 : -1));
		}
	}
}
