/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        if (k <= 0) {
            return new ListNode[0];
        } 
        
        ListNode node = root;
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        
        ListNode[] result = new ListNode[k];
        int count = len / k;
        int rem = len % k;
        node = root;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                result[i] = node;
                continue;
            }
            
            ListNode start = node;
            for (int j = 0; j < (rem > 0 ? count : count - 1); j++) {
                node = node.next;
            }
            
            if (node != null) {
                ListNode next = node.next;
                node.next = null;
                node = next;
            }
            
            result[i] = start;
            rem--;
        }
        
        
        return result;
    }
}