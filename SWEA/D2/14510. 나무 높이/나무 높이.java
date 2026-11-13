import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;

		int T = Integer.parseInt(bf.readLine());

		for (int testCase = 1; testCase <= T; testCase++) {
			int n = Integer.parseInt(bf.readLine());

			st = new StringTokenizer(bf.readLine());
			sb = new StringBuilder();
			int[] tree = new int[n];
			int top = 0;

			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if (tree[i] > top) {
					top = tree[i];
				}
			}

			int two = 0;
			int one = 0;

			for (int i = 0; i < n; i++) {
				tree[i] = top - tree[i];
				two += tree[i] / 2;
				one += tree[i] % 2;
			}

			int day = 0;
			
			while (true) {
				if (two * one != 0) {
					two--;
					one--;
					day += 2;
					continue;
				}
				
				if(two >= 2) {
					two--;
					one+=2;
					continue;
				}
				
				break;
			}
			
			if(two != 0) {
				day+=2;
			} else if(two == 0 && one == 0) {
	
			} else {
				day += (one-1) * 2;
				day++;
			}
			
			sb.append("#").append(testCase).append(" ").append(day).append("\n");
			System.out.print(sb);
		}
	}
}
