import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
class Solution {
    ArrayList<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        hanoi(n, 1, 2, 3);

        return list.stream().collect(Collectors.toUnmodifiableList()).toArray(new int[0][]);
    }

    private void hanoi(int deeper, int start, int middle, int end) {

        if(deeper == 1) {
            list.add(new int[]{start, end});
            return;
        }

        hanoi(deeper - 1, start, end, middle);
        list.add(new int[]{start, end});
        hanoi(deeper - 1, middle, start, end);
        
    }
}