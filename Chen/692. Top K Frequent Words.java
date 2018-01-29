class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<String, Integer>();
        for (String word : words) {
            if (!frequency.containsKey(word)) {
                frequency.put(word, 0);
            }
            
            frequency.put(word, frequency.get(word) + 1);
        }
        
        ArrayList<String>[] bucket = new ArrayList[words.length + 1];
        for (String key : frequency.keySet()) {
            if (bucket[frequency.get(key)] == null) {
                bucket[frequency.get(key)] = new ArrayList<String>();
            }
            
            bucket[frequency.get(key)].add(key);
        }
        
        List<String> result = new ArrayList<String>();
        for (int i = words.length; i >= 0 && k > 0; i--) {
            if (bucket[i] != null) {
                ArrayList<String> list = bucket[i];
                Collections.sort(list, new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        int index = 0;
                        while (index < s1.length() && index < s2.length()) {
                            if (s1.charAt(index) != s2.charAt(index)) {
                                return s1.charAt(index) - s2.charAt(index);
                            } 
                            
                            index++;
                        }
                        
                        return s1.length() - s2.length();
                    }
                });
                
                for (int j = 0; j < list.size() && k > 0; j++) {
                    result.add(list.get(j));
                    k--;
                }
            }
        }
        
        return result;
    }
}