package tree;

import java.util.Scanner;
import java.util.Stack;

//28,800 kb
//메모리
//127 ms
//실행시간
//1,620
//코드길이
public class SWEA_1232_사칙연산 {
	static int N;
	static int res;
	static Stack<Double> ops = new Stack<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			// tc마다 static 문자열 초기화
			ops.clear();
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

			for (int i = 1; i <= N; i++) {
//				System.out.print(sa[i] + " -> ");
//				System.out.println(Arrays.toString(tree[i]));
			}

			// 중위순회
			inOrder(tree, sa, 1);

//			System.out.println(ops);
			System.out.println("#" + tc + " " + ops.pop().intValue());
		}
		sc.close();
	}

	static void inOrder(int[][] tree, String[] sa, int v) {
		// 트리를 벗어났을 때 깊이 탐색 중단
		if (v >= sa.length)
			return;

		// 좌측 노드부터 깊이 있게 돌림
		inOrder(tree, sa, v * 2);
		inOrder(tree, sa, v * 2 + 1);
		// 좌측 노드 -> 중위 노드 순서로 순회하는 방식이기 때문에
		// 좌측 노드가 없거나, 방문했을 때
		// 중위 노드를 출력해야 함
		if (tree[v][0] == 0) {
			// 결과 문자열
			switch (sa[v]) {
			case "+": {
				double top = ops.pop();
				double bottom = ops.pop();
				ops.push(bottom + top);
				break;
			}
			case "-": {
				double top = ops.pop();
				double bottom = ops.pop();
				ops.push(bottom - top);
				break;
			}
			case "*": {
				double top = ops.pop();
				double bottom = ops.pop();
				ops.push(bottom * top);
				break;
			}
			case "/": {
				double top = ops.pop();
				double bottom = ops.pop();
				ops.push(bottom / top);
				break;
			}
			default: {
				ops.push(Double.parseDouble(sa[v]));
				break;
			}
			}
//			System.out.println(ops);

			// 부모 노드의 번호
			int p = tree[v][2];
			tree[p][0] = 0;
		}
	}

}
