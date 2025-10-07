package swea.d1;

import java.util.Scanner;

public class SWEA_2029_몫과나머지출력하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int q = a / b;
			int r = a % b;
			System.out.println("#" + tc + " " + q + "" + r);
		}
	}
}
