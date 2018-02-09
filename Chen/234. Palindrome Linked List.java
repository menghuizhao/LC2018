/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        if (fast.next != null) {
            stack.push(slow.val);
        }
        
        slow = slow.next;
        while (slow != null) {
            if (slow.val != stack.pop()) {
                return false;
            }
            
            slow = slow.next;
        }
        
        return true;
    }
}