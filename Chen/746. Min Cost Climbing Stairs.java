class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }
        
        if (cost.length < 3) {
            return cost[cost.length - 1];
        }
        
        int two = cost[0];
        int one = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int cur = Math.min(two, one) + cost[i];
            two = one;
            one = cur;
        }
        
        return Math.min(one, two);
    }
}