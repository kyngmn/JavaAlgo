package stack;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_15706_일회용 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int k_min = sc.nextInt();
			int k_max = sc.nextInt();

			// A, B, C 반
			Stack<Integer> A = new Stack<>();
			Stack<Integer> B = new Stack<>();
			Stack<Integer> C = new Stack<>();

			int[] arr = new int[N];
			for (int n = 0; n < N; n++) {
				arr[n] = sc.nextInt();
			}

			Arrays.sort(arr);

			// A, C반 먼저 k_max를 채우기
			for (int i = 0; i < arr.length / 2; i++) {
				if (C.size() < k_max) {
					C.push(arr[i]);
					arr[i] = 0;
				}
				if (A.size() < k_max) {
					A.push(arr[arr.length - 1 - i]);
					arr[arr.length - 1 - i] = 0;
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] == 0)
					continue;
				B.push(arr[i]);
			}

			boolean isOk = true;
			for (int i = 0; i < k_min - B.size(); i++) {
				if (C.size() > k_min) {
					int popped = C.pop();
					B.push(popped);
				} else if (A.size() > k_min) {
					int popped = A.pop();
					B.push(popped);
				} else {
					isOk = false;
					break;
				}
			}
			System.out.print(A + " ");
			System.out.print(B + " ");
			System.out.print(C + " ");
			int T2 = A.size();
			int T1 = B.size();
			System.out.println("#" + tc + " " + (isOk ? T2 - T1 : -1));
		}
	}
}
