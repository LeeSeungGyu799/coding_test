import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        for(int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i],0) + 1);
            if(i == participant.length-1 )
                break;
            map.put(completion[i], map.getOrDefault(completion[i],0) - 1);
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue().equals(1)){
                answer = entry.getKey();
            }
        }
        
        return answer;
    }
}