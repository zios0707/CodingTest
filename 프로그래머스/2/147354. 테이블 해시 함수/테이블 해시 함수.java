import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {

        int fCol = col - 1;
        Arrays.sort(data, (d1, d2) -> {
            if (d1[fCol] == d2[fCol]) return d2[0] - d1[0];
            else return d1[fCol] - d2[fCol];
        });

        int cnt = 0;

        for (int i = row_begin - 1; i < row_end; i++) {
            int fI = i + 1;
            cnt ^= Arrays.stream(data[i])
                    .map(j -> j % fI)
                    .sum();
        }

        return cnt;
    }
}