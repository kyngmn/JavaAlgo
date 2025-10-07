package subset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Pair {
	static int score;
	static int calorie;

	public Pair(int score, int calorie) {
		this.score = score;
		this.calorie = calorie;
	}
}

public class SWEA_5215_햄버거다이어트 {
	public static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			st = new StringTokenizer(br.readLine());
			// 재료의 점수
			int N = Integer.parseInt(st.nextToken());
			// 재료의 칼로리
			int L = Integer.parseInt(st.nextToken());

			int[] scores = new int[N];
			int[] calories = new int[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				scores[i] = s;
				calories[i] = c;
			}
			
			for (int i = 0; i < calories.length; i++) {
//				dfs(i, )
			}
			
			for (int i = 0; i < N; i++) {
			}
			System.out.println("#" + tc + " "+max);
		}
	}
	
	private void dfs(int start, int cnt, int[] temp) {
		
	}
}
