package unsorted;

import java.util.Scanner;


public class SWEA_1940_가랏RC카 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int distance = 0;
			int currentSpeed = 0;
			for (int n = 0; n < N; n++) {
				int type = sc.nextInt();
				switch (type) {
				case 1: {
					int acceleration = sc.nextInt();
					currentSpeed += acceleration;
					break;
				}
				case 2: {
					int acceleration = sc.nextInt();
					// 현재 속도보다 감속할 속도가 더 클 경우, 속도는 0이 된다.
					if (currentSpeed < acceleration)
						currentSpeed = 0;
					else
						currentSpeed -= acceleration;
					break;
				}
				default:
				}
				distance += currentSpeed;
			}
			System.out.println("#" + (tc + 1) + " " + distance);

		}
		sc.close();
	}
}
