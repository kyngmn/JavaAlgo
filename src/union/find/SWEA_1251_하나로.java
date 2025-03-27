package union.find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class CoordinateWeight {
	private int a;
	private int b;
	private double weight;

	public CoordinateWeight(int a, int b, double weight) {
		this.a = a;
		this.b = b;
		this.weight = weight;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "CoordinateWeight [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}

public class SWEA_1251_하나로 {
	static int[] parent;
	static double E;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int tc = 0;
		StringTokenizer st;
		while (tc++ < T) {
			// 1~1000
			int N = Integer.parseInt(br.readLine());
			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			int[][] graph = new int[N + 1][2];
			st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st2.nextToken());
				graph[i] = new int[] { x, y };
			}

			E = Double.parseDouble(br.readLine());

			// 애초에 간선수가 너무 많고,
			// double[3]은 메모리 많이 씀.
			List<CoordinateWeight> possibleEdges = new ArrayList<>();
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j <= N; j++) {
					possibleEdges.add(new CoordinateWeight(i, j,
							getEnvironmentCharge(graph[i][0], graph[i][1], graph[j][0], graph[j][1])));
				}
			}

			possibleEdges.sort((a, b) -> Double.compare(a.getWeight(), b.getWeight()));

			double sum = 0;
			for (CoordinateWeight node : possibleEdges) {
//				System.out.println(Arrays.toString(arr));
				int a = node.getA();
				int b = node.getB();
				double weight = node.getWeight();

				if (find(a) != find(b)) {
					union(a, b);
					sum += weight;
				}
			}

			// 출력
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(Math.round(sum));
			System.out.println(sb);
		}
	}

	static double getEnvironmentCharge(int x1, int y1, int x2, int y2) {
		double dx = x1 - x2;
		double dy = y1 - y2;
		return E * (dx * dx + dy * dy);
	}

	static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return;

		parent[rootB] = rootA;
	}

	static int find(int a) {
		if (parent[a] != a) {
			return parent[a] = find(parent[a]);
		}
		return a;
	}
}
