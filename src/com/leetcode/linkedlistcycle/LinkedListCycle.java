package com.leetcode.linkedlistcycle;

import com.leetcode.util.ListNode;

/**
 * https://oj.leetcode.com/problems/linked-list-cycle/
 *
 * Created by titan-developer on 8/18/14.
 * Given a linked list, determine if it has a cycle in it.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode normal = head;
        ListNode fast = head;

        while (fast != null && normal != null) {
            normal = normal.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }

            if (normal == fast) {
                return true;
            }
        }

        return false;
    }
}
