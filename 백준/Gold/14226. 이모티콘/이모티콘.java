import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int s, limit;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		s = Integer.parseInt(bf.readLine());

		limit = 2001;
		visited = new boolean[limit][limit];
		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 1, 0, 0 }); // 화면, 클립보드, 시간
		visited[1][0] = true;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int screen = now[0];
			int clip = now[1];
			int time = now[2];
			
			if(s == screen) {
				return time;
			}
			
			if(!visited[screen][screen]) {
				visited[screen][screen] = true;
				q.offer(new int[] {screen, screen, time+1});
			}
			
			if(clip > 0 && screen + clip < limit && !visited[screen + clip][clip]) {
				visited[screen + clip][clip] = true;
				q.offer(new int[] {screen + clip, clip, time + 1});
			}
			
			if(screen > 0 && !visited[screen-1][clip]) {
				visited[screen-1][clip] = true;
				q.offer(new int[] {screen - 1, clip, time + 1});
			}
		}
		return -1;
	}
}