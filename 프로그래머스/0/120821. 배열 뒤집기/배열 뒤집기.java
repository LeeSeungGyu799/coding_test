import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] num_list) {
        
        // int[] 에 Stream 을 씌우면, intStream
        // intStream 에 boxed 를 씌우면 Stream<Integer>로 변형
        // int 형은 기본형, Integer 는 object형
        // 따라서, List 변환 시,
        // int[] 자체를 객체로 인식하여 List 는 1개 원소
        // 그러나, integer 의 경우 모든 원소를 객체로 인식
        // List 변환 시, 모든 원소를 개체로 인식
        List<Integer> list = Arrays.stream(num_list)
                            .boxed()
                            .collect(Collectors.toList());
        
        Collections.reverse(list);

        int[] num = list.stream()
	                .mapToInt(i -> i)
	                .toArray();

        return num;
        
    }
}