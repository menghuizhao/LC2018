class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        HashSet<String> set = new HashSet<String>();
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }   
        });
        
        for (String word : words) {
            if (isConcatenate(set, word)) {
                result.add(word);
            }
            
            set.add(word);
        }
        
        return result;
    }
    
    public boolean isConcatenate(HashSet<String> set, String word) {
        if (set.isEmpty()) {
            return false;
        }
        
        int len = word.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[len];
    }
}