package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//33,920 kb
//메모리
//117 ms
//실행시간
//2,264
//코드길이
public class SWEA_1248_공통조상 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bw = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bw.readLine());
		int tc = 0;
		while (tc++ < T) {
			StringTokenizer st = new StringTokenizer(bw.readLine());
			// 정점의 개수 (10<=V<=10000)
			int V = Integer.parseInt(st.nextToken());
			// 간선의 개수
			int N = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
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
	}
}
