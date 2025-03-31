package stack;

import java.util.Arrays;
import java.util.Scanner;

//250211
public class SWEA_8931_제로_pushpop구현 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			// 부를 숫자의 개수
			int N = sc.nextInt();

			int[] arr = new int[0];
			for (int i = 0; i < N; i++) {
				int input = sc.nextInt();
				if (input == 0) {
					arr = pop(arr);
				} else {
					arr = push(arr, input);
				}
			}

			int sum = 0;
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
			System.out.println("#" + (tc + 1) + " " + sum);
		}
		sc.close();
	}

	static int[] push(int[] arr, int el) {
		int N = arr.length;
		int[] res = Arrays.copyOf(arr, N + 1);
		res[N] = el;
		return res;
	}

	static int[] pop(int[] arr) {
		int N = arr.length;
		if (N == 0)
			return arr;

		int[] res = new int[N - 1];
		res = Arrays.copyOfRange(arr, 0, N - 1);
		return res;
	}
}
