package tree;

import java.util.Scanner;

public class SWEA_1248_공통조상_보충 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			// 정점의 개수 (10<=V<=10000)
			int V = sc.nextInt();
			// 간선의 개수
			int N = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int[][] tree = new int[V + 1][3];// 자식 정보 0,1 + 부모 정보 2
			for (int i = 0; i < N; i++) {
				// 부모역할
				int p = sc.nextInt();
				// 자식 역할
				int c = sc.nextInt();

				// 부모 입장에서 자식 저장하고
				if (tree[p][0] == 0) {
					tree[p][0] = c;
				} else {
					tree[p][1] = c;
				}
				// 자식 입장에서 부모 저장
				tree[c][2] = p;
			}

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
					break;
				}
				b = tree[b][2];
			}
//			b

			System.out.println("#" + tc + " ");

		}
		sc.close();
	}
}
