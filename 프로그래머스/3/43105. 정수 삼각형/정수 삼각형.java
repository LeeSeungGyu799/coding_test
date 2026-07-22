class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int height = triangle.length;
        
        int[][] dp = new int[height][height];
        
        //dp 초기화
        for(int i = 0; i < height; i++) {
            dp[height-1][i] = triangle[height-1][i];
        }
        
        //dp
        for(int i = height-2; i >= 0; i--) {
            for(int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i+1][j], dp[i+1][j+1]);
            }
        }
        answer = dp[0][0];
        
        return answer;
    }
}
//System.out.println(height);