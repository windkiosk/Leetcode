package com.leetcode.sortlinkedlist;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 8/8/14.
 */
public class SortLinkedList {

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
        SortLinkedList sortLinkedList = new SortLinkedList();

        for (int[] a : cases) {
            ListNode list = generateNode(a);
            printArray(sortLinkedList.sortList(list));
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

    class PartitionResult {
        ListNode leftHead;
        ListNode rightHead;
    }

    class SortResult {
        ListNode head;
        ListNode tail;
    }

    public ListNode sortList(ListNode head) {
        long curr = System.currentTimeMillis();
        SortResult result = quickSort(head);
        System.out.println("DB-Test --> " + (System.currentTimeMillis() - curr));
        return result == null ? null : result.head;
    }

    private SortResult quickSort(ListNode head) {
        if (head == null) {
            return null;
        }

        SortResult sortResult = new SortResult();
        if (head.next == null) {
            sortResult.head = head;
            sortResult.tail = head;
            return sortResult;
        }

        PartitionResult result = partition(head);
        SortResult leftResult = quickSort(result.leftHead);
        SortResult rightResult = quickSort(result.rightHead);
        ListNode newHead = head;
        ListNode newTail = head;
        if (leftResult != null) {
            newHead = leftResult.head;
            leftResult.tail.next = head;
        }

        if (rightResult != null) {
            head.next = rightResult.head;
            newTail = rightResult.tail;
        }

        sortResult.head = newHead;
        sortResult.tail = newTail;
        return sortResult;
    }

    private PartitionResult partition(ListNode head) {
        PartitionResult result = new PartitionResult();
        if (head == null || head.next == null) {
            result.leftHead = head;
            return result;
        }

        int pivotValue = head.val;
        ListNode currentLeft = null, currentRight = null, rightHead = null, leftHead = null;
        ListNode current = head.next;

        while (current != null) {
            if (current.val > pivotValue) {
                if (rightHead == null) {
                    rightHead = current;
                    currentRight = rightHead;
                } else {
                    currentRight.next = current;
                    currentRight = current;
                }
            } else {
                if (leftHead == null) {
                    leftHead = current;
                    currentLeft = leftHead;
                } else {
                    currentLeft.next = current;
                    currentLeft = current;
                }
            }
            current = current.next;

            if (currentLeft != null) {
                currentLeft.next = null;
            }

            if (currentRight != null) {
                currentRight.next = null;
            }
        }

        result.leftHead = leftHead;
        result.rightHead = rightHead;
        head.next = null;

        return result;
    }
}
