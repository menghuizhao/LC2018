class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        int mod = 0;
        for (int i = 0; i < nums.length; i++) {
            mod = k == 0 ? mod + nums[i] : (mod + nums[i]) % k;
            if (map.containsKey(mod) && i - map.get(mod) > 1) {
                return true;
            }
            
            if (!map.containsKey(mod)) {
                map.put(mod, i);
            }
        }
        
        return false;
    }
}