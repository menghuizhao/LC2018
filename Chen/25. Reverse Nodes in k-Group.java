/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        ListNode node = head;
        while (node != null) {
            len++;
            node = node.next;
        }

        ListNode preTail = dummy;
        ListNode curTail = head;
        ListNode pre = dummy;
        node = head;
        ListNode next = null;
        for (int i = 0; i < len / k; i++) {
            for (int j = 0; j < k; j++) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            preTail.next = pre;
            curTail.next = node;
            preTail = curTail;
            curTail = node;
        }
        
        return dummy.next;
    }
}