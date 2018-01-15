class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        int len = s.length();
        int max = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (isPalindrome(s, 0, i)) {
                max = i;
                break;
            }
        }
        
        return reverse(s, max + 1, len - 1) + s;
    }
    
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
    
    public String reverse(String s, int i, int j) {
        StringBuffer sb = new StringBuffer();
        for (int k = j; k >= i; k--) {
            sb.append(s.charAt(k));
        }
        
        return sb.toString();
    }
}