package sort;

import java.util.Scanner;

// 250210
public class SWEA_2063_중간값찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] arr = new int[N];
		String numString = sc.nextLine();
		int idx = 0;
		for (String s : numString.split(" ")) {
			arr[idx++] = Integer.parseInt(s);
		}
//		bubbleSort(arr);
//		selectionsSort(arr);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(arr[(arr.length - 1) / 2]);
		int[] sorted = countingSort(arr);
		System.out.println(sorted[(sorted.length - 1) / 2]);
		sc.close();
	}

	private static void bubbleSort(int[] arr) {
		for (int i = arr.length - 1; i > -1; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	private static void selectionsSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			if (minIdx == i)
				continue;

			int temp = arr[minIdx];
			arr[minIdx] = arr[i];
			arr[i] = temp;
		}
	}

	private static int[] countingSort(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i])
				max = arr[i];
		}

		int[] count = new int[max + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		int[] sorted = new int[arr.length];
		for (int i = arr.length - 1; i > -1; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		
		return sorted;
	}
}
