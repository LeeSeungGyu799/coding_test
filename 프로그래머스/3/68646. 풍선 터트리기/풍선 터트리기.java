import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    static int memoLeftMin;
    static int memoRightMin;
    static int[] rightMinList;
    static int rightMinIdx;
    
    public int solution(int[] a) {
        int answer = 0;
        rightMinIdx = 0;
        
        makeRightMinList(a);
        
        memoLeftMin = a[0];
        
        for(int i = 0; i < a.length; i++) {
            if(i == 0 || i == a.length - 1) {
                answer++;
                continue;
            }
            
            int leftMin = getLeftMin(a, i);
            int rightMin = rightMinList[i];
            
            if(a[i] <= leftMin || a[i] <= rightMin)
                answer++;
        }
        return answer;
    }
    
    static void makeRightMinList(int[] a) {
        rightMinList = new int[a.length];
        rightMinList[a.length-2] = a[a.length - 1]; // 마지막걸 넣어놓기
        for(int i = a.length - 3; i >= 0; i--) {
            rightMinList[i] = Math.min(rightMinList[i+1], a[i+1]);
        } 
    }
    
    static int getLeftMin(int[] a, int i) {
        if(a[i-1] < memoLeftMin)
            memoLeftMin = a[i-1];
        return memoLeftMin;
    }
}


// 번호가 작은거 터뜨리는건 1번만.
// 매앤 오른쪽 왼쪽은 반드시 남길 수 있음
// 무언가가 반드시 << 살아남을수 있는 조건 : 작은거 터뜨리는 기회를 남긴채로 2개만 남으면 됨.
// 양쪽에 1개씩 남기는것은 << 기회를 안써도 반드시 가능함. (아무거나 골라도 되니까)
// 그렇다면, 무언가가 죽는 경우의 수는 양쪽에서 뽑아온게 둘다 작은 경우이다. (작은건 한번밖에 못터뜨리니까)
// 그럼 무언가가 반드시 죽는 상황은, 이자식 왼쪽 오른쪽에 얘보다 작은것밖에 없는 경우?
// 기회를 쓰면, 한쪽에서의 두번째로 작은걸 가져올 수 있다.

// 남기는게 불가능한 경우
// 1. 끝까지 기회를 안쓰면, 좌 우의 최솟값이 온다. 이 때, 셋중에 타겟이 제일 크다면, 이 경우엔 무슨수를 써도 살릴 수 없음.
// 2. 기회를 쓴다고 하면, 한쪽의 최솟값과 한쪽의 두번째로 작은 수가 온다. 이 때, 기회가 없으므로 셋중에 제일 작지 않으면 살릴 수 없다.
// 즉, 남기는게 가능한 경우는
// 적어도 한쪽보다는 작아야함.
// 그럼, 타겟이 왼쪽 최솟값보다 작거나, 오른쪽 최솟값보다 작으면, 살릴 수 있다는거 아닌가

// 시간초과
// 메모이제이션?

// 이래도 시간초과
// 우측의 최솟값을 미리 다 구해놓을까