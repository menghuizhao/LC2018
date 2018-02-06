class Solution {
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] factor = new int[]{2, 3, 5};
        for (int i = 0; i < factor.length; i++) {
            while (num % factor[i] == 0) {
                num = num / factor[i];
            }
        }
        
        return num == 1;
    }
}