package sort;

import java.util.Scanner;

// 250210
public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			// 회차수
			sc.nextInt();
			sc.nextLine(); // 개행 문자 처리 때문에 한번더 호출

			// 1000명의 학생의 점수를 받고자 함
			int[] scoreCases = new int[1000];
			// 띄어쓰기를 통해 주어진 점수
			int idx = 0;
			String nums = sc.nextLine();
			for (String s : nums.split(" ")) {
				scoreCases[idx++] = Integer.parseInt(s);
			}

			// 0점~100점의 점수가 있으므로 count 배열 생성
			int[] count = new int[101];
			for (int i = 0; i < 1000; i++) {
				count[scoreCases[i]]++;
			}

			// maxIdx를 0이라 가정하고 count 배열의 크기를 버블같이 비교하여 maxIdx를 갈아끼움
			int maxIdx = 0;
			for (int i = 1; i < 101; i++) {
				// 최빈값이 동일한 경우 더 큰 점수를 출력하므로 동등비교도 같이 사용
				if (count[maxIdx] <= count[i])
					maxIdx = i;
			}

			// 인덱스가 곧 점수이므로 최빈값 점수 출력
			System.out.println("#" + (tc + 1) + " " + maxIdx);
		}
		sc.close();
	}

}
