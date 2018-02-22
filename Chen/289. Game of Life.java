class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return;
        }
        
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = getLives(board, m, n, i, j);
                if (board[i][j] == 1 && (lives < 2 || lives > 3)) {
                    board[i][j]++;
                } 
                
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = -1;
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] > 1) {
                    board[i][j] = 0;
                } else if (board[i][j] < 0) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int getLives(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for (int k = Math.max(i - 1, 0); k <= Math.min(i + 1, m - 1); k++) {
            for (int t = Math.max(j - 1, 0); t <= Math.min(j + 1, n - 1); t++) {
                if ((k != i || t != j) && board[k][t] > 0) {
                    lives++;
                }
            }
        }
        
        return lives;
    }
}