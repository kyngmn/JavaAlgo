package stack;

import java.util.Scanner;

//JAVA
//언어
//27,136 kb
//메모리
//94 ms
//실행시간
//1,586
//코드길이
public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int L = sc.nextInt();
			sc.nextLine();
			// 괄호받기
			String str = sc.nextLine();

			// 개수가 홀수면 짝이 맞지 않으므로
			if (L % 2 == 1) {
				System.out.println("#" + tc + " " + 0);
				continue;
			}

			int validBinary = 1;

			// (), [], {}, <>
			// bracket은 closer + opener
			// 각 closer의 개수는 opener를 초과할 수 없다.
			int[] brackets = new int[4];

			loop: for (char c : str.toCharArray()) {
				switch (c) {
				case '(':
					brackets[0]++;
					break;
				case ')':
					if (brackets[0] <= 0) {
						// 이 룰을 깨는 순간 유효하지 않은 괄호 문자열
						validBinary = 0;
						break loop;
					} else
						brackets[0]--;
					break;
				case '[':
					brackets[1]++;
					break;
				case ']':
					if (brackets[1] <= 0) {
						validBinary = 0;
						break loop;
					} else
						brackets[1]--;
					break;
				case '{':
					brackets[2]++;
					break;
				case '}':
					if (brackets[2] <= 0) {
						validBinary = 0;
						break loop;
					} else
						brackets[2]--;
					break;
				case '<':
					brackets[3]++;
					break;
				case '>':
					if (brackets[3] <= 0) {
						validBinary = 0;
						break loop;
					} else
						brackets[3]--;
					break;
				}
			}

			// 열고, 닫지 않은 괄호 체크
			for (int i = 0; i < brackets.length; i++) {
				if (brackets[i] != 0) {
					validBinary = 0;
					break;
				}
			}

			System.out.println("#" + tc + " " + validBinary);
		}
	}
}
