/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        int val = 0;
        boolean duplicate = false;
        while (head.next != null) {
            if (head.val == head.next.val) {
                val = head.val;
                duplicate = true;
            } else {
                if (!duplicate || val != head.val) {
                    node.next = head;
                    node = node.next;
                }
                
                duplicate = false;
            }
            
            head = head.next;
        }
        
        node.next = duplicate ? null : head;
        
        return dummy.next;
    }
}