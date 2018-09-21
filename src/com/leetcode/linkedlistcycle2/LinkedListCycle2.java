package com.leetcode.linkedlistcycle2;

import com.leetcode.util.ListNode;

/**
 *
 * https://oj.leetcode.com/problems/linked-list-cycle-ii/
 *
 * Created by titan-developer on 8/17/14.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle2 {

    public static void main(String[] strings) {
        ListNode node = new ListNode(10);

        ListNode head = node;

        node.next = new ListNode(9);

        ListNode node9 = node.next;

        node = node.next;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(7);
        ListNode node7 = node.next;
        node = node.next;
        node.next = new ListNode(6);
        node = node.next;
        node.next = new ListNode(5);
        node = node.next;
        node.next = node7;

        LinkedListCycle2 linkedListCycle2 = new LinkedListCycle2();

        ListNode cycleNode = linkedListCycle2.detectCycle(head);
        System.out.println(cycleNode.val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head;

        while (first != null && second != null) {
            first = first.next;
            second = second.next;
            if (second != null) {
                second = second.next;
            }
            if (first == second) {
                break;
            }
        }

        if (second == null) {
            return null;
        }

        first = head;
        while (first != second) {
            first = first.next;
            second = second.next;
        }

        return second;
    }
}
