class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0 || k > nums.length) {
            return new int[0];
        } 
        
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < len; i++) {
            if (i >= k && dq.peekLast() == nums[i - k]) {
                dq.pollLast();
            }
            
            while (!dq.isEmpty() && dq.peekFirst() < nums[i]) {
                dq.pollFirst();
            }
            
            dq.offerFirst(nums[i]);
            if (i >= k - 1) {
                result[i - k + 1] = dq.peekLast();
            }
        }
        
        return result;
    }
}