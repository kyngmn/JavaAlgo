package sort;

import java.util.Scanner;

//250206
public class SWEA_2068_최대수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < T; i++) {
			int max = 0;
			for (int j = 0; j < 10; j++) {
				int num = sc.nextInt();
//				max = Math.max(max, num);
				if (max < num)
					max = num;
			}
			System.out.print("#");
			System.out.print(i + 1);
			System.out.print(" ");
			System.out.println(max);
		}

		sc.close();
	}
}
