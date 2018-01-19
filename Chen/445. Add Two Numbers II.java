/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack<ListNode>();
        while (l1 != null) {
            s1.push(l1);
            l1 = l1.next;
        }
        
        Stack<ListNode> s2 = new Stack<ListNode>();
        while (l2 != null) {
            s2.push(l2);
            l2 = l2.next;
        }
        
        int degree = 0;
        ListNode pre = null;
        while (!s1.empty() || !s2.empty() || degree > 0) {
            int v1 = s1.size() == 0 ? 0 : s1.pop().val;
            int v2 = s2.size() == 0 ? 0 : s2.pop().val;
            int sum = v1 + v2 + degree;
            ListNode node = new ListNode(sum % 10);
            node.next = pre;
            pre = node;
            degree = sum / 10;
        }
        
        return pre;
    }
}