package sort;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = { 3, 5, 11, 22, 23, 40, 64 };
		System.out.println(binarySearch(arr, 22));
		System.out.println(binarySearch(arr, 21));
	}

	static int binarySearch(int[] arr, int x) {
		// 맨좌측
		int L = 0;
		// 맨우측
		int R = arr.length - 1;
		while (L <= R) {
//			int M = (L + R) / 2;
			int M = L + (R - L) / 2;
			if (arr[M] == x)
				return M;
			if (arr[M] < x) {
				L = M + 1;
			} else {
				R = M - 1;
			}
		}
		return -1;
	}
}
