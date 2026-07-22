class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr = new int[rows][columns];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}}; //  우 하 좌 상
        int[] moveCnt = new int[2]; //mc[0] x축 mc1 y축         
        int cnt = 1;
        int listCnt = 0;
        
        int rotateNum = queries.length;
        int[] answer = new int[rotateNum];
                
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                arr[i][j] = cnt;
                cnt++;
            }
        }        
        
        for(int i = 0; i < rotateNum; i++) { //쿼리수만큼 돌릴게
            int startx = queries[i][0] - 1;
            int starty = queries[i][1] - 1;
            int temp = arr[startx][starty];
            
            moveCnt[0] = queries[i][3] - queries[i][1]; // x2 - x1 
            moveCnt[1] = queries[i][2] - queries[i][0]; // y2 - y1
            
            
            int[] numList = new int[(moveCnt[0] + moveCnt[1])*2]; // 여따 저장
            
            int parity = 0; //movecnt parity
            
            for(int j = 0; j < 4; j++) { //상하좌우한번씩
                int dirx = dir[j][0];
                int diry = dir[j][1];              
                
                for(int k = 0; k < moveCnt[parity]; k++) {
                    // numList에 넣기
                    numList[listCnt] = temp;
                    listCnt++;
                    // temp에 startx+dirx starty+diry
                    int nextTemp = arr[startx + dirx][starty + diry];
                    
                    // startx starty를 startx+dirx starty+diry로 이동
                    arr[startx + dirx][starty + diry] = temp;
                    temp = nextTemp;
                    startx += dirx;
                    starty += diry;
                    }
                
                // parity = 0이면 1로 1이면 0으로
                if(parity == 0) {
                    parity = 1;
                }else{ 
                    parity = 0;
                }   
            }   
            listCnt = 0;
            // listNum 미니멈 찾아서 answer에 넣기
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < numList.length; j++) {
                min = Math.min(min, numList[j]);
            }
            answer[i] = min;
        }

        return answer;
    }
}
