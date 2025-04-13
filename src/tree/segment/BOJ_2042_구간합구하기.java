package tree.segment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2042_구간합구하기 {
	static int[] arr;
	static long[] tree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 1~1000000, 수의 개수
		int N = Integer.parseInt(st.nextToken());
		// 1~10000, 변경이 일어나는 횟수
		int M = Integer.parseInt(st.nextToken());
		// 1~10000, 구간의 합
		int K = Integer.parseInt(st.nextToken());

		arr = new int[N];
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
		}

		int h = (int) Math.ceil(Math.log(N) / Math.log(2));
		int size = (int) Math.pow(2, h + 1) - 1; // 1 << (h+1)
		tree = new long[size + 1];

		init(1, 0, N - 1);

		System.out.println(Arrays.toString(tree));

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 1) {
				arr[b] = c;
			} else if (a == 2) {
				// 구간 합
			}
		}
	}

	public static long init(int node, int startIdx, int endIdx) {
		if (startIdx == endIdx) {
			return tree[node] = arr[startIdx];
		}
		int mid = startIdx + (endIdx - startIdx) / 2 - 1;
		return tree[node] = init(node * 2, startIdx, mid) + init(node * 2 + 1, mid + 1, endIdx);
	}
}
