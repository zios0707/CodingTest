import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int val = 0;
        for (int i = 1; i <= 30; i++) {
            int finalI = i;
            String[] arr = Arrays.stream(strArr).filter(string -> string.length() == finalI).toArray(String[]::new);
            val = Integer.max(val, arr.length);
        }
        return val;
    }
}