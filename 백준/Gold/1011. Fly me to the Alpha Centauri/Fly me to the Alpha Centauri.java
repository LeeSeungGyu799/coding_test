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
		int T = Integer.parseInt(bf.readLine());
		
		for(int test_case = 0; test_case < T; test_case ++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			long length = (long) end - start;
			long a = (long) Math.sqrt(length);
			
			long answer = 0;
			if(length == a * a) {
				answer = 2 * a - 1;
			} else if(length <= a * (a+1)) {
				answer  = 2 * a;
			} else {
				answer = 2 * a + 1;
			}
			
			System.out.println(answer);
		}
	}
}
// 최대 : 1 1 1 1
// 치ㅗ소 : 1 2 3 4 3 2 1 -> (a+1)^2 (홀수일떄)
// 짝수일때 -> a(a+1)