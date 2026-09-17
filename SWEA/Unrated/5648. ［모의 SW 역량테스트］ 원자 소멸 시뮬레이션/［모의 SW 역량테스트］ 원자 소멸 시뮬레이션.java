import java.io.*;

public class Solution {
    static final int LIMIT = 4000;

    // 상(0), 하(1), 좌(2), 우(3)
    // 위로 이동하면 y가 증가한다.
    static final int[] DX = {0, 0, -1, 1};
    static final int[] DY = {1, -1, 0, 0};

    // 해당 시간에 각 좌표에 도착한 원자 수
    static final int[][] count = new int[LIMIT + 1][LIMIT + 1];

    static class Atom {
        int x;
        int y;
        int direction;
        int energy;
        boolean alive = true;

        Atom(int x, int y, int direction, int energy) {
            this.x = x;
            this.y = y;
            this.direction = direction;
            this.energy = energy;
        }
    }

    static int simulate(Atom[] atoms) {
        int size = atoms.length;
        int totalEnergy = 0;

        while (size > 1) {
            int moved = 0;

            // 1. 모든 원자를 0.5초만큼 이동시킨다.
            for (int i = 0; i < size; i++) {
                Atom atom = atoms[i];

                atom.x += DX[atom.direction];
                atom.y += DY[atom.direction];

                // 범위를 벗어난 원자는 앞으로 충돌할 수 없다.
                // 충돌이 아니므로 에너지는 더하지 않는다.
                if (atom.x < 0 || atom.x > LIMIT
                        || atom.y < 0 || atom.y > LIMIT) {
                    continue;
                }

                atoms[moved++] = atom;
                count[atom.x][atom.y]++;
            }

            // 2. 이동이 모두 끝난 뒤 충돌 여부를 판정한다.
            // 이 단계에서는 count를 초기화하면 안 된다.
            for (int i = 0; i < moved; i++) {
                Atom atom = atoms[i];

                if (count[atom.x][atom.y] >= 2) {
                    totalEnergy += atom.energy;
                    atom.alive = false;
                }
            }

            // 3. 사용한 좌표를 초기화하고 살아남은 원자만 모은다.
            int survivors = 0;

            for (int i = 0; i < moved; i++) {
                Atom atom = atoms[i];

                count[atom.x][atom.y] = 0;

                if (atom.alive) {
                    atoms[survivors++] = atom;
                }
            }

            size = survivors;
        }

        return totalEnergy;
    }

    public static void main(String[] args) throws IOException {
        FastScanner fs = new FastScanner();
        StringBuilder answer = new StringBuilder();

        int T = fs.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int n = fs.nextInt();
            Atom[] atoms = new Atom[n];

            for (int i = 0; i < n; i++) {
                // 음수를 없앤 뒤 좌표를 2배로 확대한다.
                int x = (fs.nextInt() + 1000) * 2;
                int y = (fs.nextInt() + 1000) * 2;

                int direction = fs.nextInt();
                int energy = fs.nextInt();

                atoms[i] = new Atom(x, y, direction, energy);
            }

            answer.append('#').append(tc).append(' ')
                  .append(simulate(atoms)).append('\n');
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