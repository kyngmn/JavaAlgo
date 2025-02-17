package array.twodimensional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_10761_신뢰 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		int tc = 0;
		while (tc++ < T) {
			int N = sc.nextInt();
			String[] str = sc.nextLine().trim().split(" ");

			int B = 0;
			for (int j = 0; j < str.length; j++) {
				if (str[j].equals("B"))
					B++;
			}
			int O = N - B;

			int bIdx = 0;
			int[] b = new int[B];
			int oIdx = 0;
			int[] o = new int[O];

			Queue<Integer> qb = new LinkedList<>();
			Queue<Integer> qo = new LinkedList<>();

			int i = 0;
			int K = 0;
			while (i < N) {
				int num = Integer.parseInt(str[i * 2 + 1]);
				if (num > K)
					K = num;
				if (str[i * 2].equals("B")) {
					b[bIdx++] = num;
					qb.add(num);
				} else if (str[i * 2].equals("O")) {
					o[oIdx++] = num;
					qo.add(num);
				}
				i++;
			}

			int min = 0;
			int bb = 1;
			int oo = 1;
			while (B == 0 && O == 0) {
				min++;
if(B>0)
				bb++;
if(O>0)oo++;
				if (qb.peek() == bb && qo.peek() == oo) {
					B--;
					break;
				}
			}

			System.out.println("#" + tc + " " + min);
		}

		sc.close();
	}
}
