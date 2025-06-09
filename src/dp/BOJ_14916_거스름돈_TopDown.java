package dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_14916_거스름돈_TopDown {
	static int[] changes = { 5, 2 };

	static Map<Integer, Integer> dp;
	static final int INF = Integer.MAX_VALUE;

	// 동전의 개수가 최소가 되도록!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp = new HashMap<>();

		int cnt = getMinChanges(n);

		System.out.println(cnt);
	}

	static int getMinChanges(int cost) {
		if (cost == 0)
			return 0;
		if (cost < 0)
			return INF;
		if (dp.containsKey(cost))
			return dp.get(cost);

		int min = INF;
		for (int coin : changes) {
			int res = getMinChanges(cost - coin);
			if (res != INF && res != -1) {
				min = Math.min(res + 1, min);
			}
		}

		dp.put(cost, min);
		return min == INF ? -1 : min;
	}

}
