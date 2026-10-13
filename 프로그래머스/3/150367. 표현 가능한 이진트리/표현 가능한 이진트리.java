class Solution {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = toBinary(numbers[i]);
            
            int size = 1;
            while (size < binary.length()) {
                size = size * 2 + 1;
            } // 이진트리 사이즈

            while (binary.length() < size) {
                binary = "0" + binary;
            } // 이진트리와 맞게 

            if (dfs(binary, 0, size - 1)) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        return answer;
    }

    public boolean dfs(String binary, int left, int right) {
        if (left > right) {
            return true;
        }

        // 부모가 0인데 리프가 1이면 안된다...
        int mid = (left + right) / 2;

        if (left == right) {
            return true;
        } // 리프

        int newLeft = (left + mid - 1) / 2;
        int newRight = (mid + 1 + right) / 2;

        if (binary.charAt(mid) == '0') {
            if (binary.charAt(newLeft) == '1') {
                return false;
            }

            if (binary.charAt(newRight) == '1') {
                return false;
            }
        }
        
        if (!dfs(binary, left, mid - 1)) {
            return false;
        }
        if (!dfs(binary, mid + 1, right)) {
            return false;
        }

        return true;
    }
    
    public String toBinary(long number) {
        return Long.toBinaryString(number);
    }
}
