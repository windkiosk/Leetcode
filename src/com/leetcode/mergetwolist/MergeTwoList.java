package com.leetcode.mergetwolist;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 10/31/14.
 * https://oj.leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoList {

    public static void main(String[] strings) {
        ListNode head0 = ListNode.createList("2->4->6");
        ListNode head1 = ListNode.createList("1->3->5->7->10");

        MergeTwoList merger = new MergeTwoList();

        ListNode mergedHead = merger.mergeTwoLists(head0, head1);

        while (mergedHead != null) {
            System.out.print(mergedHead.val + ", ");
            mergedHead = mergedHead.next;
        }
    }

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head, current;

        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        if (a.val < b.val) {
            head = a;
            a = a.next;
        } else {
            head = b;
            b = b.next;
        }

        current = head;
        while (a != null && b != null) {
            if (a.val < b.val) {
                current.next = a;
                a = a.next;
            } else {
                current.next = b;
                b = b.next;
            }
            current = current.next;
        }

        if (a != null) {
            current.next = a;
        } else {
            current.next = b;
        }

        return head;
    }
}
