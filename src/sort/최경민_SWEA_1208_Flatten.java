package sort;

import java.util.Scanner;

// 250210
public class 최경민_SWEA_1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// test case 고정
		for (int tc = 0; tc < 10; tc++) {
			// 덤프 횟수 주어짐
			int D = sc.nextInt();
			sc.nextLine(); // 개행 문자 처리를 위해 호출
			
			// 숫자 문자열 => int 배열 처리
			String numString = sc.nextLine();
			int[] arr = new int[100];
			int[] sorted = new int[100];
			int idx = 0;
			for (String s : numString.split(" ")) {
				arr[idx++] = Integer.parseInt(s);
			}
			// counting sort 이용
			sorted = countingSort(arr);
			
			// 실제 덤프 횟수
			int cnt = 0;
			// 최고점과 최저점 차이
			int diff = sorted[99] - sorted[0];
			// 경계값 주의!
			// 제한된 덤프 횟수까지 덤핑 실행할 것임
			while (cnt < D) {
				// 차이가 0 또는 1인 경우는 덤핑 끝 -> 덤핑 중단
				if (diff == 0 || diff == 1)
					break;
				
				// sort된 상태이므로, 최저점은 증가, 최고점은 감소
				sorted[0]++;
				sorted[99]--;
				
				// 증감 처리 이후에 sorted배열이 여전히 정렬되어있는지 판단
				if (sorted[0] > sorted[1] || sorted[98] > sorted[99])
					sorted = countingSort(sorted);
				
				// 덤핑 횟수 처리
				cnt++;
				// 최고점-최저점 차잇값 갱신
				diff = sorted[99] - sorted[0];
			}

			System.out.println("#" + (tc + 1) + " " + diff);
		}
		sc.close();
	}

	private static int[] countingSort(int[] arr) {
		int K = 0;
		for (int i = 0; i < arr.length; i++) {
			if (K < arr[i])
				K = arr[i];
		}
		int[] count = new int[K + 1];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < K + 1; i++) {
			count[i] += count[i - 1];
		}
		int[] sorted = new int[arr.length];
		for (int i = arr.length - 1; i > -1; i--) {
			sorted[--count[arr[i]]] = arr[i];
		}
		return sorted;
	}
}
