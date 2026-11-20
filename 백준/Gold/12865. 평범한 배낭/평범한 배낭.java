import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[k+1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j = k; j >= w; j--) {
				dp[j] = Math.max(dp[j], dp[j-w]+v);
			}
		}
		
		System.out.println(dp[k]);
	}
}
