import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14606_피자Small {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		bfs(N);
		dp(N);

		sc.close();
	}

	/**
	 * 최악의 경우 O(n^2)
	 * N이 커지면 비효율
	 */
	static void bfs(int N) {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(N);

		int sum = 0;
		while (!q.isEmpty()) {
			int num = q.poll();
			int a = num / 2;
			if (a > 0) {
				int b = num - a;
				sum += a * b;

				if (a > 1) {
					q.offer(a);
				}
				if (b > 1) {
					q.offer(b);
				}
			} else {
				break;
			}
		}
		System.out.println(sum);
	}

	/**
	 * 탑다운 dp
	 * N 범위가 작을 경우 코드 짧고 명확함
	 * N이 커져도 안정적임
	 * @param N
	 */
	static void dp(int N) {
		int[] dp = new int[11];
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 3;
		for (int i = 4; i <= 10; i++) {
			dp[i] = 0;
			for (int j = 1; j < i; j++) {
				dp[i] = Integer.max(dp[i], (i - j) * j + dp[i - j] + dp[j]);
			}
		}
		System.out.println(dp[N]);

	}
}
