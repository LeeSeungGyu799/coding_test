import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		int[] num = new int[n];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < n; i++) {
			while(!stack.isEmpty() && num[stack.peek()] < num[i]) {
				num[stack.pop()] = num[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty())
			num[stack.pop()] = -1;
		
		sb = new StringBuilder();
		for(int i = 0; i < n; i++)
			sb.append(num[i]).append(" ");
		
		System.out.println(sb);
	}
}