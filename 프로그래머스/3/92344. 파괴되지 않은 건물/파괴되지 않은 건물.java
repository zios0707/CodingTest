class Solution {
    int CNT = 0;

    public int solution(int[][] board, int[][] skill) {
        CNT = board.length * board[0].length;

        int[][] edit = new int[board.length][board[0].length];

        for (int[] s: skill) {
            int diffVal = (s[0] == 1 ? -1 : 1) * s[5];

            edit[s[1]][s[2]] += diffVal;
            if (s[4] + 1 < board[0].length) edit[s[1]][s[4] + 1] -= diffVal;
            if (s[3] + 1 < board.length)edit[s[3] + 1][s[2]] -= diffVal;
            if (s[3] + 1 < board.length && s[4] + 1 < board[0].length) edit[s[3] + 1][s[4] + 1] += diffVal;
        }

        for (int i = 0; i < board.length; i++) for (int j = 1; j < board[0].length; j++) edit[i][j] += edit[i][j - 1];
        for (int i = 0; i < board[0].length; i++) for (int j = 1; j < board.length; j++) edit[j][i] += edit[j - 1][i];

        for (int i = 0; i < board.length; i++) for (int j = 0; j < board[0].length; j++) if(edit[i][j] <= -board[i][j]) CNT--;

        return CNT;
    }
}