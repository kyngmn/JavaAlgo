import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {
	static class Node {
		int pos;
		int sec;

		Node(int pos, int sec) {
			this.pos = pos;
			this.sec = sec;
		}
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 수빈 현재 점 0~100,000
		// 걷기, 순간이동
		// 걷기 : X -> X-1 or X+1
		// 순간이동 : X -> 2*X
		int N = Integer.parseInt(st.nextToken());
		// 동생 현재 점 0~100,000
		int K = Integer.parseInt(st.nextToken());

		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(N, 0));

		int res = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Node curr = q.poll();

			if (curr.pos == K) {
				if (curr.sec < res) {
					res = curr.sec;
					break;
				}
			} else {
				// 순간이동
				q.offer(new Node(curr.pos * 2, curr.sec));
				// 우
				q.offer(new Node(curr.pos + 1, curr.sec + 1));
				// 좌
				q.offer(new Node(curr.pos - 1, curr.sec + 1));
			}
		}
		System.out.println(res);
	}
}
