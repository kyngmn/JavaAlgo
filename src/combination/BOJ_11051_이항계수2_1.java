package combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2_1 {
	static int[] memo;
	static int MOD = 10007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 1~1000
		int N = Integer.parseInt(st.nextToken());
		// 0~N
		int K = Integer.parseInt(st.nextToken());

//			int binomialCoefficient = factorial(N) / factorial(K) * factorial(N - K);
//			binomialCoefficient = N * N-1...* K+1 / N-K * N-K-1 * ... * 1

		memo = new int[N + 1];

		int k = factorial(K);
		int nMinuK = factorial(N - K);
		int n = factorial(N);

		// 페르마의 소정리를 사용하여 K! * (N-K)!의 역원 구하기
		int denominator = (k * nMinuK) % MOD;
		int denominatorInverse = modInverse(denominator, MOD);

		int binomialCoefficient = (n * denominatorInverse) % MOD;
		System.out.println(binomialCoefficient);
	}

	private static int factorial(int n) {
//		System.out.println(n + " " + Arrays.toString(memo));
		if (n == 0 || n == 1)
			return 1;
		if (memo[n] > 0)
			return memo[n];

		memo[n] = (n * factorial(n - 1)) % MOD;
		return memo[n];
	}

	// 모듈러 곱셈 역원 (페르마의 소정리 사용)
	private static int modInverse(int a, int mod) {
		return power(a, mod - 2, mod);
	}

	// 거듭제곱 (a^b % mod) - 빠른 거듭제곱 (Exponentiation by Squaring)
	private static int power(int base, int exp, int mod) {
		int result = 1;
		while (exp > 0) {
			if ((exp & 1) == 1) { // 홀수이면 base를 곱함
				result = (result * base) % mod;
			}
			base = (base * base) % mod;
			exp >>= 1;
		}
		return result;
	}
}