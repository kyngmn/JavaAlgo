package linkedlist;

import java.util.LinkedList;
import java.util.Scanner;

//27,136 kb
//메모리
//112 ms
//실행시간
//983
//코드길이
public class 최경민_SWEA_1228_암호문1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = 0;
		while (tc++ < 10) {
			// 암호문 길이
			int N = sc.nextInt();

			// 암호문
			LinkedList<Integer> cipher = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				cipher.add(sc.nextInt());
			}

			// 명령어 개수
			int C = sc.nextInt();
			sc.nextLine();
			String s = sc.nextLine();
			String[] ss = s.split(" ");

			int execute = 0;
			int i = 0;
			while (execute < C) {
				// 새로운 명령어 시작
				int x = Integer.parseInt(ss[++i]);
				int y = Integer.parseInt(ss[++i]);
				for (int j = 0; j < y; j++) {
					cipher.add(x + j, Integer.parseInt(ss[++i]));
				}

				i++;
				execute++;
			}

			System.out.print("#" + tc);
			for (int j = 0; j < 10; j++) {
				System.out.print(" " + cipher.get(j));
			}
			System.out.println();
		}

		sc.close();
	}
}
