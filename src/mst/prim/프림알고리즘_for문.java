package mst.prim;

import java.util.Arrays;
import java.util.Scanner;

public class 프림알고리즘_for문 {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점 -> 0번
		int E = sc.nextInt(); // 간선

		int[][] adj = new int[V][V]; // 인접행렬

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();

			// 무향 그래프
			adj[s][e] = adj[e][s] = cost;
		} // 간선 입력 끝

		int[] p = new int[V]; // 부모의 정보를 저장
		int[] dist = new int[V]; // key 값을 저장하는 배열
		boolean[] visited = new boolean[V]; // 트리에 소속인지 아닌지를 기록

		// 1. dist 배열을 초기화 해야한다. 아주아주 큰 값으로
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
			p[i] = -1; // 0번정점도 있으니까..
		}

		// 2. 시작정점을 골라라
		dist[0] = 0;
		int ans = 0;

		// 3. 전체를 반복문을 수행하면서... 정점을 뽑아보자
		for (int i = 0; i < V - 1; i++) {
			// 3-1. 가장 작은 값을 고를꺼야
			int min = INF;
			int idx = -1;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				}
			} ////////////////////// idx는 가장 작은 이번에 뽑은 정점이 된다.
			visited[idx] = true;
//			ans += dist[idx];
			// 3-2. 가장 작은 정점 뽑았으니까 연결된 간선으로 갱신.
			for (int j = 0; j < V; j++) {
				// 방문하지 X, idx와 연결되어 있는, 갱신의 여지가 있으면
				if (!visited[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
					dist[j] = adj[idx][j];
					p[j] = idx; // 부모정보 갱신
				}
			}
		} // 끝

		for (int i = 0; i < V; i++) {
			ans += dist[i];
		}
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(p));
		System.out.println(ans);

	}// main

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
