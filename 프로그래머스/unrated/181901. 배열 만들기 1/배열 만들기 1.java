import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = k; i <= n; i += k)
            list.add(i);

        int[] ints = new int[list.size()]; int Iter = 0;
        for (Integer i: list) ints[Iter++] = i;

        return ints;
    }
}