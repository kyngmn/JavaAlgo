package graph.unionfind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class SWEA_7465_창용마을무리의개수 {
	static int[] parent;
	static Set<Integer> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			int M = Integer.parseInt(st.nextToken());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				union(a, b);
			}

			System.out.println(Arrays.toString(parent));

			set = new HashSet<>();
			for (int i = 1; i <= N; i++) {
				set.add(find(parent[i]));
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (i == parent[i])
					ans++;
			}

			System.out.println("#" + tc + " " + set.size());
		}
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		parent[rootB] = rootA;
	}

	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}
}
