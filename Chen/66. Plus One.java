class Solution {
    public int[] plusOne(int[] digits) {
        int degree = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = digits[i] + degree;
            digits[i] = sum % 10;
            degree = sum / 10;
        }
        
        if (degree == 0) {
            return digits;
        } else {
            int[] ret = new int[digits.length + 1];
            ret[0] = degree;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            
            return ret;
        }
    }
}