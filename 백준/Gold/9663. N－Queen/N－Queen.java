import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int cnt, n;
	static boolean[] occupied;
	static int[] now;
	
	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(bf.readLine());
		
		cnt = 0;
		occupied = new boolean[n];
		now = new int[n];
		dfs(0);
		
		System.out.println(cnt);
	}
	
	public static void dfs(int depth) {
		// depth번째 줄
		if(depth >= n) {
			cnt++;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			now[depth] = i;
			if(isPossible(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean isPossible(int depth) {
		for(int i = 0; i <depth; i++) {
			if(now[depth] == now[i])
				return false;
			
			if(Math.abs(i-depth) == Math.abs(now[depth]-now[i]))
				return false;
		}
		return true;
	}
}