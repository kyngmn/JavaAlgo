package array.onedimesional;

import java.util.Scanner;

public class SWEA_1288_새로운불면증치료법_강사님풀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			boolean[] check = new boolean[10];
			boolean complete = true;
			int i;
			for (i = 1; !complete; i++) {
				int num = N * i;

				// 일의 자리 추출
				// num % 10
				while (num > 0) {
					check[num % 10] = true;
					num = num / 10;
				}

				for (int j = 0; j < check.length; j++) {
					if (!check[j]) {
						complete = false;
						break;
					}
				}
			}
		}
		sc.close();
	}
}
