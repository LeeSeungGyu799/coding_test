class Solution {
    public int solution(int n, long l, long r) {
        long[] length = new long[n+1]; 
        long[] dp = new long[n+1]; // 1의수
        
        length[0] = 1;
        dp[0] = 1; // 1
        
        for(int i = 1; i <= n; i++) {
            length[i] = length[i-1] * 5;
            dp[i] = dp[i-1] * 4;
        }
        
        long right = count(n, r, length, dp); // 
        long left = count(n, l - 1, length, dp);

        return (int)(right - left);
    }

    public long count(int n, long position, long[] lengths, long[] dp) {

        long total = 0;

        for (int i = n; i > 0; i--) {
            if (position == 0) {
                break;
            }
            long blockLength = lengths[i-1];
            long complete = position / blockLength; // 완전히 포함하는 영역 memo
            long remainder = position % blockLength; // 떨거지

            for (int j = 0; j < complete; j++) { // 계산해놓은거
                if (j == 2) { // 00000
                    continue;
                }
                total += dp[i - 1];
            }
            
            if (complete == 2) { // 11011이므로
                break;
            }

            position = remainder;
        }
        return total;
    }
}

// 1 -> 11011 -> 11011 11011 00000 11011 11011
//5^(n-1) -> 다는 안됨
//dp?
// 1/0  4/1  16/9
// 1의 수 =- dp[i] = dp[i-1] * 4