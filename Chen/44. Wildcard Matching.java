class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        
        int lens = s.length();
        int lenp = p.length();
        boolean[][] dp = new boolean[lens + 1][lenp + 1];
        dp[lens][lenp] = true;
        
        for (int j = lenp - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                dp[lens][j] = true;
            } else {
                break;
            }
        }
        
        for (int i = lens - 1; i >= 0; i--) {
            for (int j = lenp - 1; j >= 0; j--) {
                char cs = s.charAt(i);
                char cp = p.charAt(j);
                if (cp == '*') {
                    dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                } else if (cp == '?' || cp == cs) {
                    dp[i][j] = dp[i + 1][j + 1];
                }
            }
        }
        
        return dp[0][0];
    }
}