package swea.d1;

import java.util.Scanner;

public class SWEA_2071_평균값구하기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int N = 10;
			double res = 0;
			for (int i = 0; i < N; i++) {
				res += sc.nextInt();
			}
			// 소수점 첫째 자리에서 반올림한 정수
			int avg = (int) Math.round(res / N);
			System.out.println("#" + tc + " " + avg);
		}
	}
}
