package com.leetcode.mergeksortedlists;

import com.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    public static void main(String[] strings) {
        ListNode head0 = ListNode.createList("2->4->6");

        ListNode head1 = ListNode.createList("1->3->5");

        ListNode head2 = ListNode.createList("2->6->7");

        List<ListNode> list = new ArrayList<ListNode>();
        list.add(head0);
        list.add(head1);
        list.add(head2);

        MergeKSortedLists merger = new MergeKSortedLists();

        ListNode head = merger.mergeKLists(list);

        ListNode.print(head);
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        } else if (lists.size() < 2) {
            return lists.get(0);
        }

        while (lists.size() > 1) {
            int size = lists.size();

            for (int i = size - 1; i >= 0; i--) {
                if (i >= 1) {
                    ListNode a = lists.get(i);
                    ListNode b = lists.get(i -1);

                    ListNode c = mergeList(a, b);
                    lists.remove(i);
                    lists.remove(i - 1);
                    lists.add(c);
                    i --;
                }
            }
        }

        return lists.get(0);
    }

    private ListNode mergeList(ListNode a, ListNode b) {
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
