package hash;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;


public class BOJ_11478_서로다른부분문자열의개수 {
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String S = br.readLine();
	        int N = S.length();

	        Set<String> set = new HashSet<>();

	        for (int i = 0; i < N; i++) {
	            StringBuilder sb = new StringBuilder();
	            for (int j = i; j < N; j++) {
	                sb.append(S.charAt(j));
	                set.add(sb.toString());
	            }
	        }

	        System.out.println(set.size());
	    }
}
