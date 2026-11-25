import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, eatCnt, size;
	static int[][] map;
	static int[] shark;
	static boolean[][] visited;
	static int[][] dir = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		map = new int[n][n];
		shark = new int[2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark[0] = i;
					shark[1] = j;
					map[i][j] = 0;
				}
			}
		}

		int time = 0;
		eatCnt = 0;
		size = 2;
		while (true) {
			int nextFish = bfs(shark[0], shark[1]);
			if (nextFish == -1) {
				break;
			}
			time += nextFish;
			eatCnt++;

			if (eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}

		System.out.println(time);
	}

	public static int bfs(int x, int y) {
		visited = new boolean[n][n];

		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y, 0 });
		visited[x][y] = true;

		int minDist = Integer.MAX_VALUE;
		int fishX = -1;
		int fishY = -1;

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			int dist = now[2];

			if (dist > minDist) {
				break;
			}

			if (map[nowX][nowY] > 0 && map[nowX][nowY] < size) {

				if (dist < minDist || (dist == minDist && nowX < fishX) || (dist == minDist && nowX == fishX && nowY < fishY)) {
					minDist = dist;
					fishX = nowX;
					fishY = nowY;
				}
				continue;
			}

			for (int[] d : dir) {
				int nx = nowX + d[0];
				int ny = nowY + d[1];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (visited[nx][ny])
					continue;

				if (map[nx][ny] > size)
					continue;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny, dist + 1 });
			}
		}

		if (fishX == -1) {
			return -1;
		}

		map[fishX][fishY] = 0;
		shark[0] = fishX;
		shark[1] = fishY;

		return minDist;
	}
}