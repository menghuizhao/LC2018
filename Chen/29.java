class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = -1;
        }
            
        long up = Math.abs((long) dividend);
        long down = Math.abs((long) divisor);
        long ans = divideHelper(up, down);
        if (ans >= Integer.MAX_VALUE) {
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return sign * (int)ans;
    }
    
    public long divideHelper(long up, long down) {
        if (down == 0) {
            return Integer.MAX_VALUE;
        }
        
        if (up == 0 || up < down) {
            return 0;
        }
        
        long multi = 1;
        long sum = multi * down;
        while ( sum * 2 <= up) {
            multi += multi;
            sum = multi * down;
        }
        
        return multi + divideHelper(up - sum, down);
    }
}