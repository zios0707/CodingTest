import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (i1, i2) -> i1[0] - i2[0]);

        int cnt = 1;

        int minEnd = 30001;

        for (int[] i : routes) {
            if (i[0] > minEnd) {
                cnt++;
                minEnd = i[1];
            }
            minEnd = Math.min(minEnd, i[1]);
        }

        return cnt;
    }
}