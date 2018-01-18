class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        int[][][] dp = new int[len][len][len + 1];
        return isScramble(s1, s2, 0, 0, len, dp);
    }
    
    public boolean isScramble(String s1, String s2, int i1, int i2, int len, int[][][] dp) {
        if (dp[i1][i2][len] != 0) {
            return dp[i1][i2][len] > 0;
        }
        
        if (s1.substring(i1, i1 + len).equals(s2.substring(i2, i2 + len))) {
            dp[i1][i2][len] = 1;
        } else {
            boolean result = false;
            for (int k = 1; k < len; k++) {
                result |= ((isScramble(s1, s2, i1, i2, k, dp)) && (isScramble(s1, s2, i1 + k, i2 + k, len - k, dp))) 
                       || ((isScramble(s1, s2, i1, i2 + len - k, k, dp)) && (isScramble(s1, s2, i1 + k, i2, len - k, dp)));
            }
            
            dp[i1][i2][len] = result ? 1 : -1;
        }
        
        return dp[i1][i2][len] > 0;
    }
}