import java.util.ArrayDeque;
class Solution {
    static int index;
    static char[] answerList;
    
    static int[] prev, next;
    
    static ArrayDeque<Integer> deletedStack;
    
    public String solution(int n, int k, String[] cmd) {
        answerList = new char[n];
        
        for(int i = 0; i < n; i++) {
            answerList[i] = 'O';
        }
        
        index = k;
        deletedStack = new ArrayDeque<>();
        
        prev = new int[n];
        next = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = i-1; // -1은 연결안한다는 뜻.
            next[i] = i+1;
        } // 이중연결리스트
        
        next[n-1] = -1;
        
        for(int i = 0; i < cmd.length; i++) {
            char command = cmd[i].charAt(0);
            if(command == 'U') {
                int commandNum = Integer.parseInt(cmd[i].substring(2));
                goUp(commandNum);
            }
            if(command == 'D') {
                int commandNum = Integer.parseInt(cmd[i].substring(2));
                goDown(commandNum);
            }
            if(command == 'C') {
                delete();
            }
            if(command == 'Z') {
                restore();
            }
        }
        
        String answer = makeAnswer();
        return answer;
    }
    
    static void goUp(int num) {
        for(int i = 0; i < num; i++) {
            index = prev[index];
        }
    }
    
    static void goDown(int num) {
        for(int i = 0; i < num; i++) {
            index = next[index];
        }
    }
    
    static void delete() {
        // 스택에 넣기
        deletedStack.push(index);
        answerList[index] = 'X';
        
        // 삭제한거 앞뒤 연결하기
        int newPrev = prev[index];
        int newNext = next[index];
        
        if(newPrev != -1)  // 연결이 안되어있다면
            next[newPrev] = newNext;
        
        if(newNext != -1)
            prev[newNext] = newPrev;
        
        if(newNext != -1)  // 마지막이 아니면 
            index = newNext;
        else
            index = newPrev;
    }
    
    static void restore() {
        // 스택에서 뽑기
        int restored = deletedStack.pop();
        answerList[restored] = 'O';
        // 재연결
        
        int oldPrev = prev[restored];
        int oldNext = next[restored];
        
        if(oldPrev != -1)
            next[oldPrev] = restored;
        if(oldNext != -1)
            prev[oldNext] = restored;
        // 인덱스는 부동
    }
    
    static String makeAnswer() {
        return new String(answerList);
    }
}

// 이중연결리스트인듯

// U라면, x칸 위로
// D면, x칸 아래로
// C면, 삭제. 아래 행을 선택. 마지막행이면, 윗행을 선택.
// C한건 stack에 넣어놓아야 한다.
// Z면, 복구. index는 유지

// 틀림
// 진짜 모르겠어서 ai 돌림. charAt으로 숫자 받아오면 한자리수만 가능하다는 답변
// 이건 못찾았을것같어~