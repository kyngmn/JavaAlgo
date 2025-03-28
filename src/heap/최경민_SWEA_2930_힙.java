package heap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//99,364 kb
//메모리
//339 ms
//실행시간
//1,552
//코드길이
public class 최경민_SWEA_2930_힙 {
	static int[] heap;
	static int heapSize;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int T = Integer.parseInt(br.readLine());
			int tc = 0;
			while (tc++ < T) {
				int N = Integer.parseInt(br.readLine());
				heap = new int[N + 1];
				heapSize = 0;
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < N; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int op = Integer.parseInt(st.nextToken());
					// 추가
					if (op == 1) {
						int x = Integer.parseInt(st.nextToken());
						push(x);
					}
					// 삭제
					else {
						sb.append(" ").append(pop());
					}
				}
				System.out.println("#" + tc + sb);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int pop() {
		if (heapSize == 0)
			return -1;
		int p = 1;
		int popped = heap[p];
		heap[p] = heap[heapSize--];
		int c = p * 2;
		while (c <= heapSize) {
			if (c + 1 <= heapSize && heap[c] < heap[c + 1]) {
				c = c + 1;
			}
			if (heap[p] >= heap[c])
				break;
			int tmp = heap[p];
			heap[p] = heap[c];
			heap[c] = tmp;
			p = c;
			c = p * 2;
		}
		return popped;
	}

	private static void push(int x) {
		heap[++heapSize] = x;
		int c = heapSize;
		int p = c / 2;
		while (p > 0 && heap[p] < heap[c]) {
			int tmp = heap[c];
			heap[c] = heap[p];
			heap[p] = tmp;
			c = p;
			p /= 2;
		}
	}
}
