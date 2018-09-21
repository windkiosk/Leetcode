package com.practise1;

import com.leetcode.util.ListNode;

/**
 * Created by bod on 11/20/2014.
 */
public class InsertionSortList {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("4->19->14->5->-3->1->8->5->11->15");

        InsertionSortList solution = new InsertionSortList();
        ListNode newHead = solution.insertionSortList(head);
        ListNode.print(newHead);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyNode = new ListNode(-1);

        dummyNode.next = head;

        ListNode current = head.next;

        ListNode lastNode = head, nodeBeforeInsert;

        int count = 1;

        while (current != null) {

            head = dummyNode.next;

            nodeBeforeInsert = dummyNode;

            for (int i = 0; i < count; i ++) {
                if (current.val < head.val) {
                    break;
                }

                nodeBeforeInsert = head;
                head = head.next;
            }

            count ++;

            ListNode next = current.next;

            if (current != head) {
                lastNode.next = next;
                nodeBeforeInsert.next = current;
                current.next = head;
            } else {
                lastNode = current;
            }
            current = next;
        }

        return dummyNode.next;
    }
}
