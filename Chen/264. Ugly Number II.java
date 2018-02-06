class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int[] factor = new int[]{2, 3, 5};
        int[] index = new int[]{0, 0, 0};
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(ugly[index[0]] * factor[0], ugly[index[1]] * factor[1]), ugly[index[2]] * factor[2]);
            ugly[i] = min;
            if (min == ugly[index[0]] * factor[0]) {
                index[0]++;
            }
            
            if (min == ugly[index[1]] * factor[1]) {
                index[1]++;
            } 
            
            if (min == ugly[index[2]] * factor[2]) {
                index[2]++;
            }
        }
        
        return ugly[n - 1];
    }
}