package swea.d1;

import java.util.Scanner;

public class SWEA_2019_더블더블 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i <= N; i++) {
			System.out.print((int) Math.pow(2, i) + " ");
		}
	}
}
