package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1248_공통조상_보충 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bw.readLine());
		int tc = 0;
		while (tc++ < T) {
			// 정점의 개수 (10<=V<=10000)
			StringTokenizer st = new StringTokenizer(bw.readLine());
			int V = Integer.parseInt(st.nextToken());
			// 간선의 개수

			int N = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[][] tree = new int[V + 1][3];// 자식 정보 0,1 + 부모 정보 2
			st = new StringTokenizer(bw.readLine());
			for (int i = 0; i < N; i++) {
				// 부모역할
				int p = Integer.parseInt(st.nextToken());
				// 자식 역할
				int c = Integer.parseInt(st.nextToken());

				// 부모 입장에서 자식 저장하고
				if (tree[p][0] == 0) {
					tree[p][0] = c;
				} else {
					tree[p][1] = c;
				}
				// 자식 입장에서 부모 저장
				tree[c][2] = p;
			}

			int closeAncient = 0;
			int subtrees = 0;
			boolean[] visited = new boolean[V + 1];
			// 재귀함수보다 반복문이 빨라!
			while (true) {
				visited[a] = true;
				if (a == 1) {
					break;
				}
				a = tree[a][2];
			}
			while (true) {
				if (visited[b]) {
					closeAncient = b;
					break;
				}
				visited[b] = true;
				b = tree[b][2];
			}

			int i = closeAncient;
//			while (true) {
//				subtrees = 1 + (tree[i][0] > 0 ? tree[i][0] : 0) + (tree[i][1] > 0 ? tree[i][1] : 0);
//				if (i * 2 > V + 1)
//					break;
//				
//
//			}

			System.out.println("#" + tc + " " + closeAncient + " " + subtrees);

		}
	}
}
