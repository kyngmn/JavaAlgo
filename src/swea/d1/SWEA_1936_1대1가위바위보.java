package swea.d1;

import java.util.Scanner;

public class SWEA_1936_1대1가위바위보 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		switch (a) {
		case 1:
			if (b == 2) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
			break;
		case 2:
			if (b == 1) {
				System.out.println("A");
			} else {
				System.out.println("B");
			}
			break;
		case 3:
			if (b == 1) {
				System.out.println("B");
			} else {
				System.out.println("A");
			}
			break;

		}
	}
}
