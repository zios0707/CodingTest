import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] arr) {
        List<Integer> array = Arrays.stream(arr).boxed().collect(Collectors.toUnmodifiableList());
        int max = Arrays.stream(arr).max().getAsInt();
        int val = max;

        while (!canDivide(array, val)) val += max;

        return val;
    }

    private boolean canDivide(List<Integer> arr, int value) {
        return arr.stream().allMatch(i -> value % i == 0);
    }
}