/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        
        HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();
        RandomListNode node = head;
        while (node != null) {
            map.put(node.label, new RandomListNode(node.label));
            node = node.next;
        }
        
        node = head;
        while (node != null) {
            if (node.next != null) {
                map.get(node.label).next = map.get(node.next.label);
            }
            
            if (node.random != null) {
                map.get(node.label).random = map.get(node.random.label);
            }
            
            node = node.next;
        }
        
        return map.get(head.label);
    }
}