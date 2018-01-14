class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        if (A == null || A.length == 0 || B == null || B.length == 0 || C == null || C.length == 0 || D == null || D.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = A.length;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                if (!map.containsKey(sum)) {
                    map.put(sum, 0);
                }
                
                map.put(sum, map.get(sum) + 1);
            }
        }
        
        int count = 0;
        for (int c : C) {
            for (int d : D) {
                int sum = c + d;
                if (map.containsKey(-sum)) {
                    count += map.get(-sum);
                }
            }
        }
        
        return count;
    }
}