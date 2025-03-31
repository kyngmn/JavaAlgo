package sort;

import java.util.Scanner;

//250206
public class 최경민_SWEA_1206_View {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			// 배열의 길이를 받음
			int T = sc.nextInt();

			// 배열 생성
			int[] arr = new int[T];
			for (int j = 0; j < T; j++) {
				arr[j] = sc.nextInt();
			}

			// 조망권 세대 확보
			int sum = 0;
			// 맨좌측과 맨우측의 2세대는 아파트가 들어설 수 없음
			for (int j = 2; j < T - 2; j++) {
				// 좌 2세대 우 2세대 배열
				int[] houses = { arr[j - 1], arr[j - 2], arr[j + 1], arr[j + 2] };
				// 버블 정렬
				for (int k = houses.length - 1; k > -1; k--) {
					for (int l = 0; l < k; l++) {
						if (houses[l] > houses[l + 1]) {
							int temp = houses[l + 1];
							houses[l + 1] = houses[l];
							houses[l] = temp;
						}
					}
				}

				// 세대 배열의 최대
				int max = houses[3];
				if (arr[j] > max) {
					int diff = arr[j] - max;
					sum = sum + diff;
				}
			}

			System.out.println("#" + (i + 1) + " " + sum);
		}
		sc.close();
	}

}
