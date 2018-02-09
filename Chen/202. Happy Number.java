class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        while (n != 1) {
            n = happyNum(n);
            if (set.contains(n)) {
                return false;
            }
            
            set.add(n);
        }
        
        return true;
    }
    
    private int happyNum(int n) {
        int ret = 0;
        while (n > 0) {
            ret += (n % 10) * (n % 10);
            n = n / 10;
        }
        
        return ret;
    }
}