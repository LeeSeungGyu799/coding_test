import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m, k, w;
	static int[][] map;
	static boolean[][][] wall;
	static int[][] dir = { { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } }; // dir -1 << 해야함

	static ArrayList<int[]> heater;
	static ArrayList<int[]> target;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		heater = new ArrayList<>(); // x y dir
		target = new ArrayList<>(); // x y

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 5) {
					target.add(new int[] { i, j });
				}
				if (map[i][j] >= 1 && map[i][j] <= 4) {
					heater.add(new int[] { i, j, map[i][j] - 1 });
				}
				map[i][j] = 0;
			}
		}

		w = Integer.parseInt(bf.readLine());

		wall = new boolean[n][m][4]; // 우 좌 상 하
		for (int i = 0; i < w; i++) {
			st = new StringTokenizer(bf.readLine());
			int wallX = Integer.parseInt(st.nextToken()) - 1;
			int wallY = Integer.parseInt(st.nextToken()) - 1;
			int wallDir = Integer.parseInt(st.nextToken());

			if (wallDir == 0) {
				wall[wallX][wallY][2] = true;
				wall[wallX - 1][wallY][3] = true;
			} else {
				wall[wallX][wallY][0] = true;
				wall[wallX][wallY + 1][1] = true;
			}
		} // 입력 끝

		int chocolate = 0;
		while (chocolate <= 100) {
			doHeat();
			tempAdjust();
			cool();
			chocolate++;
			if (testFinished())
				break;
			else
				continue;
		}

		System.out.println(chocolate);
	}

	public static void doHeat() { // 모든 열풍기가 불을 쏜다
		for (int[] heaterInfo : heater) {
			int heaterDir = heaterInfo[2];
			int x = heaterInfo[0] + dir[heaterDir][0];
			int y = heaterInfo[1] + dir[heaterDir][1];

			if (x < 0 || y < 0 || x >= n || y >= m)
				continue;

			boolean[][] visited = new boolean[n][m];
			ArrayDeque<int[]> q = new ArrayDeque<>();
			q.offer(new int[] { x, y, 5 });
			map[x][y] += 5;
			visited[x][y] = true;

			int[] spreadDirs;

			if (heaterDir == 0 || heaterDir == 1)
				spreadDirs = new int[] { 2, 3 };
			else
				spreadDirs = new int[] { 0, 1 };

			while (!q.isEmpty()) {
				int[] now = q.poll();

				int curX = now[0];
				int curY = now[1];
				int heat = now[2];

				if (heat == 1)
					continue;

				// 직진
				int strX = curX + dir[heaterDir][0];
				int strY = curY + dir[heaterDir][1];

				if (strX >= 0 && strY >= 0 && strX < n && strY < m) {
					if (!visited[strX][strY] && !wall[curX][curY][heaterDir]) {
						visited[strX][strY] = true;
						map[strX][strY] += heat - 1;
						q.offer(new int[] { strX, strY, heat - 1 });
					}
				}

				// 사이드
				for (int spreadDir : spreadDirs) {
					int sideX = curX + dir[spreadDir][0];
					int sideY = curY + dir[spreadDir][1];

					if (sideX >= 0 && sideY >= 0 && sideX < n && sideY < m) {
						if (!wall[curX][curY][spreadDir]) {
							int nx = sideX + dir[heaterDir][0];
							int ny = sideY + dir[heaterDir][1];
							if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
								if (!visited[nx][ny] && !wall[sideX][sideY][heaterDir]) {
									visited[nx][ny] = true;
									map[nx][ny] += heat - 1;
									q.offer(new int[] { nx, ny, heat - 1 });
								}
							}
						}
					}
				}
			}
		}
	}

	public static void tempAdjust() {
		int[][] temp = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 오
				if (j + 1 < m && !wall[i][j][0]) {
					int diff = Math.abs(map[i][j] - map[i][j + 1]) / 4;

					if (map[i][j] > map[i][j + 1]) {
						temp[i][j] -= diff;
						temp[i][j + 1] += diff;
					} else {
						temp[i][j] += diff;
						temp[i][j + 1] -= diff;
					}
				}

				// 아래
				if (i + 1 < n && !wall[i][j][3]) {
					int diff = Math.abs(map[i][j] - map[i + 1][j]) / 4;

					if (map[i][j] > map[i + 1][j]) {
						temp[i][j] -= diff;
						temp[i + 1][j] += diff;
					} else {
						temp[i][j] += diff;
						temp[i + 1][j] -= diff;
					}
				}
			}
		}

		// 온도 변화량 일괄 반영
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] += temp[i][j];
			}
		}
	}
	

	public static void cool() {
		for (int i = 0; i < n; i++) {
			if (map[i][0] != 0)
				map[i][0]--;
			if (map[i][m - 1] != 0)
				map[i][m - 1]--;
		}

		for (int i = 1; i < m - 1; i++) {
			if (map[0][i] != 0)
				map[0][i]--;
			if (map[n - 1][i] != 0)
				map[n - 1][i]--;
		}
	}
	

	public static boolean testFinished() {
		for (int i = 0; i < target.size(); i++) {
			int x = target.get(i)[0];
			int y = target.get(i)[1];
			if (map[x][y] < k)
				return false;
		}
		return true;
	}
}