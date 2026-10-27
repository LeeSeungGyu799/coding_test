import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        if (s < n) { // 못만드는 경우
            return new int[]{-1};
        }

        int[] answer = new int[n];
        
        int base = s / n;
        int remainder = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = base;
            if (i >= n - remainder) {
                answer[i]++;
            }
        }       

        return answer;
    }
}

// 그리디? 결국엔 가까운걸 곱하는게 가장 크다
// 균등분배 후 -> 나머지 배분
// 시간초과?
// 뒤에서부터 넣기