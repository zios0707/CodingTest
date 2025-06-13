import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[101][101];
        boolean[][] blocked = new boolean[101][101];


        int cnt = 0;
        for (int[] square: rectangle) {
            cnt++;
            for (int i = square[0]; i <= square[2]; i++) for (int j = square[1]; j <= square[3]; j++) {
                if (map[i * 2][j * 2] >= 0) map[i * 2][j * 2] = cnt;

                if (map[i * 2 -2][j * 2] == cnt) map[i*2-1][j*2] = cnt;
                if (map[i * 2][j * 2 - 2] == cnt) map[i*2][j*2-1] = cnt;
            }

            for (int i = square[0]*2 + 1; i <= square[2] * 2 - 1; i++) for (int j = square[1]*2 + 1; j <= square[3] * 2 - 1; j++) blocked[i][j] = true;
        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(characterX*2, characterY*2, 0));
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

//        for (int[] m : map) System.out.println(Arrays.toString(m));
//        for (boolean[] m : blocked) System.out.println(Arrays.toString(m));

        while(!q.isEmpty()) {
            Pair p = q.poll();
            if (p.x == itemX*2 && p.y == itemY*2) {
                return p.cnt / 2;
            }


            for (int i = 0; i < 4; i++){
                int x = p.x + dx[i], y = p.y + dy[i];

                if (x < 0 || y < 0 || x >= map.length || y >= map.length) continue;
                if (map[x][y] == 0 || map[x][y] == -1 || blocked[x][y]) continue;
                q.offer(new Pair(x, y, p.cnt + 1));
                map[x][y] = 0;
            }
        }


        return -1;
    }

    private static class Pair {
        int x;
        int y;
        int cnt;

        public Pair(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}