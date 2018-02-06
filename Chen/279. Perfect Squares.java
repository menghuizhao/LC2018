class Solution {
    public int numSquares(int n) {
        int[] square = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            square[i * i] = 1; 
        }
        
        for (int i = 2; i <= n; i++) {
            if (square[i] == 1) {
                continue;
            }
            
            square[i] = i;
            for (int j = 1; j <= i / 2; j++) {
                square[i] = Math.min(square[i], square[j] + square[i - j]);
            }
        }
        
        return square[n];
    }
}