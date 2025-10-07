import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_33703_건덕이의돌탑 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Long.parseLong(br.readLine());          // long 타입으로 읽기
        long res = N * (N + 1) / 2;  
		System.out.println(res);
	}
}
