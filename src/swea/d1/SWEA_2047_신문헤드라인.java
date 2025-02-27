package swea.d1;

import java.util.Scanner;

public class SWEA_2047_신문헤드라인 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((int) c >= (int) 'a' && (int) c <= (int) 'z') {
				System.out.print((char) ((int) s.charAt(i) - (int) 'z' + (int) 'Z'));
			} else {
				System.out.print(c);
			}
		}
	}
}
