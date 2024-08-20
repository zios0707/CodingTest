    import java.util.*;
class Solution {
        int[][] map;
        public int[] solution(int rows, int columns, int[][] queries) {
            map = new int[rows][columns];
            for (int i = 0; i < rows; i++) for (int j = 0; j < columns; j++) map[i][j] = i * columns + j + 1;
            return Arrays.stream(queries).map(o -> querying(o)).mapToInt(i -> i).toArray();
        }

        private int querying(int[] query) {
            int min = Integer.MAX_VALUE, d = 0, x = query[1] - 1, y = query[0] - 1, sx = query[1] - 1, sy = query[0] - 1, ex = query[3] - 1, ey = query[2] - 1, px, py, temp = 0;
            int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

            while(d != 4) {
                px = x + dx[d]; py = y + dy[d];

                if (check(sx, sy, ex, ey, px, py)) {
                    if (temp == 0) temp = map[y][x];

                    int val = map[py][px];
                    map[py][px] = temp;
                    temp = val;

                    min = Math.min(min, map[py][px]);

                    x = px;y = py;
                }
                else d++;
            }

            return min;
        }

        private boolean check(int x1, int y1, int x2, int y2, int px, int py) {
            return (x1 <= px && px <= x2) && (y1 <= py && py <= y2);
        }
    }