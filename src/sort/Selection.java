package sort;

class Selection {
	static void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}

			if (minIdx == i)
				continue;

			int temp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = temp;
		}
	}
}
