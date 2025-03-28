package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 봉사활동 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int min = sc.nextInt();
			int max = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Stack<Integer> a = new Stack<>();
			Stack<Integer> b = new Stack<>();
			Stack<Integer> c = new Stack<>();

			int k = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > k)
					k = arr[i];
			}

			int[] count = new int[k + 1];
			for (int i = 0; i < arr.length; i++) {
				count[arr[i]]++;
			}
//
//			for (int i = 1; i < count.length; i++) {
//				count[i] += count[i - 1];
//			}

			System.out.println(Arrays.toString(count));

			boolean isOk = true;

			int[] classes = new int[3];
			for (int i = 0; i < count.length; i++) {
				System.out.println("count[i] >> " + count[i]);
				if (count[i] > max) {
					isOk = false;
					break;
				}
				for (int j = 0; j < classes.length; j++) {
					if (classes[j] >= min) {
						continue;
					}
					if (classes[j] + count[i] <= max) {
						classes[j] += count[i];
						break;
					}
				}
			}

			int maxV = Integer.MIN_VALUE;
			int minV = Integer.MAX_VALUE;
			if (isOk) {
				for (int i = 0; i < classes.length; i++) {
					if (maxV < classes[i])
						maxV = classes[i];
					if (minV > classes[i])
						minV = classes[i];
					if (classes[i] < min || classes[i] > max)
						isOk = false;
				}
			}
			System.out.println(Arrays.toString(classes));

			System.out.println("#" + tc + " " + (isOk ? (maxV - minV) : -1));
		}
	}
}
