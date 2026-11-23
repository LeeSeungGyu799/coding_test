import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader bf;
	static StringTokenizer st;
	static StringBuilder sb;
	static int l, c;
	static String[] words;
	static String[] vowel = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) throws Exception {
		sb = new StringBuilder();
		bf = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(bf.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		words = new String[c];
		for (int i = 0; i < c; i++) {
			words[i] = st.nextToken();
		}

		Arrays.sort(words);

		dfs(0, new ArrayList<String>());
	}

	public static void dfs(int start, ArrayList<String> password) {
		if(password.size() == l) {
			if(isPossible(password)) {
				for(int i = 0; i < l; i++) {
					System.out.print(password.get(i));
				}
				System.out.println();
			}
		}
		
		for (int i = start; i < c; i++) {
	        password.add(words[i]);
	        dfs(i + 1, password);
	        password.remove(password.size() - 1);
	    }
	}

	public static boolean isPossible(ArrayList<String> result) {
		int cnt = 0;
		for (String s : result) {
			for (int i = 0; i < 5; i++) {
				if (s.equals(vowel[i])) {
					cnt++;
	                break;
	            }
	        }
	    }

	    return cnt >= 1 && result.size() - cnt >= 2; // 자2 모1 이상

	}
}