package greedy;

import java.util.Scanner;

public class SWEA_21425_플러스이꼴 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int N = sc.nextInt();

			int min = Math.min(a, b);
			int max = Math.max(a, b);
			int cnt = 0;
			while (max <= N) {
				min += max;
				if (min > max) {
					int tmp = min;
					min = max;
					max = tmp;
				}
				cnt++;

			}
			System.out.println(cnt);
		}
	}
}
