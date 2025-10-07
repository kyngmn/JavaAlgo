package sort;

public class Insertion {
	public static void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int idx = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					idx = j;
				}
			}

			if (idx == -1)
				continue;

			// 값 씹힘때문에 체크해야함!
			int temp = arr[i];
			for (int j = i; j > idx; j--) {
				arr[j] = arr[j-1];
			}
			
			arr[idx] = temp;
		}
	}
}
