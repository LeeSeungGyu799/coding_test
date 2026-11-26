import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;

	static int n, s;
	static int[] num;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		num = new int[n+ 1];

		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int l = 0;
		int r = 0;
		int temp = 0;
		int answer = Integer.MAX_VALUE;

		while (l <= n && r <= n) {
			if (temp >= s) {
				answer = Math.min(answer, r - l);
				temp -= num[l++];
			} else {
				temp += num[r++];
			}
		}
		
		if(answer == Integer.MAX_VALUE)
			System.out.println("0");
		else 
			System.out.println(answer);
	}
}
