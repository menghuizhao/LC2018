class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        
        return max;
    }
    
    public static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] > 0) {
            return dp[i][j];
        }
        
        int max = 1;
        for (int k = 0; k < direction.length; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                max = Math.max(max, dfs(matrix, x, y, dp) + 1);
            }
        }
        
        dp[i][j] = max;
        return max;
    }
}