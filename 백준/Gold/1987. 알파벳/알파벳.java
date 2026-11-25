import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m, answer;
	static char[][] map;
	static boolean[][] visited;
	static boolean[] alphaUsed;
	static int[][] dir = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 } };

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m];
		alphaUsed = new boolean[26]; // A ~ Z
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j);
			}
		} // 입력

		alphaUsed[map[0][0] - 'A'] = true;
		answer = 0;
		dfs(0, 0, 1); // x y time

		System.out.println(answer);
	}

	public static void dfs(int x, int y, int len) {
		answer = Math.max(len, answer);

		for (int i = 0; i < 4; i++) {
			int nx = x + dir[i][0];
			int ny = y + dir[i][1];

			if (nx < 0 || ny < 0 || nx >= n || ny >= m)
				continue;

			int nextAlpha = map[nx][ny] - 'A';
			if (alphaUsed[nextAlpha])
				continue;

			alphaUsed[nextAlpha] = true;
			dfs(nx, ny, len + 1);
			alphaUsed[nextAlpha] = false;
		}
	}
}
