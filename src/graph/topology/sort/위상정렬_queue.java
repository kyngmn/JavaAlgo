package graph.topology.sort;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 위상정렬_queue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		int V = sc.nextInt(); // 정점의 개수 (1부터 시작)
		int E = sc.nextInt(); // 간선의 개수

		int[][] adj = new int[V + 1][V + 1]; // 인접행렬
		int[] degree = new int[V + 1]; // 진입차수를 저장할 배열

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();

			// 가중치는 없고, 방향이 있으므로
			adj[s][e] = 1;
			// 도착지점의 차수를 올려야 한다!
			degree[e] = 1;
		}

		// 단순하게 정점의 번호만을 관리 하는 중
		Queue<Integer> q = new LinkedList<>();

		// 1. 진입차수가 0인 정점을 넣기
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0) {
				q.add(i);
			}
		}

		// 2. 큐가 공백 상태가 될때까지 반복
		// 하나 꺼내서 간선 제거하고, 진입차수 차감, 0되면 해당 인덱스 삽입
		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.println(cook[curr]);

			for (int to = 1; to < V + 1; to++) {
				if (adj[curr][to] == 1) {
					degree[to]--;
					if (degree[to] == 0) {
						q.add(to);
					}
				}
			}
		}
	}

	static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", ">고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

// u, v
	static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n" + "5 6\r\n"
			+ "9 6\r\n" + "6 7";

}
