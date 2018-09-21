package com.leetcode.addtwonumber;

import com.leetcode.util.ListNode;

/**
 * Created by bod on 9/1/14.
 * https://oj.leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumber {

    public static void main(String[] strings) {
        ListNode a = ListNode.createList("2->4->3");
        ListNode b = ListNode.createList("5->6->4");

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(a, b);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode root = null;
            ListNode currentNode = null;
            boolean needCarryOver = false;
            while (l1 != null || l2 != null || needCarryOver) {
                if (root == null) {
                    root = new ListNode(0);
                    currentNode = root;
                } else {
                    ListNode nextNode = new ListNode(0);
                    currentNode.next = nextNode;
                    currentNode = nextNode;
                }

                int val = 0;
                if (needCarryOver) {
                    val++;
                    needCarryOver = false;
                }

                if (l1 != null) {
                    val += l1.val;
                    l1 = l1.next;
                }

                if (l2 != null) {
                    val += l2.val;
                    l2 = l2.next;
                }

                if (val >= 10) {
                    currentNode.val = val % 10;
                    needCarryOver = true;
                } else {
                    currentNode.val = val;
                }
            }

            return root;
        }
    }
}
