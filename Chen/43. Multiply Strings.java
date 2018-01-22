class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return num1 == null ? num2 : num1;
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] ret = new int[len1 + len2 + 1];
        for (int j = len2 - 1; j >= 0; j--) {
            int index = len1 + 1 + j;
            int carry = 0;
            int i = len1 - 1;
            while (i >= 0 || carry > 0) {
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2 + carry;
                int sum = ret[index] + mul % 10;
                ret[index] = sum % 10;
                carry = mul / 10 + sum / 10;
                index--;
                i--;
            }
        }  
            
        int i = 0;
        while (i < ret.length && ret[i] == 0) {
            i++;
        }
        
        if (i == ret.length) {
            return "0";
        }
        
        StringBuffer sb = new StringBuffer();
        while (i <= len1 + len2) {
            sb.append(ret[i++]);
        }
        
        return sb.toString();
    }
}