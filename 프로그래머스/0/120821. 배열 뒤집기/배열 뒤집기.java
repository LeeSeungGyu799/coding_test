import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        
        for (int i = 0; i < num_list.length / 2; i ++){
            int tep = num_list[i];
            num_list[i] = num_list[num_list.length - i - 1];
            num_list[num_list.length - i - 1] = tep;
        }

        return num_list;
        
    }
}