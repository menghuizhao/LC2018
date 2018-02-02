class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, 0);
            }
            
            map.put(sum, map.get(sum) + 1);
        }
        
        return count;
    }
}