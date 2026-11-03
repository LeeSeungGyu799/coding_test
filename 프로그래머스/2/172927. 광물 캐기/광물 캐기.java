
class Solution {
    int answer;

    public int solution(int[] picks, String[] minerals) {
        answer = Integer.MAX_VALUE;
        dfs(0, 0, picks, minerals);
        return answer;
    }

    void dfs(int depth, int sum, int[] picks, String[] minerals) {
        if (depth >= minerals.length ||picks[0] + picks[1] + picks[2] == 0) {
            answer = Math.min(answer, sum);
            return;
        }

        if (sum >= answer) return;

        for (int i = 0; i < 3; i++) {
            if (picks[i] == 0) continue;

            int tired = 0;
            for (int j = depth; j < depth + 5 && j < minerals.length; j++) {
                if (i == 0) { // 다이아
                    tired += 1;
                } else if (i == 1) { // 철
                    if (minerals[j].equals("diamond")) {
                        tired += 5;
                    } else {
                        tired += 1;
                    }
                } else { // 돌 
                    if (minerals[j].equals("diamond")) {
                        tired += 25;
                    } else if (minerals[j].equals("iron")) {
                        tired += 5;
                    } else {
                        tired += 1;
                    }
                }
            }
            picks[i]--;

            dfs(depth + 5, sum + tired, picks, minerals);

            picks[i]++;
        }
    }
}

// dfs?
// 앞에 5개를 묶어놓고 -> picks로 dfs돌리기
// group