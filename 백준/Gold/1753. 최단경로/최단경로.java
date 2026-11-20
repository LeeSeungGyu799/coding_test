import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int V, E, K;
	static int[] dist;
	static ArrayList<int[]>[] route;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(bf.readLine());

		route = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			route[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			route[start].add(new int[] {end, weight});
		}

		dist = new int[V + 1];
		Arrays.fill(dist, INF);
		dij(K);

		for (int i = 1; i <= V; i++) {
			if(dist[i] == Integer.MAX_VALUE) 
				System.out.println("INF");
			else 
				System.out.println(dist[i]);
		}
	}

	public static void dij(int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		dist[K] = 0;
		pq.offer(new int[] {K, 0});
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int cur = now[0];
			int cost = now[1];
			
			if(cost > dist[cur])
				continue;
			
			for(int[] next : route[cur]) {
				int to = next[0];
				int weight = next[1];
				
				if(dist[to] > cost + weight) {
					dist[to] = cost + weight;
					pq.offer(new int[] {to, dist[to]});
				}
			}
		}
	}
}