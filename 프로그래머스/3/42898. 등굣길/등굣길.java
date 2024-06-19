class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[++n][++m];

        for (int i = 0; i < n; i++) for (int j = 0; j < m; j++) map[i][j] = 0;

        for (int[] pud: puddles) { if (pud.length > 0) {
                map[pud[1]][pud[0]] = -1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                }else if (i == 1 && j == 1) {
                    map[i][j] = 1;
                }else if(i == 1) {
                    map[i][j] = map[i][j - 1];
                }else if(j == 1) {
                    map[i][j] = map[i - 1][j];
                }else {
                    map[i][j] = map[i - 1][j] + map[i][j - 1];
                    map[i][j] %= 1000000007;
                }
            }
        }

        return map[n - 1][m - 1];
    }
}