package tree;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SWEA_1248_공통조상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			// 정점의 개수 (10<=V<=10000)
			int V = sc.nextInt();
			// 간선의 개수
			int N = sc.nextInt();
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
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

			// 시조를 찾을때까지 탐색
			// 부모 세트
			String p1s;
			Set<Integer> p2set = new HashSet<>();
			// 최초 부모 설정 (직계 부모)
			int p1 = tree[n1][2];
			int p2 = tree[n2][2];
			// 부모 세트에 직계 부모 넣기
			p1s = Integer.toString(p1);
			while (p1 != 0) {
				p1 = tree[p1][2];
				if (p1 == 0)
					break;
				p1s += " " + p1;
			}
			while (p2 != 0) {
				p2 = tree[p2][2];
				if (p2 == 0)
					break;
				p2set.add(p2);
			}
			int commonP = 0;

			String[] sl1 = p1s.split(" ");
			for (int i = 0; i < sl1.length; i++) {
				if (p2set.contains(Integer.parseInt(sl1[i]))) {
					commonP = Integer.parseInt(sl1[i]);
					break;
				}
			}

			int cnt;
			int v = commonP;
			cnt = 1;
			do {
				if (tree[v][1] != 0) {
					int temp = tree[v][1];
					tree[v][1] = 0;
					v = temp;
					cnt++;
				} else if (tree[v][0] != 0) {
					int temp = tree[v][0];
					tree[v][0] = 0;
					v = temp;
					cnt++;
				} else {
					v = tree[v][2];
				}
			} while (v != tree[commonP][2]);

			System.out.println("#" + tc + " " + commonP + " " + cnt);

		}
		sc.close();
	}
}
