package unsorted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나누기, 나머지 구하기 연산은
// 다른 연산자보다 시간이 많이 걸린다.
// 분기처리가 가능하거나, 쓰지 않는 쪽으로 코드를 작성할 수 있으면 안쓰는 방향으로 하기.
// 88ms -> 77ms
public class SWEA_1976_시각덧셈 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			st = new StringTokenizer(br.readLine());

			int h1 = Integer.parseInt(st.nextToken());
			int m1 = Integer.parseInt(st.nextToken());

			int h2 = Integer.parseInt(st.nextToken());
			int m2 = Integer.parseInt(st.nextToken());

			int hour = (h1 + h2);
			if (hour >= 13)
				hour = hour % 12;

			int minute = m1 + m2;
			if (minute >= 60) {
				hour++;
				minute -= 60;
			}

			System.out.println("#" + tc + " " + hour + " " + minute);
		}
	}
}
