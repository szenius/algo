/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {   
        ListNode curr = head;
        ListNode target = head;
        int i = 0;
        while (curr != null) {
            if (i > n) {
                target = target.next;
            }
            curr = curr.next;
            i++;
        }
        
        if (i <= n) {
            return head.next;
        } else {
            target.next = target.next.next;
        }
        
        return head;
    }
}