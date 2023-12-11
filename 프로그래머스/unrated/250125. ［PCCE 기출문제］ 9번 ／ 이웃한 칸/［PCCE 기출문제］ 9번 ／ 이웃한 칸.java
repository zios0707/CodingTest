class Solution {
    public int solution(String[][] board, int h, int w) {
        int count  = 0;
        if (h != 0 && board[h - 1][w].equals(board[h][w])) count++;
        if (w != 0 && board[h][w - 1].equals(board[h][w])) count++;
        if (w + 1 < board[h].length && board[h][w + 1].equals(board[h][w])) count++;
        if (h + 1 < board.length && board[h + 1][w].equals(board[h][w])) count++;
        
        return count;
    }
}