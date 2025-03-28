package sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 4, 6, 2, 7, 1, 11, 845, 35, 5 };
		System.out.println("원본배열 :: " + Arrays.toString(arr));
		// 삽입정렬
//		Insertion.sort(arr);
		// 병합정렬
//		Merge.sort(arr, 0, arr.length - 1);
		// 퀵정렬
		Quick.hoareSort(arr, 0, arr.length - 1);
		System.out.println("정렬후 :: " + Arrays.toString(arr));
	}
}
