package stack;

import java.util.Scanner;

public class 봉사활동2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("5\n" + "5 1 4\n" + "3 5 5 4 5\n" + "6 2 6\n" + "5 3 3 5 5 1\n" + "7 1 6\n"
				+ "3 3 5 2 5 1 2\n" + "8 1 7\n" + "3 1 1 2 2 5 3 5\n" + "10 1 6\n" + "4 4 2 4 5 2 5 3 5 5");
		int T = sc.nextInt(), t = 0; // 테스트 케이스 수

		while (t++ < T) {
			int N = sc.nextInt(); // 학생
			int min = sc.nextInt();
			int max = sc.nextInt();
			int[] scores = new int[100 + 1];
			for (int i = 0; i < N; i++) {
				scores[sc.nextInt()]++;
			}

			for (int i = 2; i <= 100; i++) {
				scores[i] += scores[i - 1];
			}

			int ans = 1000, sum1 = 0, sum2 = 0, sum3 = 0;
			for (int i = 1; i <= 100 - 2; i++) { //
				if (scores[i] < min || scores[i] > max) // 우수그룹의 인원이 최소와 최대 기준을 넘을때 다음 기준으로 넘기자
					continue;
				sum1 = scores[i];

				for (int j = i + 1; j <= 100 - 1; j++) {
					sum2 = scores[j] - scores[i];
					sum3 = scores[100] - scores[j];

					// 보통과 부진 그룹의 인원이 최소와 최대 기준을 넘을때
					if (sum2 < min || sum3 < min || sum2 > max || sum3 > max)
						continue;

					// 기존 최소 차와 현재 경우의 최소 차 중에서 더 적은 차이를 정답으로 표기
					ans = Math.min(ans,
							// 가장 많은 분반 인원(sum1, sum2, sum3) // 가장 적은 분반 인원(sum1, sum2, sum3)
							Math.max(sum1, Math.max(sum2, sum3)) - Math.min(sum1, Math.min(sum2, sum3)));
				}
			}

			System.out.printf("#%d %d%n", t, ans == 1000 ? -1 : ans);
		}
	}
}