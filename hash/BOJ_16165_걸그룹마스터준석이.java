package hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_16165_걸그룹마스터준석이 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// 최대 100글자 알파벳 소문자
		Map<String, List<String>> groupToMembers = new HashMap<>();
		Map<String, String> memberToGroup = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String groupName = br.readLine();
			int memberCount = Integer.parseInt(br.readLine());

			List<String> members = new ArrayList<>();
			for (int j = 0; j < memberCount; j++) {
				String member = br.readLine();
				members.add(member);
				memberToGroup.put(member, groupName);
			}
			Collections.sort(members); // 사전순 정렬
			groupToMembers.put(groupName, members);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			String query = br.readLine();
			int type = Integer.parseInt(br.readLine());

			if (type == 0) {
				for (String member : groupToMembers.get(query)) {
					sb.append(member).append("\n");
				}
			} else {
				sb.append(memberToGroup.get(query)).append("\n");
			}
		}

		System.out.print(sb);
	}
}
