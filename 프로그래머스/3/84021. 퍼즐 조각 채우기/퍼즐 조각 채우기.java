import java.util.*;
import java.util.stream.Collectors;

class Solution {
    int blocks, size;

    int[][] puzzle;

    Map<Integer, List<int[][]>> boardMap;

    Map<Integer, List<int[][]>> tableMap;

    public int solution(int[][] game_board, int[][] table) {
        blocks = 0;
        size = table.length;

        boardMap = new HashMap<>();
        tableMap = new HashMap<>();

        saveBlocks(boardMap, game_board, 0);
        saveBlocks(tableMap, table, 1);

        for (int i : tableMap.keySet().stream().filter(i -> boardMap.containsKey(i)).collect(Collectors.toUnmodifiableList()))
            for (int[][] j : tableMap.get(i))
                for (int[][] k : boardMap.get(i))
                    if (checkEquals(j, k)) { boardMap.get(i).remove(k); blocks += i; break; }

        return blocks;
    }

    private boolean checkEquals(int[][] a, int[][] b) {
        Coordinate center = new Coordinate(0, 0);
        exit:
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] == 1) { center = new Coordinate(j, i); break exit; }

        List<Coordinate> searchWay = search(center, a);

        for (int k = 0; k < 4; k++) {
            exit:
            for (int i = 0; i < b.length; i++)
                for (int j = 0; j < b[0].length; j++)
                    if (b[i][j] == 1) { center = new Coordinate(j, i); break exit; }

            List<Coordinate> searchWay2 = search(center, b);

            if (searchWay.equals(searchWay2)) return true;
            b = turnLeft(b);
        }

        return false;
    }

    private List<Coordinate> search(Coordinate start, int[][] map) {
        List<Coordinate> searchWay = new ArrayList<>();
        int[][] clone = new int[map.length][map[0].length];
        for (int i = 0; i < clone.length; i++) clone[i] = map[i].clone();

        int x = start.x, y = start.y;

        Queue<Coordinate> queue = new LinkedList<>();

        queue.add(start);

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            clone[current.y][current.x] = 0;

            for (int i = 0; i < 4; i++) {
                int dx = current.x + dirX[i], dy = current.y + dirY[i];

                if (check(dx, dy, map[0].length, map.length) && clone[dy][dx] == 1) {
                    Coordinate thisCoordinate = new Coordinate(dx, dy);
                    queue.add(thisCoordinate);
                    searchWay.add(start.minus(thisCoordinate));
                }
            }
        }

        return searchWay;
    }

    private int[][] turnLeft(int[][] map) {
        int[][] newMap = new int[map[0].length][map.length];

        for (int i = 0; i < map.length; i++) for (int j = 0; j < map[0].length; j++) newMap[map[0].length - 1 - j][i] = map[i][j];

        return newMap;
    }

    private class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        Coordinate minus(Coordinate diff) {
            return new Coordinate(this.x - diff.x, this.y - diff.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }
    }


    int Y, X, SCAN;

    private void saveBlocks(Map<Integer, List<int[][]>> map, int[][] prim_map, int scan_num) {
        // 0, 4 가 기본 인덱스
        SCAN = scan_num;

        for (int i = 0; i < prim_map.length; i++) {
            for (int j = 0; j < prim_map[i].length; j++) {
                if(prim_map[i][j] == SCAN) { // 0 : 탐색 안된 블럭, 1 : 벽 or 탐색된 블 // table은 물론 반대
                    puzzle = new int[6][11];

                    Y = i; X = j;
                    int puzzleSize = dfs(i, j, prim_map);
                    List<int[][]> list = map.getOrDefault(puzzleSize, new ArrayList<>());
                    list.add(puzzle);

                    map.put(puzzleSize, list);
                }
            }
        }
    }


    // i == y, j == x
    int[] dirX = {1, 0, -1 ,0};
    int[] dirY = {0, -1, 0, 1};
    private int dfs(int y, int x, int[][] map) {
        map[y][x] = 1 - SCAN;
        setBlock(x, y);

        int stack = 1;

        for (int i = 0; i < 4; i++) {
            int dx = x + dirX[i], dy = y + dirY[i];

            if (check(dx, dy) && map[dy][dx] == SCAN) stack += dfs(dy, dx, map);
        }


        return stack;
    }

    private boolean check(int x, int y) {
        return (0 <= x && x < size) && (0 <= y && y < size);
    }

    private boolean check(int x, int y, int endX, int endY) {
        return (0 <= x && x < endX) && (0 <= y && y < endY);
    }

    private void setBlock(int x, int y) {
        puzzle[y - Y][x - X + 5] = 1;
    }
}
