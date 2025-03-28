package unsorted;

import java.util.Scanner;

public class SWEA_2007_패턴마디의길이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		int N = 30;
		while (tc++ < T) {
			String s = sc.next();
			// 총 30
			// 마디 최대 10
			for (int i = 1; i <= 10; i++) {
				String first = s.substring(0, i);
				int l = first.length();
				for (int j = 1; j < N / l; j++) {

					String sub = s.substring(l * j, l * j + i > 30 ? 30 : l * j + i);
//					System.out.println(first + ", " + sub);

					if (!first.equals(sub) || !first.contains(sub)) {
						l = -1;
						break;
					}
				}
				if (l != -1) {
					System.out.println("#" + tc + " " + l);
					break;
				}
			}

		}
	}
}
