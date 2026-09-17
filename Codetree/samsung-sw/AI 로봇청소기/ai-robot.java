import java.util.*;
import java.io.*;

public class Main {
    static int N, K, L;
    static int[][] map;
    static int[] robotX, robotY;
    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String s;

        s = bf.readLine();
        st = new StringTokenizer(s);
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        for (int i = 1; i < N + 1; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        robotX = new int[K]; // i번째 로봇의 x좌표
        robotY = new int[K];
        for (int i = 0; i < K; i++) {
            s = bf.readLine();
            st = new StringTokenizer(s);
            robotX[i] = Integer.parseInt(st.nextToken());
            robotY[i] = Integer.parseInt(st.nextToken());
        }

        for (int test = 0; test < L; test++) {
            move();
            clean();
            dustGrow();
            dustSpread();
            int dustResult = dustSum();
            System.out.println(dustResult);
        }
    }

    static void move() { // 모든 청소기를 맨해튼거리 기준 최소단거리의 오염격자로 이동.
        //bfs?
        for(int i = 0; i < K; i++) {
            visited = new boolean[N+1][N+1];
            bfs(i);
        }        
    }

    static void bfs(int robotNum) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int startX = robotX[robotNum];
        int startY = robotY[robotNum];
        q.offer(new int[] {startX, startY, 0});
        visited[startX][startY] = true;
        
        int minDist = Integer.MAX_VALUE;
        int targetX = -1;
        int targetY = -1;

        while(!q.isEmpty()) {
            int[] robotInfo = q.poll();
            int x = robotInfo[0];
            int y = robotInfo[1];
            int nowDist = robotInfo[2];

            if(nowDist > minDist)
                break;

            if(map[x][y] > 0) { // 오염지역 발견
                if(nowDist < minDist) {
                    minDist = nowDist;
                    targetX = x;
                    targetY = y;
                } else if (nowDist == minDist) {
                    if (x < targetX) {
                        minDist = nowDist;
                        targetX = x;
                        targetY = y;
                    } else if (x == targetX) {
                        if(y < targetY) {
                            minDist = nowDist;
                            targetX = x;
                            targetY = y;
                        }
                    }
                }
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];

                if(nx < 1 || ny < 1 || nx >= N+1 || ny >= N+1)
                    continue;
                if(visited[nx][ny])
                    continue;
                if(map[nx][ny] == -1)
                    continue;
                if(isRobot(nx,ny,robotNum))
                    continue;
                visited[nx][ny] = true;
                q.offer(new int[] {nx, ny, nowDist+1});
            }
        }
        if(targetX != -1) {
            robotX[robotNum] = targetX;
            robotY[robotNum] = targetY;
        }
    }

    static boolean isRobot(int x, int y, int robotNum) {
        for(int i = 0; i < K; i++) {
            if(i == robotNum)
                continue;
            if(robotX[i] == x && robotY[i] == y)
                return true;
        }
        return false;
    }

    static void clean() { // 모든 청소기가 청소.
        for (int i = 0; i < K; i++) {
            int maxDir = 0;
            int maxDust = Integer.MIN_VALUE;

            for (int robotDir = 0; robotDir < 4; robotDir++) {
                int dustNum = Math.min(20, map[robotX[i]][robotY[i]]);
                for (int j = -1; j < 2; j++) {
                    int checkDir = robotDir + j;
                    if (checkDir < 0)
                        checkDir += 4;
                    if (checkDir >= 4)
                        checkDir -= 4;

                    int nx = robotX[i] + dir[checkDir][0];
                    int ny = robotY[i] + dir[checkDir][1];

                    if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1)
                        continue;
                    if (map[nx][ny] == -1)
                        continue;
                    dustNum += Math.min(20,map[nx][ny]);
                }
                if (dustNum > maxDust) {
                    maxDust = dustNum;
                    maxDir = robotDir;
                }
            }

            map[robotX[i]][robotY[i]] = Math.max(0, map[robotX[i]][robotY[i]] - 20);
            for (int j = -1; j < 2; j++) {
                int cleanDir = maxDir + j;
                if (cleanDir < 0)
                    cleanDir += 4;
                if (cleanDir >= 4)
                    cleanDir -= 4;

                int nx = robotX[i] + dir[cleanDir][0];
                int ny = robotY[i] + dir[cleanDir][1];

                if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1)
                    continue;
                if (map[nx][ny] == -1)
                    continue;
                map[nx][ny] = Math.max(0, map[nx][ny] - 20);
            }
        }
    }

    static void dustGrow() { // 모든 먼지는 +5
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] > 0) // 벽이나 깨끗칸이 아니라면
                    map[i][j] += 5;
            }
        }
    }

    static void dustSpread() { // 모든 깨끗이는 먼지체크
        int[][] updateMap = new int[N+1][N+1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 0) { // 깨끗이라면
                    int nearDust = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dir[k][0];
                        int ny = j + dir[k][1];
                        if (nx < 1 || ny < 1 || nx >= N + 1 || ny >= N + 1)
                            continue;
                        if (map[nx][ny] == -1)
                            continue;
                        nearDust += map[nx][ny];
                    }
                    updateMap[i][j] = nearDust / 10;
                }
            }
        }

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                map[i][j] += updateMap[i][j];
            }
        }
    }

    static int dustSum() { // 전체 맵의 dust값 총합 리턴
        int sum = 0;

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] != -1) // -1이 아니라면
                    sum += map[i][j];
            }
        }
        return sum;
    }
}

// 시뮬레이션
// 1,1 ~n,n
// 청소기 k개  테스트 l번

///////////////////////
// 1. 청소기 이동 = 맨해튼거리기준 최단거리 오염격자로
//    여러개라면, 행번호가 작은 격자. 행번호도 같다면, 열번호가 작은 격자
// 2. 청소 체크 = 청소할수있는 먼지량이 가장 큰 방향부터 시작.
// 3. 먼지 축적 = 먼지가 있으면, 5 추가
// 4. 깨끗한 지역 = 오염 시작. 주변 4방향 더해서, 10으로 나눈 값
///////////////////////

// AI 사용처 - 