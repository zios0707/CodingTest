class Solution {
    int[][] map;
    
    public int solution(int[][] board) {
        map = board;
        int count = 0;
        int[] fx = new int[]{1, 1, 1, 0, 0, 0, -1, -1, -1};
        int[] fy = new int[]{1, 0, -1, 1, 0, -1, 1, 0, -1};
        for(int j = 0; j < board.length; j++) for(int i = 0; i < board.length; i++) {
            int val = 0;
            for(int k = 0; k < 9; k++) 
                if (check(i + fx[k], j + fy[k]) && (map[i + fx[k]][j + fy[k]] == 1)) continue;
                else val++;
            if (val == 9) count++;
        }
        return count;
    }
    
    private boolean check(int x, int y) {
        return (0 <= x && x < map.length &&
               0 <= y && y < map.length);
    }
}