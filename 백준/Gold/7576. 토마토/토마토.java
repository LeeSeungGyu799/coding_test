import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, m, ripeCnt, day;
	static int[][] tomato, ripe;
	static boolean[][] visited;
	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		ripeCnt = 0;
		tomato = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
					ripeCnt++;
			}
		}

		// 1은 익은거 0은 안익은거 -1은 빈거

		ripe = new int[ripeCnt][2];
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 1) {
					ripe[cnt][0] = i;
					ripe[cnt][1] = j;
					cnt++;
				}
			}
		}

		// visited, multibfs, 가장 긴ㄱ ㅓ체크
		visited = new boolean[n][m];
		day = 0;
		bfs();

		if (isDone()) {
			System.out.println(day);
		} else {
			System.out.println(-1);
		}
	}

	public static void bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < ripeCnt; i++) {
			q.offer(new int[] { ripe[i][0], ripe[i][1] });
			visited[ripe[i][0]][ripe[i][1]] = true;
			
		}

		while (!q.isEmpty()) {
			int today = q.size();

			for (int i = 0; i < today; i++) {
				int[] now = q.poll();
				int nowX = now[0];
				int nowY = now[1];

				for (int d = 0; d < 4; d++) {
					int nx = nowX + dir[d][0];
					int ny = nowY + dir[d][1];

					if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
						continue;
					}
					if (visited[nx][ny])
						continue;
					if (tomato[nx][ny] != 0)
						continue;

					q.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
					tomato[nx][ny] = 1;
				}
			}
			if(!q.isEmpty())
				day++;
			//System.out.println("now    :" + q.size());
		}
	}

	public static boolean isDone() {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(tomato[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}