/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) { 
        ListNode l1Ptr = l1;
        ListNode prevL1Ptr = l1;
        int carry = 0;
        while (l1Ptr != null) {
            if (l2 == null) {
                l1Ptr.val = l1Ptr.val + carry;
            } else {
                l1Ptr.val = l1Ptr.val + l2.val + carry;
            }
            carry = l1Ptr.val / 10;
            l1Ptr.val = l1Ptr.val % 10;
            prevL1Ptr = l1Ptr;
            l1Ptr = l1Ptr.next;
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        while (l2 != null) {
            int sum = l2.val + carry;
            carry = sum / 10;
            prevL1Ptr.next = new ListNode(sum % 10);
            prevL1Ptr = prevL1Ptr.next;
            l2 = l2.next;
        }
        if (carry > 0) {
            prevL1Ptr.next = new ListNode(carry);
        }
        return l1;
    }
}