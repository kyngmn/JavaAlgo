package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo2_서울_11_최경민 {
	// 전체 사람의 수 1~100
	static int N;
	// 관계의 개수
	static int M;

	static List<Integer>[] edges;
	static int[] dist;

	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			// 초기화
			cnt = 0;

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			edges = new ArrayList[N + 1];
			dist = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				edges[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				// 부모
				int x = Integer.parseInt(st.nextToken());
				// 자식
				int y = Integer.parseInt(st.nextToken());
				edges[x].add(y);
				edges[y].add(x);
			}

			for (int i = 1; i <= N; i++) {
				dist = new int[N + 1];
				Arrays.fill(dist, -1); // -1은 미방문 표시

				bfs(i); // i번 사람을 시작점으로 BFS

				// 중복 쌍 방지: j > i인 쌍만 체크
				for (int j = i + 1; j <= N; j++) {
					if (dist[j] == 3) {
						cnt++;
					}
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(cnt);
			System.out.println(sb);
		}
	}

	static void bfs(int p) {
		Queue<Integer> q = new LinkedList<>();

		q.offer(p);
		dist[p] = 0;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (Integer c : edges[curr]) {
				if (dist[c] == -1) {
					dist[c] = dist[curr] + 1;
					q.offer(c);
				}
			}
		}
	}

}
