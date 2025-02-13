package stack;

import java.util.Scanner;
import java.util.Stack;

//46,184 kb
//메모리
//231 ms
//실행시간
//1,134
//코드길이
// stack으로 풀라고 하지 않았으면 헤맷을 문제,,
public class SWEA_5432_쇠막대기자르기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int tc = 1; tc <= T; tc++) {
			// 괄호받기
			String str = sc.nextLine();

			// 각 철강을 담는 스택
			// 스택 프레임 하나에는 n개의 레이저가 조사됨
			Stack<Integer> s = new Stack<>();
			char[] arr = str.toCharArray();

			// 몇 개의 레이저가 나오는지
			int cnt = 0;
			for (int i = 0; i < arr.length; i++) {

				// 레이저!
				if (arr[i] == '(' && arr[i + 1] == ')') {
					// 레이저 쌍으로 체크했으니까 건너뛰기 연산 필요
					i = i + 1;
					// stack에 담긴 내용이 없으면 (= 철강이 없음)
					if (s.size() == 0)
						continue;
					// stack에 철강이 있으면
					// 레이저가 하나씩 조사될때마다
					// 해당 요소 하나를 +1 증가 시켜줌
//					for (int j = 0; j < s.size(); j++) {
//						s.set(j, s.get(j) + 1);
//					}
					// 위에꺼 시간초과 뜸
					
					cnt += s.size();
				} else {
					switch (arr[i]) {
					case '(':
						s.push(0);
						break;
					case ')':
						int popped = s.pop();
						cnt += popped + 1;
						break;
					default:
						break;
					}
				}

			}

			System.out.println("#" + tc + " " + cnt);
		}
	}
}
