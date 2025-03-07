package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_2806_NQueen {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringBuilder sb = new StringBuilder();
		while (tc++ < T) {
			// 1~10
			int N = Integer.parseInt(br.readLine());
			sb.append("#").append(tc).append(" ");
			System.out.println(sb.toString());
		}
	}
}
