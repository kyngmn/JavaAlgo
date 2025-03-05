package unsorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 문제 조건이 좀 이상한듯
public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int tc = 0;
		int[] changes = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };
		while (tc++ < T) {
			int paid = Integer.parseInt(br.readLine().trim());
			int[] cnt = new int[changes.length];
			int idx = 0;
			while (idx < changes.length) {
				if (changes[idx] > paid) {
					idx++;
					continue;
				}

				int quotient = paid / changes[idx];
				cnt[idx] = quotient;
				paid -= cnt[idx] * changes[idx];
				idx++;
			}

			System.out.println("#" + tc);
			for (int i = 0; i < cnt.length; i++) {
				if(i == cnt.length - 1) System.out.print(cnt[i]);
				else System.out.print(cnt[i] + " ");
			}
			System.out.println();
		}
	}
}
