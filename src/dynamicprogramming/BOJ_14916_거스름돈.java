package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BOJ_14916_거스름돈 {
	static int[] changes = { 5, 2 };

	static Map<Integer, Integer> dp;

	// 동전의 개수가 최소가 되도록!
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		dp = new HashMap<>();

		int cnt = getChange(n);

		System.out.println(dp);

		System.out.println(cnt);
	}

	static int getChange(int cost) {
		int remainder = cost;
		for (int i = 0; i < changes.length; i++) {
			if (changes[i] > remainder)
				continue;

			if (changes[i] == remainder) {
				dp.put(remainder, 1);
			} else {
				int cnt = remainder / changes[i];
				int cleanCost = cnt * changes[i];
				if (cleanCost == remainder) {
					dp.put(remainder, cnt);
				} else {
					dp.put(cleanCost, cnt);
					dp.put(remainder, dp.get(cleanCost));
					remainder -= cleanCost;
				}
			}
		}
		return dp.get(cost);
	}

}
