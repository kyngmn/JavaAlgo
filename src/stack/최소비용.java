package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class 최소비용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();

			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Stack<Integer> a = new Stack<>();
			Stack<Integer> b = new Stack<>();

			Arrays.sort(arr);

			int cost = 0;
			for (int i = arr.length - 1; i >= 0; i--) {
				if (A > B) {
					if (a.size() < b.size() || b.size() >= B) {
						a.push(arr[i]);
					} else {
						b.push(arr[i]);
					}
				} else {
					if (b.size() < a.size() || a.size() >= A) {
						b.push(arr[i]);
					} else {
						a.push(arr[i]);
					}
				}
			}

			for (int i = 1; i <= A; i++) {
				cost += a.get(i - 1) * i;
			}
			for (int i = 1; i <= B; i++) {
				cost += b.get(i - 1) * i;
			}
			System.out.println("#" + tc + " " + cost);
		}
	}
}
