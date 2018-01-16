class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String s1 = getPalindrome(s, i, i);
            if (s1.length() > result.length()) {
                result = s1;
            }
            if (i > 0) {
                String s2 = getPalindrome(s, i - 1, i);
                if (s2.length() > result.length()) {
                    result = s2;
                }
            }
        }
                           
        return result;
    }
    
    public String getPalindrome(String s, int i, int j) {
        if (i != j && s.charAt(i) != s.charAt(j)) {
            return "";
        }
        
        i--;
        j++;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        
        return s.substring(i + 1, j);
    }
}