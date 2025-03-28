package swea.d1;

import java.util.Scanner;

public class SWEA_2056_연월일달력 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while (tc++ < T) {
			String s = sc.next();
			String year = s.substring(0, 4);
			String month = s.substring(4, 6);
			String date = s.substring(6, 8);

			if (Integer.parseInt(month) < 1 || Integer.parseInt(month) > 13 || Integer.parseInt(date) < 1
					|| Integer.parseInt(date) > 31) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}

			int m = Integer.parseInt(month);
			int d = Integer.parseInt(date);
			if (m == 2 && d > 28) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}
			if ((m == 4 && d > 30) || (m == 6 && d > 30) || (m == 9 && d > 30) || (m == 11 && d > 30)) {
				System.out.println("#" + tc + " " + -1);
				continue;
			}

			System.out.println("#" + tc + " " + year + "/" + month + "/" + date);
		}
	}
}
