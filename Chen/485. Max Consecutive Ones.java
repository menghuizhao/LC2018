class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                pre++;
                max = Math.max(max, pre);
            } else {
                pre = 0;
            }
        }
        
        return max;
    }
}