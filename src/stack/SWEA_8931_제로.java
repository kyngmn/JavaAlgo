package stack;

import java.util.Scanner;

public class SWEA_8931_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			// 부를 숫자의 개수
			int N = sc.nextInt();

			

			int sum = 0;
//			for (int i = 0; i < arr.length; i++) {
//				sum += arr[i];
//			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
		sc.close();
	}

}
