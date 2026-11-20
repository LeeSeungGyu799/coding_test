
// https://www.acmicpc.net/problem/14502
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int n, m, minInfect;
    static int[][] lab;
    static ArrayList<int[]> source;
    static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

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

        lab = new int[n][m];
        source = new ArrayList<>();
        int emptyCnt = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    source.add(new int[] { i, j });
                } else if (lab[i][j] == 0) {
                    emptyCnt++;
                }
            }
        }

        minInfect = Integer.MAX_VALUE;
        buildWall(0, 0);

        System.out.print(emptyCnt - minInfect - 3);
    }

    public static void buildWall(int depth, int start) {
        if (depth >= 3) {
            int result = calcInfect();
            if (result < minInfect) {
                minInfect = result;
            }
            return;
        }

        for (int i = start; i < n * m; i++) {
            int x = i / m;
            int y = i % m;

            if (lab[x][y] != 0)
                continue;

            lab[x][y] = 1;
            buildWall(depth + 1, i + 1);
            lab[x][y] = 0;
        }
    }

    public static int calcInfect() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < source.size(); i++) {
            q.offer(new int[] { source.get(i)[0], source.get(i)[1] });
            visited[source.get(i)[0]][source.get(i)[1]] = true;
        }

        int infected = 0;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dir[i][0];
                int ny = nowY + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) 
                    continue;
                if(visited[nx][ny] || lab[nx][ny] != 0)
                    continue;

                visited[nx][ny] = true;
                infected++;
                q.offer(new int[] {nx, ny});
            }
        }

        return infected;
    }
}

// 벽 반드시 3개
