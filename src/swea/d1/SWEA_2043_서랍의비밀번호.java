package swea.d1;

import java.util.Scanner;

public class SWEA_2043_서랍의비밀번호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int from = sc.nextInt();
		int to = sc.nextInt();
		System.out.print(from - to + 1);
	}
}
