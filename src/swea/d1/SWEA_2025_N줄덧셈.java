package swea.d1;

import java.util.Scanner;

public class SWEA_2025_N줄덧셈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
}
