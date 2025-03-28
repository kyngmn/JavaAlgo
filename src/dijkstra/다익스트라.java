package dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 다익스트라 {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}
	}

	static final int INF = Integer.MAX_VALUE;
	static int V, E; // 정점 0번부터, 간선
	static List<Edge>[] adj; // 인접리스
	static int[] dist; // 거리저장

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt();
		E = sc.nextInt();
		adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		dist = new int[V];
		Arrays.fill(dist, INF);

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();

			adj[s].add(new Edge(e, cost)); // 유향
//			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		} // 간선 입력

		dijkstra(0);

		System.out.println(Arrays.toString(dist));

	}// main

	static void dijkstra(int start) {
		boolean[] visited = new boolean[V];

		dist[start] = 0; // 시작정점의 거리의 값을 0으로 갱신 하겠다!
		for (int i = 0; i < V - 1; i++) {
			// 1. 작은 값을 뽑아
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			}
			////////////////////////////// 작은거 뽑았어
			if (idx == -1)
				break; // 의미? 더이상의 진행은 무의미하다.

			visited[idx] = true;

			// 2. 갱신
			for (Edge e : adj[idx]) {
				// 방문하지 X, 나와연결되어있으면서(리스트로 해결), 갱신
				if (!visited[e.to] && dist[e.to] > dist[idx] + e.cost) {
					dist[e.to] = dist[idx] + e.cost;
				}
			}

		} // 정점의 수만큼 돌아
	}

	static String input = "6 11\r\n" + "0 1 4\r\n" + "0 2 2\r\n" + "0 5 25\r\n" + "1 3 8\r\n" + "1 4 7\r\n"
			+ "2 1 1\r\n" + "2 4 4\r\n" + "3 0 3\r\n" + "3 5 6\r\n" + "4 3 5\r\n" + "4 5 12\r\n" + "";
}
