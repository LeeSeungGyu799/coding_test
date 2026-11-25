
// https://www.acmicpc.net/problem/19236
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader bf;
    static StringTokenizer st;

    static int answer;
    static int[][] map;
    static int[] fishDir;

    static int[][] dir = { { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }} ;

    public static void main(String[] args) throws Exception {
        bf = new BufferedReader(new InputStreamReader(System.in));

        map = new int[4][4];
        fishDir = new int[17];

        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(bf.readLine());

            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) - 1;

                map[i][j] = num;
                fishDir[num] = d;
            }
        }

        answer = 0;

        dfs(map, fishDir, 0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int[][] map, int[] fishDir, int x, int y, int sum) {

        int[][] copyMap = copy(map);
        int[] copyDir = fishDir.clone();

        int fish = copyMap[x][y];
        int sharkDir = copyDir[fish];

        sum += fish;
        answer = Math.max(answer, sum);

        copyMap[x][y] = -1;

        moveFish(copyMap, copyDir);
        copyMap[x][y] = 0;

        for (int i = 1; i <= 3; i++) {
            int nx = x + dir[sharkDir][0] * i;
            int ny = y + dir[sharkDir][1] * i;

            if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
                break;

            if (copyMap[nx][ny] == 0)
                continue;

            dfs(copyMap, copyDir, nx, ny, sum);
        }
    }

    public static void moveFish(int[][] map, int[] fishDir) {

        for (int num = 1; num <= 16; num++) {
            int x = -1;
            int y = -1;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (map[i][j] == num) {
                        x = i;
                        y = j;
                    }
                }
            }
            if (x == -1)
                continue;

            int d = fishDir[num];
            for (int i = 0; i < 8; i++) {
                int nd = (d + i) % 8;

                int nx = x + dir[nd][0];
                int ny = y + dir[nd][1];

                if (nx < 0 || nx >= 4 || ny < 0 || ny >= 4)
                    continue;

                if (map[nx][ny] == -1)
                    continue;
                int temp = map[nx][ny];

                map[nx][ny] = num;
                map[x][y] = temp;
                fishDir[num] = nd;

                break;
            }
        }
    }

    public static int[][] copy(int[][] map) {
        int[][] result = new int[4][4];

        for (int i = 0; i < 4; i++) {
            result[i] = map[i].clone();
        }

        return result;
    }
}