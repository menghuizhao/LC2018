/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        ListNode node = head;
        int len = 0;
        while (node != null) {
            node = node.next;
            len++;
        }
        
        k = k % len;
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        
        ListNode tail = null;
        while (fast != null) {
            fast = fast.next;
            tail = slow;
            slow = slow.next;
        }
        
        tail.next = null;
        ListNode dummy = new ListNode(0);
        node = dummy;
        while (slow != null) {
            node.next = slow;
            slow = slow.next;
            node = node.next;
        }
        
        node.next = head;
        return dummy.next;
        
    }
}