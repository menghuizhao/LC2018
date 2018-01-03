public class Solution {
    public static String reverseWords(String s) {
        if (s == null) {
            return s;
        }
        
        s = s.trim();
        if (s.length() == 0) {
            return s;
        }
        
        StringBuffer sb = new StringBuffer();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (s.charAt(i) == ' ' && s.charAt(j) != ' ') {
                i = j;
            } else if (s.charAt(i) != ' ' && s.charAt(j) == ' ') {
                sb.append(reverseString(s, i, j - 1));
                sb.append(' ');
                i = j;
            }
            
            j++;
        }
        
        sb.append(reverseString(s, i, s.length() - 1));
        return reverseString(sb.toString(), 0, sb.length() - 1);
    }
    
    public static String reverseString(String s, int i, int j) {
        StringBuffer sb = new StringBuffer();
        for (int k = j; k >= i; k--) {
            sb.append(s.charAt(k));
        }
        
        return sb.toString();
    }
}