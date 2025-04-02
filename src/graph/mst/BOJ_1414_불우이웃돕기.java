package graph.mst;

import java.io.*;
import java.util.*;

class Vertex {
    int to, cost;
    public Vertex(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
}

public class BOJ_1414_불우이웃돕기 {
    static int N;
    static boolean[] visited;
    static int[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        adj = new int[N][N];
        visited = new boolean[N];

        int total = 0;

        // 입력 파싱
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                int cost = 0;

                if (c == '0') continue;
                else if (c >= 'a' && c <= 'z') cost = c - 'a' + 1;
                else cost = c - 'A' + 27;

                adj[i][j] = cost;

                // 총 랜선 길이 계산 (중복 방지 위해 i < j만 포함)
                if (i < j) total += cost;
            }
        }

        // 최소 스패닝 트리 비용 계산
        int mstCost = prim();
        // 연결이 불가능하면 -1, 아니면 기부할 수 있는 최대 길이 계산
        System.out.println(mstCost == -1 ? -1 : total - mstCost);
    }

    static int prim() {
        // 최소 힙을 사용하여 최소 비용 간선 우선 선택
        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        pq.offer(new Vertex(0, 0));

        int sum = 0;
        int count = 0;

        while (!pq.isEmpty()) {
            Vertex curr = pq.poll();
            if (visited[curr.to]) continue;

            visited[curr.to] = true;
            sum += curr.cost;
            count++;

            // 현재 정점에서 연결된 정점들 중 방문하지 않은 정점으로 간선 추가
            for (int i = 0; i < N; i++) {
                if (!visited[i] && adj[curr.to][i] > 0) {
                    pq.offer(new Vertex(i, adj[curr.to][i]));
                }
            }
        }

        // 모든 노드를 연결했으면 MST를 구성한 것
        return (count == N) ? sum : -1;
    }
}
