class RandomizedCollection {
    private HashMap<Integer, HashSet<Integer>> map;
    private ArrayList<Integer> arr;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, HashSet<Integer>>();
        arr = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = false;
        if (!map.containsKey(val)) {
            map.put(val, new HashSet<Integer>());
            contain = true;
        }
        
        map.get(val).add(arr.size());
        arr.add(val);
        return contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        
        int index = map.get(val).iterator().next();
        map.get(val).remove(index);
        if (index != arr.size() - 1) {
            int tail = arr.get(arr.size() - 1);
            arr.set(index, tail);
            map.get(tail).remove(arr.size() - 1);
            map.get(tail).add(index);
        } 
        
        arr.remove(arr.size() - 1);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return arr.get(rand.nextInt(arr.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */