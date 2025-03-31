package dynamicprogramming;

import java.util.Scanner;

public class SWEA_2005_파스칼의삼각형 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int N = sc.nextInt();
			int[][] arr = new int[N][];
			arr[0] = new int[] { 1 };
			for (int i = 1; i < N; i++) {
				// 배열 길이 초기화
				arr[i] = new int[i + 1];
				arr[i][0] = 1;
				arr[i][i] = 1;
				for (int j = 1; j < i; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < i + 1; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
