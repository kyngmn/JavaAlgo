import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1038_감소하는수 {
	static ArrayList<Long> list = new ArrayList<>();

// 감소하는 숫자 탐지
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		for (int i = 0; i <= 9; i++) {
			dfs(i, 1);
		}

		Collections.sort(list);

		if (N >= list.size()) {
			System.out.println(-1);
		} else {
			System.out.println(list.get(N));
		}

		sc.close();
	}

	static void dfs(long num, int length) {
		list.add(num);
		int lastDigit = (int) (num % 10);
		for (int i = 0; i < lastDigit; i++) {
			dfs(num * 10 + i, length + 1);
		}
	}
}
