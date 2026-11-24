import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, maxLen;
	static int[] sum;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
		}
		maxLen = Integer.parseInt(bf.readLine()); // 입력 끝

		int[][] dp = new int[4][n + 1];
		for (int i = 1; i <= 3; i++) {
			for (int j = i * maxLen; j <= n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - maxLen] + sum[j] - sum[j - maxLen]);
			}
		}
		int answer = dp[3][n];
		System.out.println(answer);
	}
}
