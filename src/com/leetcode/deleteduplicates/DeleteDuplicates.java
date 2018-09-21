package com.leetcode.deleteduplicates;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 11/2/14.
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class DeleteDuplicates {

    public static void main(String[] strings) {

        ListNode head = ListNode.createList("1->1->2->3->3");

        DeleteDuplicates deleteDuplicates = new DeleteDuplicates();

        deleteDuplicates.deleteDuplicates(head);

        ListNode.print(head);
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode lastNode = head;
        int lastVal = head.val;

        ListNode current = head.next;
        while (current != null) {
            if (current.val != lastVal) {
                lastNode.next = current;
                lastNode = current;
                lastVal = current.val;
            }
            current = current.next;
        }
        lastNode.next = null;

        return head;
    }
}
