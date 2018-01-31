/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            ListNode pre = dummy;
            while (pre.next != null && pre.next.val < node.val) {
                pre = pre.next;
            }
            
            node.next = pre.next;
            pre.next = node;
            node = next;
        }
        
        return dummy.next;
    }
}