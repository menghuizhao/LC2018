class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(0) && checkSubstring(s, s.substring(0, i))) {
                return true;
            }
        }
        
        return false;
    }
    
    
    private boolean checkSubstring(String s, String t) {
        if (s.length() % t.length() != 0 || s.length() / t.length() == 1) {
            return false;
        }
        
        String tmp = "";
        for (int i = 0; i < s.length() / t.length(); i++) {
            tmp += t;
        }
        
        return s.equals(tmp);
    }
}