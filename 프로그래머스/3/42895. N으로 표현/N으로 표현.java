import java.util.HashSet;
import java.util.ArrayList;
class Solution {
    static HashSet<Integer>[] dp;
    
    public int solution(int N, int number) {
        dp = new HashSet[9];
        
        for(int i = 1; i <= 8; i++) 
            dp[i] = new HashSet<>();
        
        int connected = 0;
        
        for(int i = 1; i <= 8; i++) { // 넘어가면 -1
            connected += N * Math.pow(10,i - 1);
            dp[i].add(connected);
            
            if(i == 2) {
                dp[i].add(N + N);
                dp[i].add(N - N);
                dp[i].add(N * N);
                dp[i].add(N / N);
            } 
            
            if(i > 2) {
                // dp1 dpi-1   dp2 dpi-2 ... dpi-1 dp1 까지
                for(int j = i - 1; j >= 1; j--) {
                    // dp[j] dp[i - j] 내의 모~든값에 대한 + - * / 를 dp [i]에 넣기
                    ArrayList<Integer> aList = new ArrayList(dp[j]);
                    ArrayList<Integer> bList = new ArrayList(dp[i - j]);
                    for(int aIdx = 0; aIdx < aList.size(); aIdx++){
                        for(int bIdx = 0; bIdx < bList.size(); bIdx++) {
                            int a = aList.get(aIdx);
                            int b = bList.get(bIdx);
                            
                            dp[i].add(a+b);
                            dp[i].add(a-b);
                            dp[i].add(a*b);
                            if(b != 0) 
                                dp[i].add(a/b);
                        }
                    }    
                } 
            } 
            
            if(dp[i].contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
}

////////////////////////////
// 수식은 괄호 / 사칙연산만
// N을 제일 적게 쓰는 경우의 수.
//
////////////////////////////

// 똑같은건 넣을필요가 없었음
// arrayList -> HashSet