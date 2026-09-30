import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = Arrays.stream(num_list)
                            .boxed()
                            .collect(Collectors.toList());
        
        Collections.reverse(list);
        
        System.out.println(list);
        
        int[] num = list.stream()
	                .mapToInt(i -> i)
	                .toArray();

        
        return num;
        
    }
}

// import java.util.Arrays;
// import java.util.Collections;
// import java.util.List;

// public class ReverseList {
//     public static void main(String[] args) {
//         Integer[] arr = {1, 2, 3, 4, 5};
        
//         
//         List<Integer> list = Arrays.asList(arr);
//         Collections.reverse(list);
        
//         // 리스트 내용이 원본 배열에 반영됨
//         System.out.println(Arrays.toString//        (arr)); // [5, 4, 3, 2, 1]
//     }
// }