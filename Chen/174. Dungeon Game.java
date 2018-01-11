class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0] == null || dungeon[0].length == 0) {
            return 0;
        }
        
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    continue;
                }
                
                dp[i][j] = Integer.MAX_VALUE;
                if (i < m - 1) {
                    dp[i][j] = Math.min(Math.max(1, dp[i + 1][j] - dungeon[i][j]), dp[i][j]);
                }
                
                if (j < n - 1) {
                    dp[i][j] = Math.min(Math.max(1, dp[i][j + 1] - dungeon[i][j]), dp[i][j]);
                }
            }
        }
        
        return dp[0][0];
    }
}