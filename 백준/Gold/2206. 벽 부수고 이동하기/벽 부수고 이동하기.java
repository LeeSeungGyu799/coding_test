
// https://www.acmicpc.net/problem/2206
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minLen;
    static int[][] map;
    static boolean[][][] visited;
    static int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = bf.readLine();

            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        minLen = Integer.MAX_VALUE;
        bfs(0);

        if(minLen == Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            System.out.print(minLen);
        }
        
    }

    public static void bfs(int didBroke) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        visited = new boolean[n][m][2];
        q.offer(new int[] { 0, 0, didBroke, 1 }); // x y 부쉈는지 거리
        visited[0][0][didBroke] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int didBreak = now[2];
            int dist = now[3];

            if (x == n - 1 && y == m - 1) {
                minLen = dist;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;
                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][didBreak]) {
                        visited[nx][ny][didBreak] = true;
                        q.offer(new int[] { nx, ny, didBreak, dist + 1 });
                    }
                } else if (didBreak == 0) {
                    if (!visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new int[] { nx, ny, 1, dist + 1 });
                    }
                }
            }
        }
    }
}
