package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo3_서울_11_최경민 {
	static int N, M, P;
	static int[] visited;
	static int[][] graph;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			cnt = 0;

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			// 다시 연결되어 방문한 노드를 방문하지 않기 위해 방문 체크를 할것임
			visited = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				visited[i] = i;
			}

			// 인접 행렬 그래프를 받을 것
			graph = new int[N + 1][N + 1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				// 무향그래프이므로 쌍방 좌표 체크
				graph[a][b] = graph[b][a] = 1;
			}

			// 너비 우선 탐색을 위한 큐
			Queue<List<Integer>> q = new LinkedList<>();

			// 주어진 첫번째 노드부터 탐색
			List<Integer> first = new ArrayList<>();
			first.add(P);
			q.offer(first);

			while (!q.isEmpty()) {
				List<Integer> currents = q.poll();

				// 현재 노드의 다음 탐색할 노드 리스트
				List<Integer> list = new ArrayList<>();
				for (Integer c : currents) {
					// 방문 체크
					visited[c] = 0;
					for (int i = 0; i < graph.length; i++) {
						// 인접해있고 방문하지 않은 경우 다음 탐색 리스트에 추가
						if (graph[c][i] == 1 && visited[i] > 0) {
							list.add(i);
							visited[i] = 0;
						}
					}
				}

				if (!list.isEmpty()) {
					q.offer(list);
				} else {
					// 너비 우선 탐색 대상이 없는 경우 마지막 탐색 list의 개수가 곧 가장 멀리 떨어진 노드 개수
					cnt = currents.size();
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}
	}
}
