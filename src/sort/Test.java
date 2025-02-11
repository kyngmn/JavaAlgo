package sort;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 123, 23, 1, 5, 45, 32 };
//		Bubble.sort(arr);
//		Selection.sort(arr);
		int[] sorted=Counting.sortPositiveInteger(arr);
		System.out.println(Arrays.toString(sorted));
	}
}
