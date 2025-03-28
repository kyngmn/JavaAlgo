package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	private static final int MAX = 100;
	// 유향 그래프
	private static List<Integer>[] graph = new ArrayList[MAX + 1];
	private static boolean[] visited = new boolean[MAX + 1];
	private static final int INFINITY = Integer.MAX_VALUE;
	private static int[] distances = new int[MAX + 1];
	// 1부터 시작하는 노드이므로 0으로 초기화만 해도 오케이
	private static int[] paths = new int[MAX + 1];

	public static void main(String[] args) throws IOException {
		// 마지막에 동시에 연락받은 사람중 큰 숫자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 0;
		while (tc++ < 10) {
			// 초기화
			for (int i = 1; i < 101; i++) {
				graph[i] = new ArrayList<>();
				distances[i] = INFINITY;
			}

			st = new StringTokenizer(br.readLine());
			// 입력받는 데이터 길이
			int N = Integer.parseInt(st.nextToken());
			// 시작점
			int start = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				graph[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}

			System.out.println(Arrays.toString(graph));

			dijkstra(start);

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			System.out.println(sb);
		}
	}

	private static void dijkstra(int start) {
		if (visited[start])
			return;

		for (int v : graph[start]) {
			if (distances[v] < INFINITY) {
				distances[v] += 1;
				paths[v] = start;
			}
//			if() {
//				
//			}
		}

	}
}
