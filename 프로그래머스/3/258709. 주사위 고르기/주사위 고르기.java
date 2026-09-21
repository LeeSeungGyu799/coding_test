import java.util.*;

class Solution {
    static int[][] dice;
    static int n;
    static int maxWin;
    static int maxWinBit;
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        n = dice.length;
        maxWin = Integer.MIN_VALUE;
        maxWinBit = 0;
        
        for(int maskA = 0; maskA < (1<<n); maskA++) {
            if(Integer.bitCount(maskA) != n/2) // 반반일때만
                continue;
            
            int maskB = ~maskA & ((1 << n) - 1); // b는 반대
            
            ArrayList<Integer> sumA = calcSum(maskA);
            ArrayList<Integer> sumB = calcSum(maskB);
            
            int cnt = calcWin(sumA, sumB); 
            if(cnt > maxWin) {
                maxWin = cnt;
                maxWinBit = maskA;
            }
        }
        
        int[] answer = new int[n/2];
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            if((maxWinBit & (1 << i)) != 0)  {
                answer[cnt] = i+1;
                cnt++;
            }
        }
        
        return answer;
    }
    
    public ArrayList<Integer> calcSum(int mask) { // mask일경우의 모~든 주사위의 합
        ArrayList<Integer> maskList = new ArrayList<>();
        
        for(int i = 0; i < n; i++) 
            if((mask & (1 << i)) != 0) 
                maskList.add(i);
        
        int[] face = new int[n/2]; // 주사위가 몇번째 숫자를 주는가 -> face[i]
        
        ArrayList<Integer> result = new ArrayList<>();
        while(true) {
            int sum = 0;
            for(int i = 0; i < n/2; i++) {
                int diceIdx = maskList.get(i); // 선택한 주사위 숫자
                sum+= dice[diceIdx][face[i]]; // 주사위의 i번째 
            }
            result.add(sum);
            
            int temp = 0;
            
            while(temp < n/2 && face[temp] == 5) { // 모든경우를 확인
                face[temp] = 0;
                temp++;
            }
            
            if(temp == n/2)
                break;
            face[temp]++;
        }
        return result;
    }
    
    static int calcWin(ArrayList<Integer> a, ArrayList<Integer> b) { // 메모이제이션
        Collections.sort(a);
        Collections.sort(b);
        
        int result = 0;
        int idx = 0;
        
        for(int i = 0; i < a.size(); i++) { // a 최약체부터
            int nowA = a.get(i);
            while(idx < b.size() && b.get(idx) < nowA)  // idx번째의 b가 a보다 작다면 (b가 진다면)
                idx++;
            
            result += idx;
        }
        return result;
    }
}