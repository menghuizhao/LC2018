class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int len = prices.length;
        int[] left = new int[len];
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        
        int[] right = new int[len];
        int max = prices[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        
        int ret = 0;
        for (int i = 0; i < len - 1; i++) {
            ret = Math.max(ret, left[i] + right[i]);
        }
        
        return ret;
    }
}