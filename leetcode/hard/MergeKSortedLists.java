/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 */

 class MergeKSortedLists {
    private int findMinIndex(ListNode[] lists) {
        int minIndex = -1;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) {
                continue;
            }
            if (minIndex == -1 || lists[i].val < lists[minIndex].val) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int rootIndex = findMinIndex(lists);
        if (rootIndex == -1) {
            return null;
        }
        
        ListNode root = lists[rootIndex];
        lists[rootIndex] = lists[rootIndex].next;

        ListNode prev = root;
        int minIndex = findMinIndex(lists);
        while (minIndex != -1) {
            ListNode min = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            prev.next = min;
            min.next = null;
            prev = min;
            minIndex = findMinIndex(lists);
        }
        return root;
    }
 }