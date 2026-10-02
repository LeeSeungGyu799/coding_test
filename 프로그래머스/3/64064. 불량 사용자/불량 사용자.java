import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    ArrayList<Integer>[] possibleList;
    HashSet<Integer> result;
    boolean[] selected;
    
    public int solution(String[] user_id, String[] banned_id) {
        possibleList = new ArrayList[banned_id.length];
        for(int i = 0; i < banned_id.length; i++)
            possibleList[i] = new ArrayList<Integer>();
        
        // banned_id를 돌면서 몇번째 user_id가 가능성있는지 저장하기
        boolean isPossible;
        
        for(int i = 0; i< banned_id.length; i++) {
            String banned = banned_id[i];
            for(int j = 0; j < user_id.length; j++) {
                String user = user_id[j];
                isPossible = true;
                
                if(user.length() != banned.length()) // 길이가다르면 안됨
                    continue;
                else {
                    for(int k = 0; k < user.length(); k++) {
                        // *이 아닐때 두 char 다르면 안됨
                        if(banned.charAt(k) == '*')
                            continue;
                        if(banned.charAt(k) != user.charAt(k)) {
                            isPossible = false;
                            break;
                        }
                    }
                }
                
                if(isPossible) {
                    possibleList[i].add(j);
                }
            }
        }
        
        int answer = 0;
        result = new HashSet<>();
        selected = new boolean[user_id.length];
        findComb(0);
        
        return result.size();
    }
    
    public void findComb(int depth) {
        if(depth == possibleList.length) {
            int numInfo = getResult();
            result.add(numInfo);
            return;
        }
        
        for(int i = 0; i < possibleList[depth].size(); i++) {
            int userIdx = possibleList[depth].get(i);

            if(selected[userIdx])
                continue;

            selected[userIdx] = true;

            findComb(depth + 1);

            selected[userIdx] = false;
        }
    }
    
    public int getResult() {
        int result = 0;
        for(int i = 0; i < selected.length; i++) {
            if(selected[i]) {
                result *= 10;
                result += (i);
            }
        }
        return result;
    }
}

// 가능한걸 저장.
// 고르는건 dfs로 전부찾기