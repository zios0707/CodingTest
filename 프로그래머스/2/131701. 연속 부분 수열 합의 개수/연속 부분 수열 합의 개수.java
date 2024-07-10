import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {

    List<Integer> list = new ArrayList<>();

    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        list = Arrays.stream(elements).boxed().collect(Collectors.toUnmodifiableList());
        for (int i = 1; i <= list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                set.add(rangeSum(j, j + i));
            }
        }

        return set.size();
    }

    private int rangeSum(int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) sum += list.get(i % list.size());
        return sum;
    }
}