package com.leetcode.copyrandomlist;

import java.util.HashMap;

/**
 * Created by titan-developer on 8/18/14.
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 *
 * Two solutions to read:
 * https://oj.leetcode.com/discuss/13841/easy-understand-solution-with-comments-constant-space-pass
 * https://oj.leetcode.com/discuss/76/does-anyone-have-a-better-idea
 *
 */
public class CopyRandomList {

    public static void main(String[] string) {

        RandomListNode head = new RandomListNode(0);
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);

        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head.random = node3;
        node1.random = node4;
        node2.random = head;
        node4.random = node2;

        CopyRandomList copyRandomList = new CopyRandomList();

        RandomListNode newHead = copyRandomList.copyRandomList(head);

        System.out.println(newHead.label);
    }


    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode newHead = new RandomListNode(head.label);
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, newHead);
        RandomListNode ori = head, dest = newHead;
        while (ori.next != null) {
            RandomListNode newNode = new RandomListNode(ori.next.label);
            map.put(ori.next, newNode);
            dest.next = newNode;
            dest = newNode;
            ori = ori.next;
        }

        ori = head;
        dest = newHead;
        while (ori != null) {
            if (ori.random != null) {
                dest.random = map.get(ori.random);
            }
            ori = ori.next;
            dest = dest.next;
        }
        return newHead;
    }

    public RandomListNode copyRandomListNeat(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode ori = head;
        while (ori != null) {
            RandomListNode copy = new RandomListNode(ori.label);
            RandomListNode next = ori.next;
            ori.next = copy;
            copy.next = next;
            ori = next;
        }
        ori = head;
        while (ori != null) {
            if (ori.random == null) {
                ori.next.random = null;
            } else {
                ori.next.random = ori.random.next;
            }
            ori = ori.next.next;
        }
        ori = head;
        RandomListNode newHead = ori.next;
        RandomListNode current = newHead;
        while (true) {
            ori.next = current.next;
            ori = ori.next;
            if (ori == null) {
                break;
            }
            current.next = ori.next;
            current = current.next;
        }

        return newHead;
    }

    /**
     * Definition for singly-linked list with a random pointer.
     */
    static class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
