import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        return Arrays.stream(arr).mapToObj(n -> {
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(n);
            return list.stream().mapToInt(Integer::intValue).toArray();
        }).flatMapToInt(Arrays::stream).toArray();
    }
}