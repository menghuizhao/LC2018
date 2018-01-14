class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            int left = i + 1;
            int right = len - 1;
            while (left < right) {
                int curSum = nums[i] + nums[left] + nums[right];
                if (curSum == target) {
                    return target;
                } else if (curSum < target) {
                    left++;
                } else {
                    right--;
                }
                
                int curDiff = Math.abs(target - curSum);
                if (curDiff <= diff) {
                    diff = curDiff;
                    sum = curSum;
                }
            }
        }
        
        return sum;
    }
}