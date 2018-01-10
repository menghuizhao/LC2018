class MedianFinder {
    private PriorityQueue<Integer> min;
    private PriorityQueue<Integer> max;
    Integer medium;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        min = new PriorityQueue<Integer>();
        max = new PriorityQueue<Integer>();
    }
    
    public void addNum(int num) {
        if (medium == null) {
            medium = num;
            return;
        } 
        
        if(num >= medium) {
            max.offer(num);
        } else {
            min.offer(-num);
        }
        
        this.reset();
    }
    
    public double findMedian() {
        if (min.size() == max.size()) {
            return (double)medium;
        } else {
            return ((double)medium + (double)max.peek()) / 2.0;
        }
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

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */