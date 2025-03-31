package swea.d1;

import java.util.Scanner;

public class SWEA_1938_아주간단한계산기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int plus = a + b;
		int minus = a - b;
		int multiply = a * b;
		int mod = a / b;
		System.out.println(plus);
		System.out.println(minus);
		System.out.println(multiply);
		System.out.println(mod);
	}
}
