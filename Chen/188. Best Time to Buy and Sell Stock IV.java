class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        
        int len = prices.length;
        if (k >= len / 2) {
            int sum = 0;
            for (int i = 1; i < len; i++) {
                sum += Math.max(0, prices[i] - prices[i - 1]);
            }
            
            return sum;
        }
        
        int[][] local = new int[len][len];
        int[][] global = new int[len][len];
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(local[i - 1][j], global[i - 1][j - 1]) + diff;
                global[i][j] = Math.max(local[i][j], global[i - 1][j]);
            }
        }
        
        return global[len - 1][k];
    }
}