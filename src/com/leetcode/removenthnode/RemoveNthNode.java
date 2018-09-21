package com.leetcode.removenthnode;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 10/24/14.
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNode {

    public static void main(String[] strings) {

        ListNode head = ListNode.createList("1->2->3->4->5");

        RemoveNthNode remover = new RemoveNthNode();
        remover.removeNthFromEnd(head, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode k = head;
        int count = 0;
        ListNode current = head;
        while (current.next != null) {
            count ++;
            current = current.next;
            if (count > n) {
                k = k.next;
            }
        }

        if (count >= n) {
            k.next = k.next.next;
        } else if (count == n -1) {
            return k.next;
        }

        return head;
    }
}
