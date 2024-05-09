import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    int[][] map;
    boolean[][] checkedMap;
    public int[] solution(String[] maps) {
        map = new int[maps.length][maps[0].length()];
        checkedMap = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < maps.length; i++) for (int j = 0; j < maps[i].length(); j++) {
            if (maps[i].charAt(j) != 'X') map[i][j] = maps[i].charAt(j) - '0';
            else map[i][j] = 0;
            checkedMap[i][j] = true;
        }
        for (int i = 0; i < maps.length; i++) for (int j = 0; j < maps[i].length(); j++) if (check(i, j)) result.add(bfs(i, j));
        if(result.isEmpty()) return new int[]{-1};
        return result.stream().mapToInt(i -> i).sorted().toArray();
    }

    private int bfs(int y, int x) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        int sum = 0;
        queue.add(new Pair<>(y, x));
        checkedMap[y][x] = false;

        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> p = queue.poll();

            Integer X = p.second, Y = p.first;

            sum += map[Y][X];
            
            for (int i = 0; i < 4; i++) {
                int fx = X + dx[i], fy = Y + dy[i];
                if (check(fy, fx)) {
                    queue.add(new Pair<>(fy, fx));
                    checkedMap[fy][fx] = false;
                }
            } 

        }
        return sum;
    }

    private boolean check(int y, int x) {
        return (0 <= y && y < map.length &&
                0 <= x && x < map[y].length &&
                map[y][x] != 0 && checkedMap[y][x]);
    }
}

class Pair<A extends Object, B extends Object> {
    A first;
    B second;
    public Pair(Object first, Object second) {
        this.first = (A) first;
        this.second = (B) second;
    }
}