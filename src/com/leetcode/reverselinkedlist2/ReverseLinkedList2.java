package com.leetcode.reverselinkedlist2;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 11/9/14.
 * https://oj.leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {
    public static void main(String[] strings) {

        ListNode head = ListNode.createList("1->2->3->4->5");

        ReverseLinkedList2 reverselinklist = new ReverseLinkedList2();
        head = reverselinklist.reverseBetween(head, 2, 4);

        ListNode.print(head);
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode c = head;

        int count = 0;
        ListNode lastNode = dummyNode;

        ListNode startNode = dummyNode;
        boolean reversing = false;
        while (c != null) {
            count ++;

            ListNode next = c.next;
            if (reversing) {
                c.next = lastNode;
            }

            if (count == m) {
                startNode = lastNode;
                reversing = true;
            } else if (count == n) {
                ListNode startNext = startNode.next;
                startNode.next = c;
                startNext.next = next;
                break;
            }

            lastNode = c;
            c = next;
        }

        return dummyNode.next;
    }
}
