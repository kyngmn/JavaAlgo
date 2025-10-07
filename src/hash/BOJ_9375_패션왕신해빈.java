package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_9375_패션왕신해빈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		Map<String, Integer> map;

		for (int i = 0; i < N; i++) {
			map = new HashMap<>();
			int M = Integer.parseInt(br.readLine());

			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();

				map.put(category, map.getOrDefault(category, 0) + 1);
			}

			int comb = 1;
			for (int count : map.values()) {
				comb *= (count + 1);
			}

			System.out.println(comb - 1);
		}

	}

}
