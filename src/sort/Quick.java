package sort;

public class Quick {
	public static void hoareSort(int[] arr, int left, int right) {
		if (left < right) {
			int idx = hoarePartition(arr, left, right);
			hoareSort(arr, left, idx - 1);
			hoareSort(arr, idx + 1, right);
		}
	}

	private static int hoarePartition(int[] arr, int left, int right) {
		// 피벗값정하기
		int pivot = arr[left];

		// 투포인터
		int l = left + 1;
		int r = right;

		while (l <= r) {
			// 피벗보다 큰 값을 찾을때까지 이동
			while (l <= right && arr[l] < pivot) {
				l++;
			}
			// 피벗보다 작은 값을 찾을 때까지 이동
			
			while (r >= left && arr[r] > pivot) {
				r--;
			}

			if (l <= r) {
				int temp = arr[l];
				arr[l] = arr[r];
				arr[r] = temp;
				l++;
				r--;
			}
		}
		
		// 피벗과 r 교환 ..
		arr[left] = arr[r];
		arr[r] = pivot;

		return r;
	}
}
