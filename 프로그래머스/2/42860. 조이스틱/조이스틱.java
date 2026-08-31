import java.util.ArrayList;
class Solution {
    public int solution(String name) {
        // 영어를 숫자로 바꿔서 저장????
        int answer = 0;
        ArrayList<Integer> nameInt = new ArrayList<>();
        ArrayList<Integer> original = new ArrayList<>();
        
        for(int i = 0; i < name.length(); i++) {
            char tempChar = name.charAt(i);
            
            nameInt.add(tempChar - 'A');
            original.add(0);
        }
        
        int[] changeNum = new int[nameInt.size()];
        int moveNum = 0;
        
        for(int i = 0; i <  nameInt.size(); i++) {
            int changeCnt = nameInt.get(i) - original.get(i);
            if(changeCnt > 12) {
                changeCnt = Math.abs(changeCnt - 26);
            }
            
            changeNum[i] = changeCnt;
            answer += changeCnt;
        }
        
        // 2. 가로 이동
        int n = name.length();

        // 기본값: 그냥 처음부터 끝까지 오른쪽으로 이동
        int move = n - 1;

        for (int i = 0; i < n; i++) {

            // i 다음부터 연속된 A 구간 찾기
            int next = i + 1;

            while (next < n && changeNum[next] == 0) {
                next++;
            }

            // 오른쪽으로 i까지 갔다가 다시 왼쪽으로 돌아가는 경우
            int rightThenLeft = i * 2 + (n - next);

            // 왼쪽을 먼저 갔다가 다시 오른쪽으로 오는 경우
            int leftThenRight = i + (n - next) * 2;

            move = Math.min(
                move,
                Math.min(rightThenLeft, leftThenRight)
            );
        }

        answer += move;
        
        return answer;
    }
}

// 양쪽이 뚫려있다. 