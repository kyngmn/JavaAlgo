package unsorted;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_14606_피자Small_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

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

		// 3*2 1 1*2 1*1 1*1
		System.out.println(sum);
		sc.close();
	}
}
