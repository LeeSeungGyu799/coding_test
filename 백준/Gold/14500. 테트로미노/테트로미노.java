import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m, max;
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, 0 } };
	static int TOP = 1000;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][m];
		max = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	public static void dfs(int x, int y, int cnt, int sum) {
		if (cnt >= 4) {
			if (max < sum) {
				max = sum;
			}
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;
			if (visited[nx][ny])
				continue;

			visited[nx][ny] = true;
			if (cnt == 2)
				dfs(x, y, cnt + 1, sum + map[nx][ny]);
			dfs(nx, ny, cnt + 1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
}
