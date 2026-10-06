import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Solution {
    static int r, c;
    static int[][] map;

    // 상 좌 하 우
    static int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};

    static boolean[][][][] visited;
    static boolean possible;

    public static void main(String args[]) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        int T = Integer.parseInt(bf.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            st = new StringTokenizer(bf.readLine());
            sb = new StringBuilder();
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int[r][c];

            for (int i = 0; i < r; i++) {
                String s = bf.readLine();

                for (int j = 0; j < c; j++) {
                    insertMap(i, j, s.charAt(j));
                }
            } // 입력 끝

            visited = new boolean[r][c][4][16];
            possible = false;

            bfs();

            sb.append("#").append(test_case).append(" ");
            
            if(possible)
                sb.append("YES");
            else 
                sb.append("NO");
            
            System.out.println(sb);
        }

    }

    public static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {0, 0, 3, 0}); // 우

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int curDir = now[2];
            int memory = now[3];

            if (visited[x][y][curDir][memory])
                continue;

            visited[x][y][curDir][memory] = true;

            int command = map[x][y];

            if (command == 40) {
                possible = true;
                return;
            } // return 끝

            if (command >= 0 && command <= 9) { // 숫자
                memory = command;
            }
            else if (command == 10) { // 상좌하우
                curDir = 0;
            }
            else if (command == 11) {
                curDir = 1;
            }
            else if (command == 12) {
                curDir = 2;
            }
            else if (command == 13) {
                curDir = 3;
            }
            else if (command == 20) {
                if (memory == 0) {
                    curDir = 3; // 우
                } else {
                    curDir = 1; // 좌
                }
            }
            else if (command == 21) {
                if (memory == 0) {
                    curDir = 2; // 하
                } else {
                    curDir = 0; // 상
                }
            }
            else if (command == 23) {
                memory = (memory + 1) % 16; // +
            }
            else if (command == 24) { // -
                memory = (memory + 15) % 16;
            }
            else if (command == 30) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];

                    if (nx < 0) nx = r - 1;
                    else if (nx >= r) nx = 0;

                    if (ny < 0) ny = c - 1;
                    else if (ny >= c) ny = 0;

                    q.offer(new int[] {nx, ny, i, memory});
                }

                continue;
            }

            int nx = x + dir[curDir][0];
            int ny = y + dir[curDir][1];

            if (nx < 0) nx = r - 1;
            else if (nx >= r) nx = 0;

            if (ny < 0) ny = c - 1;
            else if (ny >= c) ny = 0;

            q.offer(new int[] {nx, ny, curDir, memory});
        }
    }

    public static void insertMap(int x, int y, char target) { // 지도 

        int result = 0;

        switch (target) {

        case '^':
            result = 10;
            break;
        case '<':
            result = 11;
            break;
        case 'v':
            result = 12;
            break;
        case '>':
            result = 13;
            break;
        case '_':
            result = 20;
            break;
        case '|':
            result = 21;
            break;
        case '.':
            result = 22;
            break;
        case '+':
            result = 23;
            break;
        case '-':
            result = 24;
            break;
        case '?':
            result = 30;
            break;
        case '@':
            result = 40;
            break;
        default:
            result = target - '0';
        }

        map[x][y] = result;
    }
}