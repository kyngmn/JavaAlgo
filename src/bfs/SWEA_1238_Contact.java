package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1238_Contact {
	private static List<Integer>[] list = new ArrayList[100 + 1];
	private static int[] visited = new int[101];
	private static int max;

	public static void main(String[] args) throws IOException {
		// 마지막에 동시에 연락받은 사람중 큰 숫자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tc = 0;
		while (tc++ < 10) {
			max = 0;
			st = new StringTokenizer(br.readLine());

			// 입력받는 데이터 길이
			int N = Integer.parseInt(st.nextToken());
			// 시작점
			int start = Integer.parseInt(st.nextToken());

			list = new ArrayList[100 + 1];
			visited = new int[101];

			for (int i = 0; i <= 100; i++) {
				list[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			N /= 2;
			while (N-- > 0) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}

			visited[start] = 1;
			bfs(list[start]);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(max);
			System.out.println(sb);
		}
	}

	private static void bfs(List<Integer> elementList) {
		List<Integer> next = new ArrayList<>();
		for (Integer x : elementList) {
			for (Integer y : list[x]) {
				if (visited[y] == 1)
					continue;

				next.add(y);
				visited[y] = 1;
			}

		}

		if (next.size() == 0) {
			for (Integer x : elementList) {
				if (max < x) {
					max = x;
				}
			}
			return;
		} else {
			bfs(next);
		}
	}
}
