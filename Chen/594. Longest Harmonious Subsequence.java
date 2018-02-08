class Solution {
    public int findLHS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            
            map.put(num, map.get(num) + 1);
        }
        
        int max = 0;
        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                max = Math.max(max, map.get(num - 1) + map.get(num));
            }
        }
        
        return max;
    }
}