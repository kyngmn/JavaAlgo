package reverseorder;

import java.util.Scanner;


public class SWEA_1859_백만장자프로젝트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// revenue => 수익
			long revenue = 0;
			// max => 최대매매가
			int max = -1;
			// sum => 매매가 이전에 비축량의 합
			long sum = 0;
			// cnt => 비축 수량
			int cnt = 0;
			// 역순으로 처리하여 '미래 최대가'를 가져오고,
			// 그다음 미래 최대가를 알기전에 비축 해둠
			for (int i = N - 1; i > -1; i--) {
				if (max == -1) {
					max = arr[i];
				} else if (max > arr[i]) {
					sum += arr[i];
					cnt++;
				} else if (max <= arr[i]) {
					revenue += (long) max * cnt - sum;
					max = arr[i];
					sum = 0;
					cnt = 0;
				}
				if (i == 0 && cnt > 0) {
					revenue += (long) max * cnt - sum;
				}
			}
			System.out.println("#" + (tc + 1) + " " + revenue);
		}
		sc.close();
	}
}
