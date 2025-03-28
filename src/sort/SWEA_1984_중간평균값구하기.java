package sort;

import java.util.Scanner;

//250206
public class SWEA_1984_중간평균값구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int[] arr = new int[10];
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}

			for (int j = arr.length - 1; j > -1; j--) {
				for (int k = 0; k < j; k++) {
					if (arr[k] > arr[k + 1]) {
						int tmp = arr[k];
						arr[k] = arr[k + 1];
						arr[k + 1] = tmp;
					}
				}
			}

			int min = arr[0];
			int max = arr[9];
			int length = 0;
			double sum = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] > min && arr[j] < max) {
					sum = sum + arr[j];
					length++;
				}
			}
			System.out.println("#" + (i + 1) + " " + (int) Math.round((double) (int) (sum / length * 10) / 10));
		}
		sc.close();
	}
}
