class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] local = new int[len];
        int[] global = new int[len];
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            local[i] = Math.max(0, diff + local[i - 1]);
            if (i > 2) {
                local[i] = Math.max(local[i], diff + global[i - 3]);
            }
            
            System.out.println("local" + i + ": " + local[i]);
            
            global[i] = Math.max(local[i], global[i - 1]);
            System.out.println("global" + i + ": " + global[i]);
        }
        
        return global[len - 1];
    }
}