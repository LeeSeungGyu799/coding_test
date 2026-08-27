import java.util.ArrayList;

class Solution {
    public long solution(String expression) {
        long answer = Integer.MIN_VALUE;
        // parse, Arraylist로 나누기 / +0 -1 *2
        // 우선순위 다 체크 후 최대값 찾기 (절대값)
        
        int[][] order = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
        
        ArrayList<Long> number = new ArrayList<>();
        ArrayList<Integer> sign = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < expression.length(); i++) { // string parse
            char c = expression.charAt(i);
            
            if(c == '+' || c == '-' || c == '*') { // 기호라면
                number.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                if(c=='+') 
                    sign.add(0);
                else if (c=='-') 
                    sign.add(1);
                else 
                    sign.add(2);
            } else {
                sb.append(c);
            }
        }
        
        number.add(Long.parseLong(sb.toString()));
        
        for(int i = 0; i < 6; i++) {
            ArrayList<Long> tempNumber = new ArrayList<>(number);
            ArrayList<Integer> tempSign = new ArrayList<>(sign);
            
            for(int j = 0; j < 3; j++) {
                int nowSign = order[i][j];
                    
                    for(int k = 0; k < tempSign.size(); k++) {
                        if(tempSign.get(k) == nowSign) {
                            long left = tempNumber.get(k);
                            long right = tempNumber.get(k+1);
                            long result = calc(left, right, nowSign);
                        
                            tempNumber.set(k, result);
                            tempNumber.remove(k+1);
                            tempSign.remove(k);
                            k--; // Arraylist기 때문.
                        }
                    }
            }
            answer = Math.max(answer, Math.abs(tempNumber.get(0)));
        }
        
        return answer;
    }
    
    long calc(long left, long right, int sign) {
        if(sign == 0)
            return left + right;
        if(sign == 1) 
            return left - right;
        return left * right;
    }
}

// 걍 완탐때려도 되는거 아닌가 6번밖에 안돌리는데 