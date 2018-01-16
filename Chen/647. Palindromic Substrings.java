class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countPalindrome(s, i, i);
            count += countPalindrome(s, i - 1, i);
        }
        
        return count;
    }
    
    public int countPalindrome(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i--) == s.charAt(j++)) {
            count++;
        }
        
        return count;
    }
}