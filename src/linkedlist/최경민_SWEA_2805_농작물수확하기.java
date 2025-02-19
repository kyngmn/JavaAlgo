package linkedlist;

import java.util.Scanner;

//36,468 kb
//메모리
//155 ms
//실행시간
//830
//코드길이
public class 최경민_SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int N = sc.nextInt();
			sc.nextLine();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.nextLine();
				char[] cs = s.toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(Character.toString(cs[j]));
				}
			}

			int sum = 0;
			int i = 0;
			int r = -1;
			while (r++ < N - 1) {
				int center = arr[r][N / 2];
				sum += center;
				for (int j = 0; j < i; j++) {
					sum += (arr[r][N / 2 - (j + 1)] + arr[r][N / 2 + (j + 1)]);
				}
				if (r >= N / 2) {
					i--;
				} else {
					i++;
				}
			}

			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
