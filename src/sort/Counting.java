package sort;

public class Counting {
	static int[] sortPositiveInteger(int[] arr) {
		// 배열 원소의 최댓값을 찾는다.
		int K = 0;
		for (int i = 0; i < arr.length; i++) {
			if (K < arr[i])
				K = arr[i];
		}

		// 원소 - 인덱스 매핑 배열
		int[] count = new int[K + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}

		// 매핑 배열 누적합 전환
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 역방향 순회하여 정렬
		int[] sorted = new int[arr.length];
		for (int i = arr.length - 1; i > -1; i--) {
			// arr[i]이 들어갈 자리를 찾는다.
			// count는 갯수, 즉 길이와 같으므로
			// 감소 연산을 시켜야
			sorted[--count[arr[i]]] = arr[i];
		}
		return sorted;
	}

//	static int[] sortInteger(int[] arr) {
//		int K = 0;
//		int L = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if (K > arr[i])
//				K = arr[i];
//			if (L < arr[i])
//				L = arr[i];
//		}
//		
//		int[] count = new int[];
//	}
}
