package linkedlist;

import java.util.Scanner;

//26,752 kb
//메모리
//105 ms
//실행시간
//781
//코드길이
public class SWEA_1966_숫자를정렬하자 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			for (int i = 1; i < N; i++) {
				int nextIdx = i;
				for (int j = i - 1; j >= 0; j--) {
					if (arr[j] > arr[i])
						nextIdx = j;
				}

				if (nextIdx == i)
					continue;

				int temp = arr[i];
				for (int j = i; j > nextIdx; j--) {
					arr[j] = arr[j - 1];
				}
				arr[nextIdx] = temp;
			}

			System.out.print("#" + tc);
			for (int i = 0; i < arr.length; i++) {
				System.out.print(" " + arr[i]);
			}
			System.out.println();

		}
		sc.close();
	}
}
