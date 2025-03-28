package mst.kruskal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 크루스칼 {
	static int[] p; // 대표를 저장할 배열
	static int[] rank;// 균형있는 트리 -> 안쓴다.
	static final int COST = 2;
	// 간선을 저장!
	// 1. Edge 클래스 생성
	// 2. int[]

	static class Edge implements Comparable<Edge> {
		int s, e, cost;

		public Edge(int s, int e, int cost) {
			this.s = s;
			this.e = e;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [s=" + s + ", e=" + e + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
//			return Integer.compare(this.cost, o.cost);
		}
	}// class 선언

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 개수(시작번호 확인 -> 0번부터 시작)
		int E = sc.nextInt(); // 간선의 개수

		Edge[] edges = new Edge[E];

		int[][] edges2 = new int[E][3]; // [0]s, [1]e, [2]cost

		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt();

			edges[i] = new Edge(s, e, cost);
			edges2[i] = new int[] { s, e, cost };
		} // 간선입력완료

		// 1. 정렬을 하자 -> 가중치 오름차순으로 정렬!

//		Arrays.sort(edges);

		Arrays.sort(edges, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return o1.cost - o2.cost;
			}
		});

		Arrays.sort(edges2, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[COST] - o2[COST];
			}
		});

		for (int[] a : edges2) {
			System.out.println(Arrays.toString(a));
		}

		// 2. V-1개의 간선을 뽑아(사이클 X)
		// 서로소 집합 (유니온 파인드)
		p = new int[V];

		// make-set을 통해서 각자 본인이 대표가 되도록 초기화
		for (int i = 0; i < V; i++) {
//			makeSet(i);
			p[i] = i;
		} // 초기화 완료

		int ans = 0; // 누적 비용
//		int pick = 0; // 내가 뽑은 개수
		for (int i = 0, pick = 0; i < E && pick < V - 1; i++) {
//			int s = edges[i].s;
//			int e = edges[i].e;

			int px = findSet(edges[i].s);
			int py = findSet(edges[i].e);

			// 사이클 검사를 수행하자!
//			if(findSet(s) != findSet(e)) {
			if (px != py) {
				// 합쳐 -> 해당 간선을 뽑았다!
				union(px, py);
				pick++;
				ans += edges[i].cost;
			} // 사이클검사

//			if (pick == V - 1)
//				break;

		}

		System.out.println(ans);

	}// main

	static void union(int x, int y) {
		// rank를 고려하고 있진 않다!
//		p[findSet(y)] = findSet(x);

		// 대표가 내려올거야!
		p[y] = x;
	}

	static int findSet(int x) {
		// 기교 x -> 순수 그자체
//		if(x == p[x]) return x;
//		return findSet(p[x]);

		// 경로압축
		if (x != p[x])
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void makeSet(int x) {
		p[x] = x;
	}

	static String input = "7 11\r\n" + "0 1 32\r\n" + "0 2 31\r\n" + "0 5 60\r\n" + "0 6 51\r\n" + "1 2 21\r\n"
			+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "3 5 18\r\n" + "4 5 40\r\n" + "4 6 51\r\n" + "";
}
