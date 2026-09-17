import java.io.*;

public class Solution {
    static int[] parent;
    static int[] size;

    static void init(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        // 경로 압축
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB) return false;

        // 작은 집합을 큰 집합에 연결한다.
        if (size[rootA] < size[rootB]) {
            int temp = rootA;
            rootA = rootB;
            rootB = temp;
        }

        parent[rootB] = rootA;
        size[rootA] += size[rootB];

        return true;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder answer = new StringBuilder();

        int T = fs.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            init(n);

            // 처음에는 각 사람이 독립된 무리이다.
            int groups = n;

            for (int i = 0; i < m; i++) {
                int a = fs.nextInt();
                int b = fs.nextInt();

                // 서로 다른 무리가 합쳐졌을 때만 감소시킨다.
                if (union(a, b)) {
                    groups--;
                }
            }

            answer.append('#').append(tc).append(' ')
                  .append(groups).append('\n');
        }

        System.out.print(answer);
    }

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int pointer = 0;
        private int length = 0;

        private int read() throws IOException {
            if (pointer >= length) {
                length = in.read(buffer);
                pointer = 0;

                if (length <= 0) return -1;
            }

            return buffer[pointer++] & 0xff;
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
                if (c == -1) throw new EOFException();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int value = 0;

            while (c >= '0' && c <= '9') {
                value = value * 10 + c - '0';
                c = read();
            }

            return value * sign;
        }
    }
}