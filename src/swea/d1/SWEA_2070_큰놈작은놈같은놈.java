package swea.d1;

import java.util.Scanner;

public class SWEA_2070_큰놈작은놈같은놈 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			char res = '=';
			if (a < b) {
				res = '<';
			} else if (a > b) {
				res = '>';
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
