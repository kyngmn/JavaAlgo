package array.onedimesional;

import java.util.Scanner;

public class SWEA_1519_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int max = 0;
			int k = 1;
			int zero = (int) '0';
			int sum = 0;
			while (max != 9) {
				for (int i = 1; i <= k * N; i++) {
					String s = Integer.toString(i);

					sum++;
					
					for (char c : s.toCharArray()) {
						int ctoi = (int) c;
						
						
						if (ctoi - zero > max) {
							max = ctoi - zero;
							break;
						}
					}
				}
				k++;
			}

			System.out.println(sum);
		}
		sc.close();
	}
}
