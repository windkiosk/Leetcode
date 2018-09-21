package com.leetcode.sortlinkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 8/9/14.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SolutionCorrect {

    private static int[][] cases = {
            {},
            {0},
            {0, 0},
            {0, 0, 0},
            {0, 1},
            {1, 0},
            {0, 1, 2},
            {0, 2, 1},
            {1, 0, 2},
            {1, 2, 0},
            {2, 0, 1},
            {2, 1, 0},
            {0, 1, 1},
            {1, 0, 1},
            {1, 1, 0},
            {3, 5, 1, 9, 8, 7, 4},
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
            {42, 9, 17, 54, 602, -3, 54, 999, -11},
            {-11, -3, 9, 17, 42, 54, 54, 602, 999},
    };

    public static void main(String[] strings) {
        SolutionCorrect solution = new SolutionCorrect();

        for (int[] a : cases) {
            ListNode list = generateNode(a);
            printArray(solution.sortList(list));
        }
    }

    private static void printArray(ListNode list) {
        if (list == null) {
            System.out.println("empty array");
        } else {
            System.out.println(list.val);
            while (list.next != null) {
                list = list.next;
                System.out.println(list.val);
            }
        }
        System.out.println("-----------");
    }

    private static ListNode generateNode(int[] a) {
        if (a == null || a.length == 0)
            return null;

        ListNode head = null;
        ListNode current = null;
        for (int value : a) {
            ListNode listNode = new ListNode(value);
            if (head == null) {
                head = listNode;
                current = listNode;
            } else {
                current.next = listNode;
                current = listNode;
            }
        }

        return head;
    }


    //------------------merge sort algorithm ----------------------
    ListNode move(ListNode head, int moveBy) {
        while (head != null && moveBy-- > 0)
            head = head.next;
        return head;
    }

    ListNode merge(ListNode loop, int length) {
        if (loop == null || loop.next == null)
            //this will help break the for loop in the sortList
            return null;
        ListNode start1 = loop.next;
        ListNode end1 = move(start1, length / 2 - 1);
        if (end1 == null)
            return null;
        ListNode start2 = end1.next;
        end1.next = null;
        ListNode end2 = move(start2, length / 2 - 1);
        ListNode end2next = (end2 != null) ? end2.next : null;
        if (end2next != null)
            end2.next = null;
        while (start1 != null || start2 != null) {
            if (start2 == null || (start1 != null && start1.val < start2.val)) {
                loop.next = start1;
                start1 = start1.next;
                loop = loop.next;
            } else {
                loop.next = start2;
                start2 = start2.next;
                loop = loop.next;
            }
        }
        loop.next = end2next;
        return loop;
    }

    ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (int k = 2; true; k *= 2) {
            int nMerges = 0;
            ListNode loop = dummy;
            while (loop != null && loop.next != null) {
                loop = merge(loop, k);
                nMerges++;
            }
            //only one sorted run?
            if (nMerges <= 1)
                break;
        }
        return dummy.next;
    }
}
