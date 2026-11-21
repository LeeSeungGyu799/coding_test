// https://www.acmicpc.net/problem/11729
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        

        // st = new StringTokenizer(bf.readLine());
        // int n = Integer.parseInt(st.nextToken());

        // 여기에 풀이를 작성하세요.
        int n = Integer.parseInt(bf.readLine());

        int count = (int) Math.pow(2, n) - 1;

        sb.append(count).append('\n');

        hanoi(n, 1, 3, 2);

        System.out.print(sb);
    }

    public static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append('\n');
            return;
        }

        hanoi(n - 1, from, via, to);

        sb.append(from).append(" ").append(to).append('\n');

        hanoi(n - 1, via, to, from);
    }
}
