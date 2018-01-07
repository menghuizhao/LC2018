class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) {
            return false;
        }
        
        HashMap<Long, Long> map = new HashMap<Long, Long>();
        for (int i = 0; i < nums.length; i++) {
            long num = (long)nums[i] - Integer.MIN_VALUE;
            long bucket = num / ((long)t + 1);
            if (map.containsKey(bucket) || (map.containsKey(bucket - 1) && (num - map.get(bucket - 1) <= t)) || (map.containsKey(bucket + 1) && (map.get(bucket + 1) - num) <= t)) {
                return true;
            }
            
            map.put(bucket, num);
            
            if (i >= k) {
                map.remove(((long)nums[i - k] - Integer.MIN_VALUE) / ((long)t + 1), (long)nums[i - k] - Integer.MIN_VALUE);
            }
        }
        
        return false;
    }
}