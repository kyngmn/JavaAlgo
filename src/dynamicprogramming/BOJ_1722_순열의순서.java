package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1722_순열의순서 {
	public static long num;

	public static int N;
	public static int TYPE;
	public static long k;
	public static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine());
		TYPE = Integer.parseInt(st.nextToken());

		switch (TYPE) {
		case 1:
			// k번째 순열 구하기
			k = Long.parseLong(st.nextToken());
			num = factorial(N - 1);
			int quotient = (int) (k / num);
			num *= quotient;
			p1(quotient, new int[N], 0, new boolean[N]);
			break;
		case 2:
			// 몇번째인지 맞추기
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			p2(0, new int[N], 0, new boolean[N]);
			break;
		}
	}

	private static long factorial(long n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static boolean p1(int start, int[] temp, int idx, boolean[] visited) {
		if (idx == N) {
			num++;
			if (num == k) {
				System.out.println(Arrays.toString(temp));
				return true;
			}
			return false;
		}

		for (int i = start; i < N; i++) {
			if (visited[i])
				continue;
			temp[idx] = i + 1;
			visited[i] = true;

			num += factorial(N - 2 - idx);
			int quotient = (int) (k / num);
			num *= quotient;
			boolean found = p1(quotient, temp, idx + 1, visited);
			if (found) {
				break;
			}
			visited[i] = false;
		}
		return false;
	}

	private static boolean p2(int start, int[] temp, int idx, boolean[] visited) {
		if (idx == N) {
			num++;
			if (num > 0 && Arrays.toString(arr).equals(Arrays.toString(temp))) {
				System.out.println(num);
				return true;
			}
			return false;
		}
		for (int i = arr[start] - 1; i < N; i++) {
			if (visited[i])
				continue;
			temp[idx] = i + 1;
			visited[i] = true;
			boolean found = p2(start, temp, idx + 1, visited);
			if (found) {
				break;
			}
			visited[i] = false;
		}
		return false;
	}
}
