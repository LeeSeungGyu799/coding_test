
// https://www.acmicpc.net/problem/3665
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] rank, indegree;
    static boolean[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        int t = Integer.parseInt(bf.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(bf.readLine());

            rank = new int[n];
            indegree = new int[n + 1];
            graph = new boolean[n + 1][n + 1];

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < n; i++) {
                rank[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    graph[rank[i]][rank[j]] = true;
                    indegree[rank[j]]++;
                }
            }

            m = Integer.parseInt(bf.readLine());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (graph[a][b]) {
                    graph[a][b] = false;
                    graph[b][a] = true;

                    indegree[b]--;
                    indegree[a]++;
                } else {
                    graph[b][a] = false;
                    graph[a][b] = true;

                    indegree[a]--;
                    indegree[b]++;
                }
            }
            sb.append(topologySort()).append("\n");
        }

        System.out.print(sb);
    }

    public static String topologySort() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (queue.isEmpty()) {
                return "IMPOSSIBLE";
            }

            if (queue.size() > 1) {
                return "?";
            }

            int now = queue.poll();
            result.append(now).append(" ");

            for (int next = 1; next <= n; next++) {
                if (graph[now][next]) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
        }

        return result.toString();
    }
}
