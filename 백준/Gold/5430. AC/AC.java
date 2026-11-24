import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int t, n;
	static String command;
	static ArrayDeque<Integer> arr;

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		t = Integer.parseInt(bf.readLine());
		for(int testCase = 0; testCase < t; testCase++) {
			sb = new StringBuilder();
			command = bf.readLine();
			n = Integer.parseInt(bf.readLine());
			
			arr = new ArrayDeque<>();
			st = new StringTokenizer(bf.readLine(), "[],");
			for(int i = 0; i < n; i++) {
				arr.offer(Integer.parseInt(st.nextToken()));
			}
			
			int deleteFirst = 1; // 1면 앞 -1면 뒤
			boolean isNull = false;
			for(int c = 0; c < command.length(); c++) {
				if(command.charAt(c) == 'R') {
					deleteFirst *= -1;
				}
				
				if(command.charAt(c) == 'D') {
					if(arr.size() == 0) {
						System.out.println("error");
						isNull = true;
						break;
					}
					
					if(deleteFirst == 1) {
						arr.pollFirst();
					} else
						arr.pollLast();
				}
			}
			
			if(isNull) {
				continue;
			}
			
			int len = arr.size();

			sb.append("[");

			for (int i = 0; i < len; i++) {
			    if (deleteFirst == 1) {
			        sb.append(arr.pollFirst());
			    } else {
			        sb.append(arr.pollLast());
			    }

			    if (i < len - 1) {
			        sb.append(",");
			    }
			}

			sb.append("]");

			System.out.println(sb);
		}
	}
}
