// https://www.acmicpc.net/problem/2252
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++)
          graph[i] = new ArrayList<>();
        
        int[] indegree = new int[n + 1];
        for(int i = 0; i < m; i++) {
          st = new StringTokenizer(bf.readLine());
          int start = Integer.parseInt(st.nextToken());
          int end = Integer.parseInt(st.nextToken());

          indegree[end]++;

          graph[start].add(end);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();

        for(int i = 1; i <= n; i++) {
          if(indegree[i] == 0) {
            q.offer(i);
          }
        }

        while(!q.isEmpty()) {
          int target = q.poll();
          for(int next: graph[target]) {
            indegree[next]--;
            if(indegree[next] == 0)
              q.offer(next);
          }
          System.out.print(target + " ");
        }
        
        System.out.print(sb);
    }
}
