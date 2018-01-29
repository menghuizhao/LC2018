class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            
            map.put(c, map.get(c) + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        for (Character c : map.keySet()) {
            if (bucket[map.get(c)] == null) {
                bucket[map.get(c)] = new ArrayList<Character>();
            }
            
            bucket[map.get(c)].add(c);
        }
        
        StringBuffer sb = new StringBuffer();
        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i] != null) {
                for (Character c : bucket[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        
        return sb.toString();
    }
}