
import java.util.Arrays;

class Solution {
    boolean[][] map;
    int[] network;

    int N;
    public int solution(int n, int[][] computers) {
        map = new boolean[n][n];
        N = n;

        network = new int[n];
        Arrays.fill(network, 0); //

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = computers[i][j] == 1;
            }
        }

        int groupCnt = 0;
        for (int i = 0; i < n; i++) {
            if (network[i] == 0) { // 탐색 시작
                groupCnt++;

                dfs(i, groupCnt);
            }
        }

        return groupCnt;
    }

    private void dfs(int index, int groupNum) {
        if(network[index] == groupNum) {
            return;
        }

        network[index] = groupNum;

        for (int i = 0; i < N; i++) {
            if(i != index && map[index][i]) {
                dfs(i,groupNum);
            }
        }
    }
}