package stack;

import java.util.Scanner;
import java.util.Stack;

//JAVA
//언어
//27,008 kb
//메모리
//99 ms
//실행시간
//2,252
//코드길이
public class 최경민_SWEA_1224_계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			// 문자열 길이
			int N = sc.nextInt();
			sc.nextLine();

			// 연산자 스택
			Stack<Character> st = new Stack<>();
			// 후위표기식
			StringBuilder sb = new StringBuilder();

			// 중위표기식
			// 연산자 +, *, () 만 나옴
			// 피연산자 0이상 9이하
			String str = sc.nextLine();
			for (int i = 0; i < N; i++) {
				char c = str.charAt(i);

				// 문자 분기 처리 시작
				// 숫자일 때
				// 숫자 검사 & 문자열에 무조건
				if ((int) c >= 48 && (int) c <= 57) {
					sb.append(c);
				}
				// 곱하기(*) 일 때
				// 스택에 무조건
				else if (c == '*') {
					st.add(c);
				}
				// 더하기(+) 일 때
				// * 연산자보다 우선 순위가 낮으므로
				// stack의 top이 *이 아닐 때까지 pop & append
				// add +
				else if (c == '+') {
					// System.out.println(i + " >> 스택에 쌓여있는 연산자" + st.peek() + ", " + sb);
					while (!st.isEmpty() && st.peek() == '*') {
						sb.append(st.pop());
					}
					st.add(c);
				}
				// ( 일 때
				// 스택에 무조건
				else if (c == '(') {
					st.add(c);
				}
				// ) 일 때
				// stack의 top이 닫는 괄호가 아닐때까지 pop & append
				// 닫는 괄호는 pop만
				else if (c == ')') {
					if (st.isEmpty())
						continue;
					while (st.peek() != '(') {
						sb.append(st.pop());
					}
					if (st.peek() == '(')
						st.pop();
				}
			}

			// 전체 문자열에 괄호가 쌓여있지 않으면 stack을 비우지 않기 때문에 후처리함
			while (st.size() > 0) {
				char popped = st.pop();
				if (!st.isEmpty() && popped != '(') {
					sb.append(popped);
				}
			}

//			System.out.println(sb);

			// 계산 => 스택을 이용하여 계산할 것임
			Stack<Integer> calc = new Stack<>();
			for (int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				switch (c) {
				case '+': {
					int res = calc.pop() + calc.pop();
					calc.add(res);
					break;
				}
				case '*': {
					int res = calc.pop() * calc.pop();
					calc.add(res);
					break;
				}
				default:
					calc.add(Integer.parseInt(Character.toString(c)));
					break;
				}
			}

			System.out.println("#" + tc + " " + calc.pop());
		}
		sc.close();
	}
}
