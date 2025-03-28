package array.twodimensional;

import java.util.Scanner;

public class SWEA_14555_공과잡초 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		int tc = 0;
		while (tc++ < T) {
			// 개수 세기
			int cnt = 0;

			String s = sc.nextLine();
			char[] cs = s.toCharArray();
			
			for (int i = 0; i < cs.length; i++) {
				char c = s.toCharArray()[i];
				// 괄호를 세서 가려진 공일 가능성을 세어준다.
				switch (c) {
				case '(': {
					// 이 분기처리가 중요
					// 연달아 있는 괄호의 경우, 명백한 공
					// 때문에 다음 i를 건너뛰어줌!
					if (i + 1 < cs.length && cs[i + 1] == ')')
						i++;
					cnt++;
					break;
				}
				case ')':
					cnt++;
					break;
				default:
					break;
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}

		sc.close();
	}
}
