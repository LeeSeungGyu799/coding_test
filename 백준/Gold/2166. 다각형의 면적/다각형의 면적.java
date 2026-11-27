// https://www.acmicpc.net/problem/2166
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int n;
  static long[] x, y;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        n = Integer.parseInt(bf.readLine());
        x = new long[n];
        y = new long[n];
        for(int i = 0; i <n; i++) {
          st = new StringTokenizer(bf.readLine());
          x[i] = Long.parseLong(st.nextToken());
          y[i] = Long.parseLong(st.nextToken());
        }

        double answer = shoelace();

        System.out.printf("%.1f",answer);
    }
    
    public static double shoelace() {
      long partA = 0;
      long partB = 0;

      for(int i = 0; i < n; i++) {
        if(i == n - 1) {
          partA += x[i] * y[0];
          partB += y[i] * x[0];
        } else {
          partA += x[i] * y[i+1];
          partB += y[i] * x[i+1];
        }
      }

      double result = Math.abs(partA - partB) / 2.0; 

      return result;
    }
}
