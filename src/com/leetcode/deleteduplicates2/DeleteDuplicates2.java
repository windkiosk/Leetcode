package com.leetcode.deleteduplicates2;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 11/2/14.
 * https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class DeleteDuplicates2 {
    public static void main(String[] strings) {

        ListNode head = ListNode.createList("2->2->3->3->4->4->5->5");

        DeleteDuplicates2 deleteDuplicates = new DeleteDuplicates2();

        ListNode.print(deleteDuplicates.deleteDuplicates(head));
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;

        ListNode lastValidNode = dummyNode;

        ListNode current = head;

        ListNode lastNode = null;

        boolean isNeedRemove = false;

        while (current != null) {
            if (lastNode == null) {
                lastNode = current;
            }
            else if (current.val == lastNode.val) {
                isNeedRemove = true;
            } else {
                if (!isNeedRemove) {
                    lastValidNode.next = lastNode;
                    lastValidNode = lastNode;
                }
                lastNode = current;
                isNeedRemove = false;
            }

            current = current.next;
        }

        if (isNeedRemove) {
            lastValidNode.next = null;
        } else {
            lastValidNode.next = lastNode;
        }

        return dummyNode.next;
    }
}
