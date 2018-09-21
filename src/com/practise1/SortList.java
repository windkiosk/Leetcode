package com.practise1;

import com.leetcode.util.ListNode;


/**
 * Created by bod on 11/20/2014.
 */
public class SortList {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("2->3->1->6->5->7->4");

        SortList solution = new SortList();
        ListNode newHead = solution.sortList(head);
        ListNode.print(newHead);
    }

    public ListNode sortList(ListNode head) {
        if (head == null) return head;
        int len = getLength(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        for (int span = 1; span < len; span *= 2) {
            ListNode last = dummy;
            while (last.next != null) {
                last = merge(last, span);
            }
        }
        return dummy.next;
    }

    private ListNode merge(ListNode pre, int span) {
        ListNode first = null, second = null, curr = pre.next, tail;
        int count = 0;
        while (curr != null && count < span * 2) {
            if (first == null) first = curr;
            if (count == span) second = curr;
            ListNode next = curr.next;
            count ++;
            if (count == span) curr.next = null;
            if (count == span * 2) curr.next = null;
            curr = next;
        }
        tail = curr;
        curr = pre;
        while (first != null && second != null) {
            if (first.val < second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }

        while (first != null) {
            curr.next = first;
            curr = first;
            first = first.next;
        }

        while (second != null) {
            curr.next = second;
            curr = second;
            second = second.next;
        }

        curr.next = tail;
        return curr;
    }

    int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
    }
}
