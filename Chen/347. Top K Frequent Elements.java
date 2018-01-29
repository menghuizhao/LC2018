class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequent = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!frequent.containsKey(num)) {
                frequent.put(num, 0);
            }
            
            frequent.put(num, frequent.get(num) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : frequent.keySet()) {
            if (bucket[frequent.get(key)] == null) {
                bucket[frequent.get(key)] = new ArrayList<Integer>();
            }
            
            bucket[frequent.get(key)].add(key);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = nums.length; i >= 0; i--) {
            if (k <= 0) {
                break;
            }
            
            if (bucket[i] != null) {
                for (int num : bucket[i]) {
                    result.add(num);
                }
                
                k = k - bucket[i].size();
            }
        }
        
        return result;
    }
}