package com.leetcode.util;

/**
 * Created by titan-developer on 8/8/14.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    //"1->1->2->3->3"
    public static ListNode createList(String state) {
        if (state == null || state.trim().length() == 0) {
            return new ListNode(-1);
        }

        int index = state.indexOf("->");
        int cursor = 0;
        ListNode head = null, last = null;
        if (index < 0) {
            head = new ListNode(Integer.valueOf(state));
        } else {
            while (index != -1) {
                String valStr = state.substring(cursor, index);
                ListNode temp = new ListNode(Integer.valueOf(valStr));
                if (head == null) {
                    head = temp;
                    last = temp;
                } else {
                    last.next = temp;
                    last = temp;
                }
                cursor = index + 2;
                index = state.indexOf("->", cursor);
            }

            if (last != null && cursor < state.length()) {
                String valStr = state.substring(cursor);
                last.next = new ListNode(Integer.valueOf(valStr));
            }
        }

        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }
}

