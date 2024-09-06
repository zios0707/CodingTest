import java.util.*;

class Solution {
    int[][] map;
    boolean[] ways;
    int n;

    public int solution(int N, int[][] road, int K) {
        n = N;
        map = new int[N][N];
        ways = new boolean[N];
        Arrays.fill(ways, true);

        for (int[] row : map) Arrays.fill(row, Integer.MAX_VALUE / 2);

        for (int[] row : road) {
            setMap(row[0] - 1, row[1] - 1, row[2]);
        }

        for (int i = 0; i < N; i++) map[i][i] = 0;

        dijkstra();

        return (int) Arrays.stream(map[0]).filter(i -> i <= K).count();
    }

    private void dijkstra() {
        for (int i = 0; i < n - 1; i++) {
            int idx = getSmallestIdx();
            ways[idx] = false;

            for (int j = 0; j < n; j++) if (ways[j] && map[0][idx] + map[idx][j] < map[0][j]) {
                map[0][j] = map[0][idx] + map[idx][j];
            }
        }
    }

    private int getSmallestIdx() {
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) if (ways[i] && map[0][i] < min) {
            min = map[0][i];
            idx = i;
        }

        return idx;
    }

    private void setMap(int n, int m, int value) {
        map[n][m] = Math.min(map[n][m], value);
        map[m][n] = Math.min(map[m][n], value);
    }
}