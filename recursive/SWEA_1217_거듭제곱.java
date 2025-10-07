package recursive;

import java.util.Scanner;

//JAVA
//언어
//26,880 kb
//메모리
//93 ms
//실행시간
//716
//코드길이
public class SWEA_1217_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		while (tc++ < 10) {
			int T = sc.nextInt();

			int N = sc.nextInt();
			int M = sc.nextInt();

			int res = recur(N, M, 0, 1);
			System.out.println("#" + T + " " + res);
		}
	}

	/**
	 * 상수 역할! 지역 변수 역할을 매개 변수 형태로 갖고 있는 것
	 * 
	 * @param base     -> 밑
	 * @param exponent -> 지수
	 * @param i        -> 증가될 변수
	 * @param acc      -> 재귀 결과 전달
	 */
	private static int recur(int base, int depth, int i, int acc) {
		// 종결부
		if (i >= depth) {
			return acc;
		}

		// 호출부
		return recur(base, depth, i + 1, acc * base);
	}

}
