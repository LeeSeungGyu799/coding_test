import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        // e를 기준으로 정렬, e가 같다면 s가 낮은기준으로 정렬
        // 0=s 1=e
        
        Arrays.sort(targets, (a,b) -> {
            if(a[1] == b[1]) {
                return Integer.compare(a[0],b[0]);
            } else
                return Integer.compare(a[1],b[1]);
        });
        
        int prev = -1;
        for(int i = 0; i < targets.length; i++) {
            if(prev <= targets[i][0]) {
                answer++;
                prev = targets[i][1];
            }
        }
        
        return answer;
    }
}


// greedy같은느낌... 회의실같은느낌?
// e를 기준으로 줄세우기 -> 가장 짧은 타겟 끝을 쏜다 (0.0000001만큼 작게 쏘면 맞음)
// 그다음 s가 e보다 같거나 큰(0.0000001만큼 작게 쐈으니까) target 기준으로 쏜다?