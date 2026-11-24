import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int n, m;
	static int[] dist;
	static ArrayList<int[]>[] graph;
	static int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dist = new int[n+1];
		graph = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[s].add(new int[] {e,w});
			graph[e].add(new int[] {s,w});
		}
		
		for(int i = 1; i <= n; i++) {
			dist[i] = INF;
		}

		dij(1);
		System.out.println(dist[n]);
	}
	
	public static void dij(int start) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
		pq.offer(new int[] {start, 0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			int node= now[0];
			int nowWeight = now[1];
			
			if(dist[node] < nowWeight)
				continue;
			if(node == n) 
				return;
			
			for(int[] next: graph[node]) {
				int nextNode = next[0];
				int weight = nowWeight + next[1];
				
				if(weight < dist[nextNode]) {
					dist[nextNode] = weight;
					pq.offer(new int[] {nextNode, weight});
				}
			}
		}
	}
}