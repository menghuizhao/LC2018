/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            if (fast == null) {
                return head;
            }
            
            fast = fast.next;
            n--;
        }
        
        if (fast == null) {
            return head.next;
        }
        
        ListNode pre = null;
        ListNode slow = head;
        while (fast != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        
        pre.next = slow.next;
        return head;
    }
}