import java.io.*;
import java.util.*;

public class Solution{

	static final long MOD = 1234567891L;
	static long[] fact = new long[1000001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		// 1. 팩토리얼 전처리
		fact[0] = 1;

		for (int i = 1; i <= 1000000; i++) {
			fact[i] = (fact[i - 1] * i) % MOD;
		}

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// 2. 분모 구하기
			long bottom = (fact[r] * fact[n - r]) % MOD;

			// 3. 분모의 모듈러 역원 구하기
			long inverse = pow(bottom, MOD - 2);

			// 4. 조합 계산
			long answer = (fact[n] * inverse) % MOD;

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.print(sb);
	}

	static long pow(long a, long b) {
		long result = 1;

		while (b > 0) {
			if (b % 2 == 1) {
				result = (result * a) % MOD;
			}

			a = (a * a) % MOD;
			b /= 2;
		}

		return result;
	}
}