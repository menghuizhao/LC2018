class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[128];
        int left = 0;
        int right = 0;
        int max = 0;
        int count = 0;
        while (right < s.length()) {
            if (map[s.charAt(right++)]++ > 0) {
                count++;
            }
            
            while (count > 0) {
                if (map[s.charAt(left++)]-- > 1) {
                    count--;
                }
            }
                
            max = Math.max(max, right - left);
        }
        
        return max;
    }
}