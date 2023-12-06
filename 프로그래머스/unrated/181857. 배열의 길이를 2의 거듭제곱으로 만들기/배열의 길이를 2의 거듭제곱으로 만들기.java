import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] arr) {
        int val = 1;
        for (int i = 1; i < arr.length * 2; i *= 2) val = i;
        ArrayList<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        for (int i = 0; i < val - arr.length; i++) list.add(0);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}