package sort;

import java.util.Scanner;

//250206
public class SWEA_2068_최대수구하기2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		// nextLine으로
//		sc.nextLine();

		for (int i = 0; i < T; i++) {
			int[] arr = new int[10];
			// nextInt로
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			// nextLine으로
//			int idx = 0;
//			for (String s : sc.nextLine().split(" ")) {
//				arr[idx] = Integer.parseInt(s);
//				idx++;
//			}

			int[] sorted = bubbleSort(arr);

			System.out.println("#" + (i + 1) + " " + sorted[9]);
		}

		sc.close();
	}

	public static int[] bubbleSort(int[] arr) {
		int N = arr.length;

		for (int i = N - 1; i > -1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}

		return arr;
	}
}
