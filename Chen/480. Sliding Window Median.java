public class Solution {
    public class Data {
        private PriorityQueue<Double> min;
        private PriorityQueue<Double> max;
        private double medium;
        
        public Data(double start) {
            this.medium = start;
            this.min = new PriorityQueue<Double>();
            this.max = new PriorityQueue<Double>();
        }
        
        public double getMedium() {
            if (min.size() == max.size()) {
                return medium;
            } else {
                return (medium + max.peek()) / 2;
            }
        }
        
        public void add(double num) {
            if (num >= medium) {
                max.offer(num);
            } else {
                min.offer(-num);
            }
            
            this.reset();
        } 
        
        public void remove(double num) {
            if (num == medium) {
                medium = max.poll();
            } else if (num < medium) {
                min.remove(-num);
            } else {
                max.remove(num);
            }
            
            this.reset();
        }
        
        private void reset() {
            if (max.size() > min.size() + 1) {
                min.offer(-medium);
                medium = max.poll();
            } else if (min.size() > max.size()) {
                max.offer(medium);
                medium = -min.poll();
            }
        }
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new double[0];
        }
        
        int len = nums.length;
        double[] result = new double[len - k + 1];
        Data data = new Data(nums[0]);
        if (k == 1) {
            result[0] = data.getMedium();
        }
        for (int i = 1; i < len; i++) {
            data.add(nums[i]);
            if (i >= k) {
                data.remove(nums[i - k]);
            }
            
            if (i >= k - 1) {
                result[i - k + 1] = data.getMedium();
            }
        }
        
        return result;
    }
};