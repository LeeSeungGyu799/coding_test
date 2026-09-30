import java.util.*;

class Solution {
    
    static String[] words = {"aya", "ye", "woo", "ma"};
    static boolean[] visited = new boolean[4];
    static Set<String> set = new HashSet<>();
    
    public int solution(String[] babbling) {
        
        dfs("");
        
        int answer = 0;
        
        for (String word : babbling){
            if (set.contains(word)) {
                answer ++;
            }
        }
        
        return answer;
    }
    
    static void dfs(String str){
        
        if(! str.equals("")){
            set.add(str);
        }
        
        for (int i = 0; i < words.length; i++){
            
            if(!visited[i]){
                visited[i] = true;
                
                dfs(str+words[i]);
                
                visited[i] = false;
                
                
            }
        }
        
    }
}