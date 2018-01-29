class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        
        ArrayList<String> list = new ArrayList<String>();
        int min =  Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j]) && map.get(list2[j]) + j <= min) {
                if (map.get(list2[j]) + j < min) {
                    list.clear();
                }
                
                list.add(list2[j]);
                min = map.get(list2[j]) + j;
            }
        }
        
        String[] result = new String[list.size()];
        int index = 0;
        for (String str : list) {
            result[index++] = str;
        }
        
        return result;
    }
}