class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 || n > 0) {
            int num1 = m > 0 ? nums1[m - 1] : Integer.MIN_VALUE;
            int num2 = n > 0 ? nums2[n - 1] : Integer.MIN_VALUE;
            if (num1 > num2) {
                nums1[m + n - 1] = num1;
                m--;
            } else {
                nums1[m + n - 1] = num2;
                n--;
            }
        }
    }
}