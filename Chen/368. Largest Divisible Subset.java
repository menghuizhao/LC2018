class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return ret;
        }

        Arrays.sort(nums);
        int len = nums.length;
        int[] count = new int[len];
        int[] pre = new int[len];
        int max = 0;
        int index = -1;
        for (int i = 0; i < len; i++) {
            count[i] = 1;
            pre[i] = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    if (count[j] + 1 > count[i]) {
                        count[i] = count[j] + 1;
                        pre[i] = j;
                    }
                }
            }

            if (count[i] > max) {
                index =i;
                max = count[i];
            }
        }

        while (index >= 0) {
            ret.add(nums[index]);
            index = pre[index];
        }

        return ret;
    }
}