package com.leetcode.swapnodespairs;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 10/29/14.
 * https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public static void main(String[] strings) {
        ListNode head = ListNode.createList("1->2->3->4->5");

        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        head = swapNodesInPairs.swapPairs(head);

        ListNode.print(head);
    }

    public ListNode swapPairsNew(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curr = dummy;

        while(curr.next != null && curr.next.next != null) {
            ListNode first = curr.next;
            ListNode second = first.next;
            ListNode third = second.next;

            curr.next = second;
            second.next = first;
            first.next = third;
            curr = first;
        }
        return dummy.next;
    }

    public ListNode swapPairs(ListNode head) {

        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode start, a, b, end;
        start = fakeHead;
        while (start.next != null) {
            a = start.next;
            b = a.next;
            if (b == null) {
                break;
            } else {
                end = b.next;
                swap(start, a, b, end);
                start = a;
            }
        }

        return fakeHead.next;
    }

    private void swap(ListNode start, ListNode a, ListNode b, ListNode end) {
        start.next = b;
        b.next = a;
        a.next = end;
    }
}
