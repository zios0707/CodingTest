import java.util.Arrays;
import java.util.LinkedList;

class Pair<A extends Integer, B extends Integer> {
    public Integer first;
    public Integer second;
    Pair() {}
    Pair(Integer first, Integer second) {
        first(first);
        second(second);
    }
    public void first(Integer first) {
        this.first = first;
    }
    public void second(Integer second) {
        this.second = second;
    }
}

class Solution {
    static int[] ANSWER;
    static int[][] LAND;
    static int I;
    static int J;
    static int SCORE;
    static Pair<Integer, Integer> leftAndRight;
    static LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();

    public int solution(int[][] land) {
        int i, j, w;
        int[][] newMap = new int[land.length + 2][land[0].length + 2];
        for (j = 1; j < newMap.length - 1; j++) System.arraycopy(land[j - 1], 0, newMap[j], 1, newMap[j].length - 1 - 1);
        land = newMap;
        LAND = land;
        int[] answer = new int[LAND[0].length];
        I = LAND[0].length;
        J = LAND.length;
        for (j = 1; j < LAND.length - 1; j++) {
            for (i = 1; i < LAND[j].length - 1; i++) {
                SCORE = 0;
                if (LAND[j][i] == 1) {
                    queue.add(new Pair<>(j, i));
                    bfs();
                    for (w = leftAndRight.first; w < leftAndRight.second; w++) answer[w] += SCORE;
                    ANSWER = answer; 
                }
            }
        }
        int max = 0;
        for (int jj : answer) max = Math.max(jj, max);
        return max;
    }

    private void bfs() {
        int left = 500, right = 0, y, x, hy, hx, i;
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();
            y = p.first; x = p.second;
            for (i = 0; i < 4; i++) {
                hy = dy[i] + y; hx = dx[i] + x;
                if (LAND[hy][hx] == 1) {
                    LAND[hy][hx] = 2;
                    queue.add(new Pair<>(hy, hx));
                }
            }
            LAND[y][x] = 0;
            left = Math.min(left, x);
            right = Math.max(right, (x + 1));
            SCORE++;
        }
        leftAndRight = new Pair<>(left, right);
    }
}