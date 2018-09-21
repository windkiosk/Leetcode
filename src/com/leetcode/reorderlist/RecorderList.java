package com.leetcode.reorderlist;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 8/17/14.
 *
 * https://oj.leetcode.com/problems/reorder-list/
 *
 * <p/>
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p/>
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
public class RecorderList {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("1->2->3->4->5->6->7");

        RecorderList recorderList = new RecorderList();
        recorderList.reorderList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode middle = getMiddleNode(head);
        middle = reverse(middle);
        merge(head, middle);
    }

    private ListNode reverse(ListNode middle) {
        ListNode current = middle.next;

        ListNode last = middle;

        middle.next = null;

        while (current != null) {
            ListNode next = current.next;
            current.next = last;
            last = current;
            current = next;
        }

        return last;
    }

    private void merge(ListNode head, ListNode middle) {

        while (head != null && middle != null) {
            ListNode headNext = head.next;
            ListNode middleNext = middle.next;

            head.next = middle;
            middle.next = headNext;

            head = headNext;
            middle = middleNext;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode current = head;
        ListNode middle = head;

        int step = 0;
        while (current.next != null) {
            current = current.next;
            step++;

            if (step == 2) {
                step = 0;
                middle = middle.next;
            }
        }

        ListNode reverseNode = middle.next;
        middle.next = null;
        return reverseNode;
    }
}
