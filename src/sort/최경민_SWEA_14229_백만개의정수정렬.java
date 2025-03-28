package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최경민_SWEA_14229_백만개의정수정렬 {
	public static void main(String[] args) throws IOException {
		int[] arr = new int[1000000];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st.nextToken());
		}

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(arr[500000]);
	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int mid = start + (end - start) / 2;
		// 분할
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		// 병합
		merge(arr, start, mid, end);
	}

	private static void merge(int[] arr, int start, int mid, int end) {
		int N = end - start + 1;
		int[] temp = new int[N];
		int k = 0;

		// 분할된 배열1 시작 인덱스
		int i = start;
		// 분할된 배열2 시작 인덱스
		int j = mid + 1;

		// 분할된 배열을 서로 비교하며 작은 순서대로 채움
		while (i <= mid && j <= end) {
			if (arr[i] < arr[j]) {
				temp[k] = arr[i++];
			} else {
				temp[k] = arr[j++];
			}
			k++;
		}

		// 분할된 배열의 인덱스를 순차진행했을 때
		// 배열의 끝까지 순회하지 않았다면
		// 큰수이므로 temp 배열에 마저 넣어줌
		while (i <= mid) {
			temp[k++] = arr[i++];
		}
// 위와 같음
		while (j <= end) {
			temp[k++] = arr[j++];
		}

		for (int t = 0; t < temp.length; t++) {
			arr[start + t] = temp[t];
		}
	}

}
