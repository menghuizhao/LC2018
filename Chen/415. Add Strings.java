class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int degree = 0;
        String sum = "";
        while (i1 >= 0 || i2 >= 0 || degree > 0) {
            int n1 = i1 >= 0 ? num1.charAt(i1--) - '0' : 0;
            int n2 = i2 >= 0 ? num2.charAt(i2--) - '0' : 0;
            sum = (n1 + n2 + degree) % 10 + sum;
            degree = (n1 + n2 + degree) / 10;
        }
        
        return sum;
    }
}