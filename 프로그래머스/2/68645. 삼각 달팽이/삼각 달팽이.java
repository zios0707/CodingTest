import java.util.Arrays;
class Solution {
    int N;
    int[][] map;
    public int[] solution(int n) {
        N = n;
        int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, -1}};
        map = new int[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) map[i][j] = 0;
        int IDX = 0, x = 0, y = 0, count = 1, errors = 0;

        while (true) {
            if (check(x + direction[IDX][0], y + direction[IDX][1])) {
                map[y][x] = count++;
                x += direction[IDX][0];
                y += direction[IDX][1];
                errors = 0;
            }else {
                IDX = (IDX + 1) % 3;
                errors++;
            }
            if (errors > 1) break;
        }
        map[y][x] = count;
        return Arrays.stream(map).flatMapToInt(Arrays::stream).filter(i -> i != 0).toArray();
    }

    private boolean check(int x, int y) {
        return 0 <= x && x < N &&
                0 <= y && y < N &&
                map[y][x] == 0;
    }
}