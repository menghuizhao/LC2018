class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length / 3) {
            return new int[]{-1, -1, -1};
        }
        
        int len = nums.length;
        int[] sum = new int[len - k + 1];
        for (int i = 0; i < k; i++) {
            sum[0] += nums[i];
        }
        
        for (int i = k; i < len; i++) {
            sum[i - k + 1] = sum[i - k] + nums[i] - nums[i - k];
        }
        
        int[] dp = new int[len + 1];
        int[][] indices = new int[len + 1][2];
        for (int i = len - 2 * k; i >= k; i--) {
            for (int j = i + k; j <= len - k; j++) {
                if (dp[i] < sum[i] + sum[j]) {
                    dp[i] = sum[i] + sum[j];
                    indices[i][0] = i;
                    indices[i][1] = j;
                }
            }
                
            if (dp[i + 1] > dp[i]) {
                dp[i] = dp[i + 1];
                indices[i][0] = indices[i + 1][0];
                indices[i][1] = indices[i + 1][1];
            }
        }
        
        int max = 0;
        int i1 = -1;
        int i2 = -1;
        int i3 = -1;
        for (int i = 0; i <= len - 3 * k; i++) {
            if (sum[i] + dp[i + k] > max) {
                max = sum[i] + dp[i + k];
                i1 = i;
                i2 = indices[i + k][0];
                i3 = indices[i + k][1];
            }
        }
        
        return new int[]{i1, i2, i3};
    }
}