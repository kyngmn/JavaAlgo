package unsorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Scanner;
import java.util.StringTokenizer;

// gpt왈 구현 방식의 brute-force search + 최적화
// 가능한 풀이
// dfs / bfs
// 슬라이딩 윈도우

public class SWEA_1979_어디에단어가들어갈수있을까 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		while (tc++ < T) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(str.nextToken());
			int K = Integer.parseInt(str.nextToken());
			// NbyN 배열
//			int N = sc.nextInt();
			// 들어갈 단어 자리수
//			int K = sc.nextInt();
			// 배열받기
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				str = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(str.nextToken());
//					arr[i][j] = sc.nextInt();
				}
			}

			// 단어가 들어갈 수 있는 경우의 수
			int cnt = 0;

			// 가로 loop 탐색
			for (int i = 0; i < N; i++) {
				int tmp = 0;
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						tmp++;
					} else {
						if (tmp == K) {
							cnt++;
							tmp = 0;
						} else {
							tmp = 0;
						}
					}

					// 더 돌아도 단어가 들어갈 수 없는 경우 loop 중단
					if (N - j - 1 < K - tmp)
						break;
				}
				if (tmp == K)
					cnt++;
			}
			// 세로 loop 탐색
			for (int j = 0; j < N; j++) {
				int tmp = 0;
				for (int i = 0; i < N; i++) {
					if (arr[i][j] == 1) {
						tmp++;
					} else {
						if (tmp == K) {
							cnt++;
							tmp = 0;
						} else {
							tmp = 0;
						}
					}

					// 더 돌아도 단어가 들어갈 수 없는 경우 loop 중단
					if (N - i - 1 < K - tmp)
						break;
				}
				if (tmp == K)
					cnt++;
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
