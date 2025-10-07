package graph.topology.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1267_작업순서 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		StringTokenizer st;
		while (tc++ < 10) {

			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int[][] adj = new int[V + 1][V + 1];
			// '진입' 차수
			int[] degree = new int[V + 1];
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from][to] = 1;
				degree[to]++;
			}

			String res = tsq(adj, degree);

			System.out.println("#" + tc + " " + res);

		}
	}

	static String tsq(int[][] adj, int[] degree) {
		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < degree.length; i++) {
			// i 노드에게 들어오는 간선이 없다면 처음으로 시작해도 되므로 시작!
			if (degree[i] == 0) {
				q.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			int curr = q.poll();

			sb.append(curr);

			for (int to = 1; to < adj.length; to++) {
				if (adj[curr][to] == 1) {
					degree[to]--;
					if (degree[to] == 0) {
						q.offer(to);
					}
				}
			}

			if (!q.isEmpty()) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}
}
