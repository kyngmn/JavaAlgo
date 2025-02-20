package review;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 342, 2, 3, 6, 43, 67, 9892, 4, 1, 11, 225, 89 };

		bubble(arr);
		selection(arr);
		System.out.println(Arrays.toString(arr));
		int[] sorted = counting(arr);
		System.out.println(Arrays.toString(sorted));
		System.out.println(binary(arr, 67));
	}

	private static void bubble(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	private static void selection(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			if (minIdx == i)
				continue;

			int tmp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = tmp;
		}
	}

	private static int[] counting(int[] arr) {
		int K = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > K)
				K = arr[i];
		}

		int[] count = new int[K + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] sorted = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		return sorted;
	}

	private static int binary(int[] arr, int key) {
		int L = 0;
		int R = arr.length - 1;
		while (L <= R) {
			int mid = L + (R - L) / 2;
			if (arr[mid] == key)
				return mid;
			if (arr[mid] > key) {
				R = mid - 1;
			} else {
				L = mid + 1;
			}
		}
		return -1;
	}
}
