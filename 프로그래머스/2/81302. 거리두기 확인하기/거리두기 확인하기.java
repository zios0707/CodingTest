import java.util.LinkedList;
import java.util.List;

class Solution {
    boolean[][] visited;
    int[][] map;

    public int[] solution(String[][] places) {
        List<Integer> answer = new LinkedList<>();

        for (int n = 0; n < places.length; n++) {
            boolean token = true;

            map = new int[places[0].length][places[0][0].length()];
            visited = new boolean[places[0].length][places[0][0].length()];

            for (int i = 0; i < places[n].length; i++) {
                for (int j = 0; j < places[n][i].length(); j++) {
                    String c = places[n][i].substring(j, j + 1);

                    if (c.equals("P")) {
                        map[i][j] = 1;
                    }else if (c.equals("O")) {
                        map[i][j] = 0;
                    }else {
                        map[i][j] = -1;
                    }
                }
            }

            for (int i = 0; i < map.length; i++) if (token)
                for (int j = 0; j < map[i].length; j++)
                    if (map[i][j] == 1) {
                        visited[i][j] = true;
                        if (!dfs(i, j, 0)) {
                            token = false;
                            break;
                        }
                        visited[i][j] = false;
                    }

            answer.add((token) ? 1 : 0);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    private boolean dfs(int i, int j, int depth) {
        if (map[i][j] == -1) return true;
        if (depth != 0 && map[i][j] == 1) return false;
        if (depth == 2) return map[i][j] != 1;

        boolean token = true;
        
        for (int I = 0; I < 4; I++) {
            int x = i + dx[I];
            int y = j + dy[I];
            if (check(x, y) && !visited[x][y]) {
                visited[x][y] = true;
                if (!dfs(x, y, depth+1)) token = false;
                visited[x][y] = false;
            }
        }

        return token;
    }

    private boolean check(int i, int j) {
        return 0 <= i && i < map.length &&
                0 <= j && j < map[i].length;
    }
}