import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) map.put(i, map.getOrDefault(i, 0) + 1);

        List<Integer> descList = map.values().stream().sorted((i1, i2) -> i2 - i1).collect(Collectors.toUnmodifiableList());


        int i, temp = 0;
        for (i = 0; temp < k; i++) temp += descList.get(i);

        return i;
    }
}