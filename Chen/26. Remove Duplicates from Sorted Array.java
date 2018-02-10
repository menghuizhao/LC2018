class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == pre) {
                count++;
            } else {
                pre = nums[i];
                if (count > 0) {
                    nums[i - count] = nums[i];
                }
            }
        }
        
        return nums.length - count;
    }
}