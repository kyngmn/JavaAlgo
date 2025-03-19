package permutation;

// 고양이 집 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Algo3_서울_11반_최경민 {
	public static int N;
	// 고양이 털이 발견된 집 배열
	public static char[] homes;
	// 고양이들의 털을 가진 고양이 List
	public static List<Character[]> cats;
	// 조합 개수
	public static int num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			num = 0;
			// 2~10
			N = Integer.parseInt(br.readLine());

			// 고양이 집 받기
			StringTokenizer st = new StringTokenizer(br.readLine());
			homes = new char[N];
			for (int i = 0; i < N; i++) {
				homes[i] = st.nextToken().charAt(0);
			}

			// 고양이 정보 초기화
			cats = new ArrayList<>();
			for (int cat = 0; cat < N; cat++) {
				st = new StringTokenizer(br.readLine());
				// 고양이 털 색상 1~5
				int C = Integer.parseInt(st.nextToken());
				Character[] colors = new Character[C];
				for (int i = 0; i < C; i++) {
					colors[i] = st.nextToken().charAt(0);
				}
				cats.add(colors);
			}

			bt(new int[N], 0, new boolean[N]);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(num);
			System.out.println(sb.toString());
		}
	}

	public static void bt(int[] temp, int start, boolean[] visited) {
		if (start == N) {
			num++;
			return;
		}

		for (int cat = 0; cat < N; cat++) {
			if (visited[cat])
				continue;
			Character[] colors = (Character[]) cats.get(cat);

			// 집주인
			char homeMaster = homes[start];
			if (thisCatHasThatColor(colors, homeMaster)) {
				visited[cat] = true;
				temp[start] = cat;
				bt(temp, start + 1, visited);
				visited[cat] = false;
			}
		}
	}

	/**
	 * 고양이가 특정 색상 털을 가지고 있는지 확인
	 * 
	 * @param catColor
	 * @param color
	 * @return boolean
	 */
	public static boolean thisCatHasThatColor(Character[] catColor, char color) {
		for (int i = 0; i < catColor.length; i++) {
			if (catColor[i] == color) {
				return true;
			}
		}
		return false;
	}
}
