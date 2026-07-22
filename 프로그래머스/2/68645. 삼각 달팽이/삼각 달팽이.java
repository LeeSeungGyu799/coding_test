class Solution {
    public int[] solution(int n) {
        int[] answer = {};
        
 		int[][] arr = new int[n][n];
	    int[][] dir = {{1,0},{0,1},{-1,0}}; // d r u
	    
	    int cnt = n * (n+1) / 2; // 시행횟수
	    int goal = n;
	    int dir_cnt = 0;
	    int start_x = 0;
	    int start_y = 0;
	    int i = 0;
	    
	    while(i < cnt) {
	        int x = start_x;
	        int y = start_y;
	        
	        for(int k = 0; k < goal; k++) {
	            //아래로
	            arr[x][y] = i+1;
	            i++;
	            x += dir[dir_cnt][0];
	            y += dir[dir_cnt][1];
	        }
	        x -= dir[dir_cnt][0];
            y -= dir[dir_cnt][1];
	        dir_cnt++;
	        x += dir[dir_cnt][0];
            y += dir[dir_cnt][1];
	        
	        
	        for(int l = 0; l < goal-1; l++){
	            // 우로
	            arr[x][y] = i+1;
	            i++;
	            x += dir[dir_cnt][0];
	            y += dir[dir_cnt][1];
	        }
	        x -= dir[dir_cnt][0];
            y -= dir[dir_cnt][1];
	        dir_cnt++;
	        x += dir[dir_cnt][0];
            y += dir[dir_cnt][1];
	        
	        for(int m = 0; m < goal-2; m++){
	            // 위로
	            arr[x][y] = i+1;
	            i++;
	            x += dir[dir_cnt][0];
	            y += dir[dir_cnt][1];
	        } 
	        dir_cnt = 0;
	        // 다시, goal -2, 시작위치는 (2,1)
	        start_x += 2;
	        start_y += 1;
	        goal -= 3;
	    }
        
        answer = new int[cnt];
        int answer_cnt = 0;
                
        for(int k = 0; k < n; k++) {
            for(int j = 0; j < n; j++) {
                if(arr[k][j] != 0) {
                    answer[answer_cnt] = arr[k][j];
                    answer_cnt++;
                }
            }
        }
        
        
        
        
        
        return answer;
    }
}