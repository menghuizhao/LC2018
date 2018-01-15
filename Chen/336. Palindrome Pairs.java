class Solution {
    public static class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> indices;
        public TrieNode() {
            next = new TrieNode[26];
            index = -1;
            indices = new ArrayList<Integer>();
        }
    } 
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            add(root, words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            search(root, words[i], i, result);
        }
        
        return result;
    }
    
    public void add(TrieNode node, String word, int index) {
        for (int j = word.length() - 1; j >= 0; j--) {
            int c = word.charAt(j) - 'a';
            if (node.next[c] == null) {
                node.next[c] = new TrieNode();
            }
            
            if (isPalindrome(word, 0, j)) {
                node.indices.add(index);
            }
            
            node = node.next[c];
        }
        
        node.indices.add(index);
        node.index = index;
    }
    
    public void search (TrieNode node, String word, int index, List<List<Integer>> result) {
        for (int i = 0; i < word.length(); i++) {
            if (node.index >= 0 && node.index != index && isPalindrome(word, i, word.length() - 1)) {
                result.add(new ArrayList<Integer>(Arrays.asList(index, node.index)));
            }
            
            node = node.next[word.charAt(i) - 'a'];
            if (node == null) {
                return;
            }
        }
        
        for (int i : node.indices) {
            if (i != index) {
                result.add(new ArrayList<Integer>(Arrays.asList(index, i)));
            }
        }
    }
    
    public boolean isPalindrome(String word, int i, int j) {
        while (i <= j) {
            if (word.charAt(i++) != word.charAt(j--)) {
                return false;
            }
        }
        
        return true;
    }
}