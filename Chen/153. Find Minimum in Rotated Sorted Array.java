class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int start = 0; 
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                return nums[mid];
            } 
            
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[start]) {
                start = mid;
            }
        }
        
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}