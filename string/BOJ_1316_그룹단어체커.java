package string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1316_그룹단어체커 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 97~122
		int length = (int) 'z' - (int) 'a' + 1;
		boolean[] arr;

		int res = N;

		// 1~100
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			arr = new boolean[length];

			boolean isGroupWord = true;
			char prev = (char) 95;
			for (char c : str.toCharArray()) {
				
				if ((int) prev >= (int) 'a' && prev != c && arr[(int) c - (int) 'a']) {
					isGroupWord = false;
					break;
				}
				
				arr[(int) c - (int) 'a'] = true;
				prev = c;
			}
			if (!isGroupWord) {
				res--;
			}
		}

		System.out.println(res);
	}
}
