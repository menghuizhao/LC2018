class RandomizedSet {
    private ArrayList<Integer> arr;
    private HashMap<Integer, Integer> map;
    Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.arr = new ArrayList<Integer>();
        this.map = new HashMap<Integer, Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        
        map.put(val, arr.size());
        arr.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val);
        if (index != arr.get(arr.size() - 1)) {
            int tail = arr.get(arr.size() - 1);
            arr.set(index, tail);
            map.put(tail, index);
        }
        
        map.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */