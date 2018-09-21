package com.leetcode.partitionlist;

import com.leetcode.util.ListNode;

/**
 * Created by titan-developer on 11/8/14.
 * https://oj.leetcode.com/problems/partition-list/
 */
public class PartitionList {

    public static void main(String[] strings) {
        //ListNode head = ListNode.createList("3->1->2");
        ListNode head = ListNode.createList("1->4->3->2->5->2");

        PartitionList partitionList = new PartitionList();
        ListNode newHead = partitionList.partition(head, 3);
        ListNode.print(newHead);
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);

        dummyNode.next = head;

        ListNode current = head, firstPart = dummyNode, lastNode = dummyNode;

        while (current != null) {
            ListNode next = current.next;
            if (current.val < x) {
                if (current != firstPart.next) {
                    ListNode tmp = firstPart.next;
                    firstPart.next = current;
                    current.next = tmp;
                    lastNode.next = next;
                }
                firstPart = current;
            } else {
                lastNode = current;
            }

            current = next;
        }

        return dummyNode.next;
    }
}
