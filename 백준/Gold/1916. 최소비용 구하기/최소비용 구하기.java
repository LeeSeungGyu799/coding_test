import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m, start, end;
	static int[] dist;
	static ArrayList<int[]>[] graph;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		m = Integer.parseInt(bf.readLine());

		graph = new ArrayList[n + 1];
		dist = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new int[] { e, w });
		}

		st = new StringTokenizer(bf.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dij(start);
		System.out.println(dist[end]);
	}

	public static void dij(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		pq.offer(new int[] { start, 0 });
		dist[start] = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int node = now[0];
			int cost = now[1];

			if (dist[node] < cost)
				continue;

			if (node == end)
				return;

			for (int[] next : graph[node]) {
				int nextNode = next[0];
				int nextCost = cost + next[1];

				if (nextCost < dist[nextNode]) {
					dist[nextNode] = nextCost;
					pq.offer(new int[] { nextNode, nextCost });
				}
			}
		}
	}
}