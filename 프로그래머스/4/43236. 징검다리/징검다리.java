import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
class Solution {
//     ArrayList<Integer> rockGap;
//     public int solution(int distance, int[] rocks, int n) {
//         rockGap = new ArrayList<>();
        
//         Arrays.sort(rocks);
//         findDist(distance, rocks);
        
//         for(int i = 0; i < n; i++) {
//             int minIndex = findMinIndex();
//             deleteRock(minIndex);
//         }
        
//         int answer = rockGap.get(findMinIndex());
//         return answer;
//     }
    
//     public void findDist(int distance, int[] rocks){
//         for(int i = 0; i < rocks.length; i++) {
//             if(i == 0){
//             	rockGap.add(rocks[i]);
//                 continue;
//             }           
//             rockGap.add(rocks[i] - rocks[i-1]);
//         }
//         rockGap.add(distance - rocks[rocks.length-1]);
//     }
    
//     public int findMinIndex() {
//         return rockGap.indexOf(Collections.min(rockGap));
//     }
    
//     public void deleteRock(int minIndex) {
//         int result = 0;
//         if(minIndex == 0) {
//             result = rockGap.get(minIndex) + rockGap.get(minIndex + 1);
//             rockGap.remove(minIndex);
//             rockGap.remove(minIndex+1);
//             rockGap.add(minIndex,result);
//             return;
//         }
        
//         if(minIndex == rockGap.size() - 1) {
//             result = rockGap.get(minIndex) + rockGap.get(minIndex - 1);
//             rockGap.remove(minIndex);
//             rockGap.remove(minIndex - 1);
//             rockGap.add(result);
//             return;
//         }
        
//         if(rockGap.get(minIndex-1) > rockGap.get(minIndex + 1)) {
//             result = rockGap.get(minIndex) + rockGap.get(minIndex + 1);
//             rockGap.remove(minIndex);
//             rockGap.remove(minIndex+1);
//             rockGap.add(minIndex,result);
//         } else {
//             result = rockGap.get(minIndex) + rockGap.get(minIndex - 1);
//             rockGap.remove(minIndex);
//             rockGap.remove(minIndex - 1);
//             rockGap.add(minIndex, result);
//         }
//     }
  
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (getCnt(rocks, distance, mid) <= n) { 
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private int getCnt(int[] rocks, int distance, int mid){
        int before = 0;
        int remove = 0;
        int end = distance;
        
        for (int i = 0; i < rocks.length; i++){ // mid보다 작은 경우 돌멩이 제거
            if (rocks[i] - before < mid){
                remove ++;
                continue;
            }
            before = rocks[i];
            
        }
        if (end - before < mid){ // 마지막 돌멩이는 끝 지점과의 간격이므로 따로 카운트
            remove ++;
        }
        
        return remove;
    }
}

//일단 test
// 1. rock 사이의 거리를 찾느낟.
// 2. 최소 index를 찾는다
// 3. 최소 index 좌우 중 작은쪽이랑 붙는다
// 4. n만큼 반복한다.
// 5. 최솟값을 return