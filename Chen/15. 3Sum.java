class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                
                if (k < len - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }
                
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j++], nums[k--])));
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        
        return result;
    }
}