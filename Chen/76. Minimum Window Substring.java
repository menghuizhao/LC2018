class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        int count = t.length();
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int left = 0;
        int right = 0;
        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            if (map[s.charAt(right++)]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                    end = right;
                }
                
                if (map[s.charAt(left++)]++ == 0) {
                    count++;
                }
            }
        }
        
        return len == Integer.MAX_VALUE ? "" : s.substring(start, end);
    }
}