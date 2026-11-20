import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n;
	static int[] count;
	static char[][][] map;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { 0, -1 }, { -1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());
		map = new char[n][n][2];
		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < n; j++) {
				char target = s.charAt(j);
				map[i][j][0] = target;
				map[i][j][1] = target;
				if (map[i][j][1] == 'G')
					map[i][j][1] = 'R';
			}
		}

		count = new int[2];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				bfs(i, j, 0);
			}
		}

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				bfs(i, j, 1);
			}
		}

		System.out.println(count[0] + " " + count[1]);
	}

	public static void bfs(int x, int y, int type) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });
		visited[x][y] = true;
		char target = map[x][y][type];

		while (!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];

			for (int i = 0; i < 4; i++) {
				int nx = nowX + dir[i][0];
				int ny = nowY + dir[i][1];
				
				if(nx < 0 || ny < 0 || nx >= n|| ny >= n) 
					continue;
				if(visited[nx][ny])
					continue;
				if(target != map[nx][ny][type])
					continue;
				
				q.offer(new int[] {nx,ny});
				visited[nx][ny] =true;
			}
		}
		count[type]++;
	}
}