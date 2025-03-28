package sort;

import java.util.Arrays;

public class 버블정렬_내림차순 {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 9, 4 };

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] > arr[j - 1]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
