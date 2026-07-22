import java.util.*;

class Solution {
    public int solution(int[] nums)  {
        int choice = nums.length/2;
        
        // hashmap으로 총 몇 종류인지 확인
        // choice가 종류보다 적으면 -> choice
        // 종류가 choice보다 적으면 -> 종류 
        
        HashMap<Integer, Integer> pokemon = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            pokemon.put(nums[i], pokemon.getOrDefault(nums[i],0) + 1);
        }
        
        int answer = Math.min(pokemon.size(), choice);
        
        return answer;
    }
}