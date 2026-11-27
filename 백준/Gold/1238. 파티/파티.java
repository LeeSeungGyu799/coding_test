// https://www.acmicpc.net/problem/1238
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  static int n, m, x;
  static ArrayList<int[]>[] graph, reverseGraph;
  static int[] dist;
  static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        reverseGraph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
          graph[i] = new ArrayList<>();
          reverseGraph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
          st = new StringTokenizer(bf.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());
          int weight = Integer.parseInt(st.nextToken());

          graph[start].add(new int[] {end, weight});
          reverseGraph[end].add(new int[] {start, weight});
        }

        
        int[] distGo = dij(x, graph);
        int[] distFrom = dij(x, reverseGraph);
        
        int max = -1;
        for(int i = 1; i <= n; i++) {
          max = Math.max(distGo[i] + distFrom[i], max);
        }
        System.out.println(max);
    }

    static int[] dij(int start, ArrayList<int[]>[] targetGraph) {
      PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
      dist = new int[n+1];
      for(int i= 1; i <= n; i++) {
          dist[i] = INF;
      }

      pq.offer(new int[] {start, 0});
      dist[start] = 0;

      while(!pq.isEmpty()) {
        int[] now = pq.poll();
        int node = now[0];
        int cost = now[1];

        if(cost > dist[node]) 
          continue;

        for(int[] next: targetGraph[node]) {
          int nextNode = next[0];
          int nextCost = next[1] + cost;

          if(nextCost < dist[nextNode]){
            dist[nextNode] = nextCost;
            pq.offer(new int[] {nextNode, nextCost});
          }
        }
      }
      return dist;
    }
}
