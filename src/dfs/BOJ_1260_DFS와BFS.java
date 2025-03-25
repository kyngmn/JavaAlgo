package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS {
	static int N;
	static int[][] arr;
	static List<Integer>[] list;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정점개수 1~1000
		N = Integer.parseInt(st.nextToken());
		// 간선개수 1~10000
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		// 1. 인접 행렬
		arr = new int[N + 1][N + 1];
		// 2. 인접 리스트
		list = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 인접 행렬
			arr[a][b] = arr[b][a] = 1;
			// 인접 리스트
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 1; i < N + 1; i++) {
			list[i].sort(null);
//			System.out.println(Arrays.toString(arr[i]));
//			System.out.println(list[i]);
		}

//		visited = new boolean[N + 1];
//		StringBuilder sb1 = dfsMatrix(V, new StringBuilder().append(V));

		visited = new boolean[N + 1];
		StringBuilder sb2 = dfsList(V, new StringBuilder().append(V));

		List<Integer> starts = new ArrayList<>();
		starts.add(V);
//		visited = new boolean[N + 1];
//		StringBuilder sb3 = bfsMatrix(starts, new StringBuilder().append(V));

		visited = new boolean[N + 1];
		StringBuilder sb4 = bfsList(starts, new StringBuilder().append(V));
//		System.out.println(sb1);
		System.out.println(sb2);
//		System.out.println(sb3);
		System.out.println(sb4);
	}

	static StringBuilder dfsMatrix(int curr, StringBuilder sb) {
		visited[curr] = true;
		for (int i = 1; i < arr[curr].length; i++) {
			if (!visited[i] && arr[curr][i] == 1) {
				sb.append(" ").append(i);
				dfsMatrix(i, sb);
			}
		}
		return sb;
	}

	static StringBuilder dfsList(int curr, StringBuilder sb) {
		visited[curr] = true;
		for (Integer x : list[curr]) {
			if (!visited[x]) {
				sb.append(" ").append(x);
				dfsList(x, sb);
			}
		}
		return sb;
	}

	static StringBuilder bfsMatrix(List<Integer> starts, StringBuilder sb) {
		List<Integer> nextStarts = new ArrayList<>();

		for (Integer s : starts) {
			visited[s] = true;

			for (int i = 1; i < arr[s].length; i++) {
				if (!visited[i] && arr[s][i] == 1) {
					sb.append(" ").append(i);
					nextStarts.add(i);
					visited[i] = true;
				}
			}
		}

		if (nextStarts.size() > 0) {
			return bfsMatrix(nextStarts, sb);
		} else {
			return sb;
		}
	}

	static StringBuilder bfsList(List<Integer> starts, StringBuilder sb) {
		List<Integer> nextStarts = new ArrayList<>();

		for (Integer s : starts) {
			visited[s] = true;

			for (Integer i : list[s]) {
				sb.append(" ").append(i);
				nextStarts.add(i);
				visited[i] = true;
			}
		}

		if (nextStarts.size() > 0) {
			return bfsMatrix(nextStarts, sb);
		} else {
			return sb;
		}
	}

}
