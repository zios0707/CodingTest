import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        arr = Arrays.stream(arr).distinct().limit(k).toArray();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) list.add(i);
        while (list.size() < k) list.add(-1);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}