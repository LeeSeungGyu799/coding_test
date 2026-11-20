import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		
		
		int n = Integer.parseInt(bf.readLine());
		int[][] meeting = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			meeting[i][0] = Integer.parseInt(st.nextToken());
			meeting[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meeting, (a,b)->{
			if(a[1] == b[1]) 
				return Integer.compare(a[0], b[0]);
			else 
				return Integer.compare(a[1], b[1]);
		});
		
		int cnt = 0;
		int end = -1;
		for(int i = 0; i < n; i++) {
			if(meeting[i][0] >= end) {
				end = meeting[i][1];
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
