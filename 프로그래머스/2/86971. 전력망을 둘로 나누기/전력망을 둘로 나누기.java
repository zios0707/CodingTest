import java.util.Arrays;
class Solution {
    int N;
    int[][] map;

    public int solution(int n, int[][] wires) {
        map = new int[n][n];
        N = n;
        int result = n;
        for (int[] i : map) Arrays.fill(i, 0);
        for (int[] i : wires) {
            map[i[0] - 1][i[1] - 1] = 1;
            map[i[1] - 1][i[0] - 1] = 1;
        }

        for (int[] i : wires) {
            map[i[0] - 1][i[1] - 1] = 0;
            map[i[1] - 1][i[0] - 1] = 0; 
            int a = dfs(i[0] - 1, i[0] - 1), b = dfs(i[1] - 1, i[1] - 1);
            int val = (a - b >= 0) ? a - b : b - a;
            result = Math.min(result, val); 
            map[i[0] - 1][i[1] - 1] = 1;
            map[i[1] - 1][i[0] - 1] = 1;
        };

        return result;
    }

    private int dfs(int n, int visited) {
        int result = 1; 

        for (int i = 0; i < N; i++)
            if (i != visited && map[n][i] == 1)
                result += dfs(i, n); 

        return result;
    }
}