package array.onedimesional;

import java.util.Scanner;

public class SWEA_1288_새로운불면증치료법 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			int[] arr = new int[10];
			int k = 1;
			int zero = (int) '0';
			int sum = 0;
			loop: while (true) {
				sum = k * N;
				for (int i = 1; i <= k * N; i++) {
					String str = Integer.toString(k * N);
					for (char c : str.toCharArray()) {
						if (arr[(int) c - zero] == 0)
							arr[(int) c - zero] = 1;
						else
							continue;
					}
					int cnt = 0;
					for (int j = 0; j < arr.length; j++) {
						if (arr[j] == 1)
							cnt++;
					}
					if (cnt == 10)
						break loop;
				}
				k++;
			}

			System.out.println(sum);
		}
		sc.close();
	}
}
