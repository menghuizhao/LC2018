class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            
            map.put(c, map.get(c) + 1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}