import java.util.*;
class Solution {
    ArrayList<Integer>[] graph;
    boolean[] visited;
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        
        for(int i = 0; i < edge.length; i++) {
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        
        dist = new int[n+1];
        visited = new boolean[n + 1];
        bfs(1);
        
        Arrays.sort(dist);
        int max = dist[dist.length-1];
        int cnt= 0;
        
        for(int i = dist.length-1; i >= 1; i--) {
            if(dist[i] == max)
                cnt++;
            else
                break;
        }
        return cnt;
    }
    
    public void bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : graph[cur]) {
                if(visited[next]) 
                    continue;
                
                visited[next] = true;
                dist[next] = dist[cur] + 1;
                q.offer(next);
            }
        }
    }
}