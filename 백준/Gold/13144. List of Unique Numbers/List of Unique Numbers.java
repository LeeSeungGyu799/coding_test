// https://www.acmicpc.net/problem/13144
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        int n = Integer.parseInt(bf.readLine());
        int[] num = new int[n];

        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n ; i++) {
          num[i] = Integer.parseInt(st.nextToken());
        } // 입력
      
        boolean[] visited = new boolean[100001];

        int l = 0;
        long cnt = 0;

        for (int r = 0; r < n; r++) {
            while (visited[num[r]]) {
                visited[num[l]] = false;
                l++;
            }

            visited[num[r]] = true;

            cnt += r - l + 1;
        }

        System.out.print(cnt);
    }
}