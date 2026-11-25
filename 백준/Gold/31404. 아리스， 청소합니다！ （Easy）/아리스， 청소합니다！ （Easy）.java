// https://www.acmicpc.net/problem/31404
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dir = {{-1,0}, {0,1},{1,0},{0,-1}}; // 상 우 하 좌
    static int[][][] map; // 0 = a 1 = b
    static int x, y, curDir;
    static int n, m;

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

        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        curDir = Integer.parseInt(st.nextToken());

        map = new int[n][m][2];

        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                String s = bf.readLine();
                for(int k = 0; k < m; k++) {
                    map[j][k][i] = s.charAt(k) - '0';
                }
            }
        }

        System.out.print(clean());
    }

    public static int clean() {
        boolean[][] cleaned = new boolean[n][m];
        int[][][] visited = new int[n][m][4]; // 다시 똑같이 왔으면, 순환 -> return

        int cleanCnt = 0;
        int moveCnt = 0;
        int result = 0;

        while(true) {
            if(x < 0 || y < 0 || x >= n || y >= m) {
                break;
            }

            if(!cleaned[x][y]) {
                cleaned[x][y] = true;
                cleanCnt++;
                
                curDir = (curDir + map[x][y][0]) % 4;

                result = moveCnt + 1;
            } else {
                if(visited[x][y][curDir] == cleanCnt) 
                    break;


                visited[x][y][curDir] = cleanCnt;
                curDir = (curDir + map[x][y][1]) % 4; 
            }

            x += dir[curDir][0];
            y += dir[curDir][1];

            moveCnt++;
        }

        return result;
    }
}
