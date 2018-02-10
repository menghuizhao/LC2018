class Solution {
    public boolean checkPossibility(int[] nums) {
        boolean flag = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (flag) {
                    return false;
                }
                
                if (i == 1 || nums[i] >= nums[i - 2] || i == nums.length - 1 || nums[i + 1] >= nums[i - 1]) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
}