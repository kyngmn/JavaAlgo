package sort;

public class Merge {
	public static void sort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		}
		int mid = start + (end - start) / 2;

		// 일단 나눠
		sort(arr, start, mid);
		sort(arr, mid + 1, end);
		// 병합!
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int N = end - start + 1;
		int[] temp = new int[N];
		// temp 채울 인덱스
		int k = 0;
		// 반쪽 배열 인덱스
		int l = start;
		int r = mid + 1;

		// 반반 배열을 각각 이용해서 temp 배열을 작은 순서대로 채움
		while (l <= mid && r <= end) {
			if (arr[l] < arr[r]) {
				temp[k] = arr[l++];
			} else {
				temp[k] = arr[r++];
			}
			k++;
		}

		// 분할된 배열의 인덱스가 마지막에 도달하지 않았다면 나머지는 temp 배열 채우기
		while (l <= mid) {
			temp[k++] = arr[l++];
		}
		while (r <= end) {
			temp[k++] = arr[r++];
		}

		// 병합한 temp 배열로 갈아끼우기
		for (int i = 0; i < temp.length; i++) {
			arr[start + i] = temp[i];
		}

	}
}
