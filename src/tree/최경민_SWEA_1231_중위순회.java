package tree;

import java.util.Scanner;

//28,928 kb
//메모리
//130 ms
//실행시간
//1,540
//코드길이
public class 최경민_SWEA_1231_중위순회 {
	static String res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			// tc마다 static 문자열 초기화
			res = "";

			int N = sc.nextInt();
			// 자식 정보 0,1
			// 부모 정보 2
			int[][] tree = new int[N + 1][3];
			// 글자 번호
			String[] sa = new String[N + 1];

			for (int i = 1; i <= N; i++) {
				sc.nextInt();
				String[] sl = sc.nextLine().trim().split(" ");

				for (int j = 0; j < sl.length; j++) {
					switch (j) {
					case 0:
						sa[i] = sl[j];
						break;
					case 1: {
						int c = Integer.parseInt(sl[j]);
						tree[i][0] = c;
						tree[c][2] = i;
					}
						break;
					case 2: {
						int c = Integer.parseInt(sl[j]);
						tree[i][1] = c;
						tree[c][2] = i;
					}
						break;
					default:
						break;
					}

				}
			}

			// 중위순회
			inOrder(tree, sa, 1);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	static void inOrder(int[][] tree, String[] sa, int v) {
		// 트리를 벗어났을 때 깊이 탐색 중단
		if (v >= sa.length)
			return;

		// 좌측 노드부터 깊이 있게 돌림
		inOrder(tree, sa, v * 2);

		// 좌측 노드 -> 중위 노드 순서로 순회하는 방식이기 때문에
		// 좌측 노드가 없거나, 방문했을 때
		// 중위 노드를 출력해야 함
		if (tree[v][0] == 0) {
			// 결과 문자열
			res += sa[v];
			// 부모 노드의 번호
			int p = tree[v][2];
			tree[p][0] = 0;
		}
		inOrder(tree, sa, v * 2 + 1);
	}
}
