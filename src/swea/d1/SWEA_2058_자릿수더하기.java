package swea.d1;

import java.util.Scanner;

public class SWEA_2058_자릿수더하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int res = 0;
		for (char c : s.toCharArray()) {
			res += (int) c - (int)'0';
		}
		System.out.println(res);
	}
}
