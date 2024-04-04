class Solution {
    boolean[][] winning;
    int player;
    public int solution(int n, int[][] results) {
        int result = 0;
        player = n;

        winning = new boolean [n + 1][n + 1];

        // 패배는 승리를 반대로 조회하면 된다.

        // winning [a][b] = true 라면
        // winning [i][a] 로 탐색 후  true 시 [i][b] 는 true

        // 문제는 이것. 위 로직을 실행해도 얘는 제대로 작동 안함.
        // 그래서 이번엔 [b][i] 으로 탐색 함 true 시 [a][i] 를 true

        // 아마도 3연속 이상의 추론이 필요한 경우 오류 발생
        for (int[] i : results) {
            inference(i[0], i[1]);
        }

        for (int j = 1; j <= n; j++) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                if(winning[j][i]) count += 1;
                if(winning[i][j]) count += 1;
            }
            if (count == n - 1) result += 1;
        }
        return result;
    }

    private void inference(int y, int x) {
        winning[y][x] = true;
        for (int j = 1; j <= player; j++) {
            if(winning[j][y] && !winning[j][x]) inference(j, x); // 그냥 해줘도 되긴 하는데 시간초과 걸림
            if(winning[x][j] && !winning[y][j]) inference(y, j);
        }
    }
}