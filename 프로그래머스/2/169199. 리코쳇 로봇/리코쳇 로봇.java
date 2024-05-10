import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    int[][] map;
    int[][] cnt;
    boolean[][] checked;
    public int solution(String[] board) {
        map = new int[board.length][board[0].length()];
        cnt = new int[board.length][board[0].length()];
        checked = new boolean[board.length][board[0].length()];

        int x = -1, y = -1;
        int xx = -1, yy = -1;

        for (int i = 0; i < board.length; i++) {
            Arrays.fill(cnt[i], 0);
            Arrays.fill(checked[i], false);
            for (int j = 0; j < board[i].length(); j++) {
                int n, c = board[i].charAt(j); // -1 은 벽, 0 은 빈공간, 1에서 2까지 가야함.
                if (c == '.') n = 0;
                else if(c == 'D') n = -1;
                else if(c == 'R') {
                    n = 1;
                    x = j; y = i;
                } else {
                    n = 2;
                    xx = j; yy = i;
                };

                map[i][j] = n;
            }
        }

        return bfs(y, x, yy, xx);
    }

    // 무한 반복에 빠질 수 있으나 그건 DFS 에서나 일어남.
    // 그리고 최단 거리를 구해야 하니 BFS 가 무조건 쓰일 것. (문제가 탐색이기도 하고)

    private int bfs(int Y, int X, int y1, int x1) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(Y, X));
        boolean won = false;
        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, -1, 0, 1};


        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int x = p.second, y = p.first;
            checked[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int fx = x, fy = y;

                while(check(fy + dy[i], fx + dx[i])) {
                    fy += dy[i]; fx += dx[i];
                }

                if (map[fy][fx] == 2) {
                    won = true;
                    cnt[fy][fx] = cnt[y][x] + 1;
                    break;
                }else if (!checked[fy][fx]) {
                    q.add(new Pair<>(fy, fx));
                    checked[fy][fx] = true;
                    cnt[fy][fx] = cnt[y][x] + 1;
                }
            }

            if (won) break;
        }

        if (won) return cnt[y1][x1];
        else return -1;

    }

    private boolean check(int y, int x) {
        return (0 <= y && y < map.length &&
                0 <= x && x < map[y].length &&
                map[y][x] != -1);
    }
}
class Pair<A, B> {
    A first;
    B second;
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }
}