import java.io.*;
import java.util.StringTokenizer;

class GR_195700_중첩점 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 크기 1~100
		int N = Integer.parseInt(st.nextToken());
		// 반직선의 개수 1~100000
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			String dir = st.nextToken();
		}

		System.out.println();
	}
}