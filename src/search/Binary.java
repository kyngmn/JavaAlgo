package search;

public class Binary {
	static int search(int[] arr, int answer) {
		int L = 0;
		int R = arr.length - 1;
		while (L <= R) {
			int M = L + (R - L) / 2;
			if (arr[M] == answer)
				return M;
			else if (arr[M] < answer) {
				L = M + 1;
			} else
				R = M - 1;
		}
		return -1;
	}
}
