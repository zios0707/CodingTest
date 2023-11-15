import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        if(num_list.length >= 11) {
            return Arrays.stream(num_list).sum();
        }else {
            int result = 1;
            for (int i : num_list) result *= i;
            return result;
        }
    }
}